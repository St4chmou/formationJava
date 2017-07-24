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
