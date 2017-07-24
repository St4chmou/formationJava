package jef;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		Dao monDao = null;
		try {

			// Prépartion du dao
			String url = "jdbc:postgresql://localhost:5432/minibase";
			String utilisateur = "minibase";
			String motDePasse = "minibase";
			monDao = new Dao(url, utilisateur, motDePasse);

			// Test de DDL
			monDao.supprimerTable();
			monDao.creerUneTable();

			// Test DML de base
			monDao.insertionDeDonnees("unNom");
			monDao.modificationDeDonnees("unNom", "unNouveauNom");
			monDao.selectionDeDonnees("unNouveauNom");

			// Executer un script
			monDao.executeScript("unScriptDeCreation.sql", "UTF-8");
			monDao.executeScript("unScriptDeDonnees.sql", "UTF-8");
			monDao.executeScript("unScriptDeDestruction.sql", "UTF-8");

			// Aller plus loin
			monDao.insertionDeMasse();

		} catch (SQLException | ClassNotFoundException | IOException | URISyntaxException e) {
			LOG.error("Erreur à traiter ", e);
		}
	}

}
