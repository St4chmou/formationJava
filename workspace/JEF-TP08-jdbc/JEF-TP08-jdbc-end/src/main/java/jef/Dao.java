package jef;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Dao {

	private static final Logger LOG = LoggerFactory.getLogger(Dao.class);

	private final String motDePasse;
	private final String url;
	private final String utilisateur;

	public Dao(String url, String utilisateur, String motDePasse) throws ClassNotFoundException, SQLException {
		this.motDePasse = motDePasse;
		this.url = url;
		this.utilisateur = utilisateur;
	}

	/**
	 * Créer une table avec 3 colonnes : ID, NOM et ACTIF
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void creerUneTable() throws SQLException, ClassNotFoundException {
		// Types disponibles dans une base :
		// entier : BIGINT
		// chaine de caractères : CHARACTER VARYING(255)
		// booléen : BOOLEAN
		// suite : https://www.postgresql.org/docs/9.2/static/datatype.html

		String requete = "CREATE TABLE MA_TABLE (id BIGINT NOT NULL, nom CHARACTER VARYING(255), actif BOOLEAN NOT NULL)";

		// Ouverture de la connexion
		// Préparation de la requête
		// Avec fermeture automatique à la fin du try
		// En auto-commit = TRUE et donc pas de connection.commit() ou
		// connection.rollback()
		try (Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse);
				PreparedStatement pStmt = connection.prepareStatement(requete);) {

			// Execution
			LOG.debug("SQL : {}", pStmt);
			pStmt.execute();
		}

		// Log de fin (à conserver)
		LOG.info("Etape : creerUneTable - OK\n\n");

	}

	/**
	 * Charger un fichier et en exécuter toutes les requêtes
	 * 
	 * @param chemin
	 *            Chemin du fichier (présent dans le classpath donc il faut
	 *            utiliser ClassLoad.getSystemResource)
	 * @param encoding
	 *            Encoding du fichier si besoin
	 * @throws SQLException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public void executeScript(String chemin, String encoding) throws SQLException, IOException, URISyntaxException {

		// Lecture du fichier
		Path path = Paths.get(ClassLoader.getSystemResource(chemin).toURI());
		String requetes = String.join(";", Files.readAllLines(path, Charset.forName(encoding)));

		// Sans utiliser la fermeture automatique comme dans les autres méthodes
		// de cette classe, le nombre de lignes de code augmente !!!
		Connection connection = null;
		PreparedStatement pStmt = null;
		try {

			// Ouverture de la connexion
			connection = DriverManager.getConnection(url, utilisateur, motDePasse);

			// Desactivation de l'autocommit
			connection.setAutoCommit(false);

			// Préparation de la requête
			pStmt = connection.prepareStatement(requetes);

			// Execution
			LOG.debug("SQL : {}", pStmt);
			pStmt.execute();

			// Tentative de commit
			connection.commit();
		}

		// En cas d'erreur
		catch (SQLException e) {
			connection.rollback();
		}

		// Dans tous les cas, fin de la connexion (à la main pour disposer du
		// catch)
		finally {
			if (connection != null) {
				connection.close();
			}
			if (pStmt != null) {
				pStmt.close();
			}
		}

		// Log de fin (à conserver)
		LOG.info("Etape : executeScript - OK\n\n");
	}

	/**
	 * Insérer une ligne dans la table MA_TABLE (avec actif=true et id
	 * incrémenté automatiquement)
	 * 
	 * @param uneValeur
	 *            Valeur du nom
	 * @throws SQLException
	 */
	public void insertionDeDonnees(String uneValeur) throws SQLException {

		String requete = "INSERT INTO MA_TABLE (id, nom, actif) select count(*), ?, true from MA_TABLE";

		// Ouverture de la connexion
		// Avec fermeture automatique à la fin du try
		try (Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse);) {

			// Desactivation de l'autocommit
			connection.setAutoCommit(false);

			// Préparation de la requête
			try (PreparedStatement pStmt = connection.prepareStatement(requete);) {
				pStmt.setString(1, uneValeur);

				// Execution
				LOG.debug("SQL : {}", pStmt);
				pStmt.execute();

				// Tentative de rollback
				connection.commit();

			} catch (SQLException e) {
				connection.rollback();
				throw e;
			}
		}

		// Log de fin (à conserver)
		LOG.info("Etape : insertionDeDonnees - OK\n\n");
	}

	/**
	 * Créer une table puis insérer plusieurs lignes avec un seul 'insert', lire
	 * les lignes de la table et enfin la détruire
	 * 
	 * @throws SQLException
	 */
	public void insertionDeMasse() throws SQLException {

		// Requête utilisant la fonction 'generate_series' pour générer 300
		// valeur (de 1 à 300) dans genId
		// avec utilisation du modulo (%2) et de la transformation en boolean
		// pour obtenir une alternance TRUE/FALSE
		// et avec manipulation des dates et des cast pour générer 300 dates
		// consécutives
		String requeteInsertion = "INSERT INTO TEST_MASSE (id, nom, naissance, actif)" //
				+ " SELECT genId," //
				+ " 'Nom_' || genId," //
				+ " date '2001-09-28' + cast(genId||' day' as interval),"//
				+ " (genId % 2)::boolean" //
				+ " FROM generate_series(1, 300) AS genId";
		String requeteCreation = "CREATE TABLE TEST_MASSE (id BIGINT, nom CHARACTER VARYING(255), naissance timestamp, actif BOOLEAN)";
		String requeteDestruction = "DROP TABLE TEST_MASSE";
		String requeteSelection = "SELECT id, nom, naissance, actif FROM TEST_MASSE";

		// Ouverture de la connexion et fermeture automatique à la fin du try
		try (Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse)) {

			// Desactivation de l'autocommit
			connection.setAutoCommit(false);

			try (PreparedStatement pStmtCreation = connection.prepareStatement(requeteCreation);
					PreparedStatement pStmInsertiont = connection.prepareStatement(requeteInsertion);
					PreparedStatement pStmtSelection = connection.prepareStatement(requeteSelection);
					PreparedStatement pStmtDestruction = connection.prepareStatement(requeteDestruction);) {

				// Création de la table
				LOG.debug("SQL : {}", pStmtCreation);
				pStmtCreation.execute();

				// Insertion des données
				LOG.debug("SQL : {}", pStmInsertiont);
				pStmInsertiont.execute();

				// Lecture des données
				LOG.debug("SQL : {}", pStmtSelection);
				ResultSet rs = pStmtSelection.executeQuery();
				while (rs.next()) {
					LOG.debug("Résultats : id={}, nom={}, naissance={}, actif={}", rs.getLong(1), rs.getString(2),
							rs.getDate(3), rs.getBoolean(4));
				}

				// Destruction de la table
				LOG.debug("SQL : {}", pStmtDestruction);
				pStmtDestruction.execute();

				// Tentative de rollback
				connection.commit();

			} catch (SQLException e) {
				connection.rollback();
				throw e;
			}
		}

		// Log de fin (à conserver)
		LOG.info("Etape : insertionDeMasse - OK\n\n");
	}

	/**
	 * Modifier le NOM dans la table MA_TABLE
	 * 
	 * @param ancienneValeur
	 *            Ancienne valeur
	 * @param nouvelleValeur
	 *            Nouvelle valeur
	 * @throws SQLException
	 */
	public void modificationDeDonnees(String ancienneValeur, String nouvelleValeur) throws SQLException {

		String requete = "UPDATE MA_TABLE set nom = ? where nom = ?";

		// Ouverture de la connexion et fermeture automatique à la fin du try
		try (Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse)) {

			// Desactivation de l'autocommit
			connection.setAutoCommit(false);

			// Préparation de la requête
			try (PreparedStatement pStmt = connection.prepareStatement(requete);) {
				pStmt.setString(1, nouvelleValeur);
				pStmt.setString(2, ancienneValeur);

				// Execution
				LOG.debug("SQL : {}", pStmt);
				pStmt.execute();

				// Tentative de rollback
				connection.commit();

			} catch (SQLException e) {
				connection.rollback();
				throw e;
			}
		}

		// Log de fin (à conserver)
		LOG.info("Etape : modificationDeDonnees - OK\n\n");
	}

	/**
	 * Logger les valeurs de la(es) ligne(s) avec un nom=uneValeur
	 * 
	 * @param uneValeur
	 * @throws SQLException
	 */
	public void selectionDeDonnees(String uneValeur) throws SQLException {

		String requete = "SELECT id, nom, actif from MA_TABLE where nom = ?";

		// Ouverture de la connexion et fermeture automatique à la fin du try
		try (Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse)) {

			// Préparation de la requête
			try (PreparedStatement pStmt = connection.prepareStatement(requete);) {
				pStmt.setString(1, uneValeur);

				// Execution
				LOG.debug("SQL : {}", pStmt);
				ResultSet rs = pStmt.executeQuery();
				while (rs.next()) {
					LOG.debug("Résultats : id={}, nom={}, actif={}", rs.getLong(1), rs.getString(2), rs.getBoolean(3));
				}

			} catch (SQLException e) {
				connection.rollback();
				throw e;
			}
		}

		// Log de fin (à conserver)
		LOG.info("Etape : selectionDeDonnees - OK\n\n");
	}

	/**
	 * Supprimer la table MA_TABLE
	 */
	public void supprimerTable() {
		String requete = "DROP TABLE MA_TABLE";
		try (Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse);
				PreparedStatement pStmt = connection.prepareStatement(requete);) {
			LOG.debug("SQL : {}", pStmt);
			pStmt.execute();
		} catch (SQLException e) {
			LOG.error("Erreur à la suppression des tables", e);
		}

	}
}
