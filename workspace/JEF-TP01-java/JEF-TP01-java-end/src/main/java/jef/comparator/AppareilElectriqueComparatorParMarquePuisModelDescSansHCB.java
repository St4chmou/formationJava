package jef.comparator;

import java.util.Comparator;

import jef.AppareilElectrique;

public class AppareilElectriqueComparatorParMarquePuisModelDescSansHCB implements Comparator<AppareilElectrique> {

	@Override
	public int compare(AppareilElectrique _c1, AppareilElectrique _c2) {
		int resultat = 0;

		// Cas de MARQUE null
		if (_c2.getMarque() == null && _c1.getMarque() != null) {
			resultat = -1;
		}

		else {
			// Comparaison de la marque
			resultat = _c2.getMarque().compareTo(_c1.getMarque());

			// Si MARQUE egales
			if (resultat == 0) {

				// Cas de MODELE null
				if (_c2.getModele() == null && _c1.getModele() != null) {
					resultat = -1;
				} else {
					resultat = _c2.getModele().compareTo(_c1.getModele());
				}
			}
		}
		return resultat;
	}
}
