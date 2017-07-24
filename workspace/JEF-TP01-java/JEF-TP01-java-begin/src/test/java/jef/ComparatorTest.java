package jef;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {

	private static final List<AppareilElectrique> LISTE_APPAREILS = Arrays.asList(//
			new AppareilElectrique("Marque1", "ModelA", 20)//
			, new AppareilElectrique("Marque2", "ModelB", 30)//
			, new AppareilElectrique("Marque3", "ModelC", 40)//
			, new AppareilElectrique("Marque1", "ModelD", 50)//
			, new AppareilElectrique("Marque2", "ModelE", 60)//
			, new AppareilElectrique("Marque3", "ModelF", 20)//
			, new AppareilElectrique("Marque1", "ModelG", 30)//
			, new AppareilElectrique("Marque2", "ModelH", 40)//
			, new AppareilElectrique("Marque3", "ModelI", 50)//
			, new AppareilElectrique("Marque1", "ModelJ", 60)//
	);

	private static final List<AppareilElectriqueComparable> LISTE_APPAREILS_COMPARABLE = Arrays.asList(//
			new AppareilElectriqueComparable("Marque1", "ModelA", 20)//
			, new AppareilElectriqueComparable("Marque2", "ModelB", 30)//
			, new AppareilElectriqueComparable("Marque3", "ModelC", 40)//
			, new AppareilElectriqueComparable("Marque1", "ModelD", 50)//
			, new AppareilElectriqueComparable("Marque2", "ModelE", 60)//
			, new AppareilElectriqueComparable("Marque3", "ModelF", 20)//
			, new AppareilElectriqueComparable("Marque1", "ModelG", 30)//
			, new AppareilElectriqueComparable("Marque2", "ModelH", 40)//
			, new AppareilElectriqueComparable("Marque3", "ModelI", 50)//
			, new AppareilElectriqueComparable("Marque1", "ModelJ", 60)//
	);

	public static void main(String[] args) {

		// Comparator simple sur un champs
		// triEtAfficheListe(LISTE_APPAREILS, new
		// AppareilElectriqueComparatorParModelAsc());
		// triEtAfficheListe(LISTE_APPAREILS, new
		// AppareilElectriqueComparatorParModelDesc());
		// triEtAfficheListe(LISTE_APPAREILS, new
		// AppareilElectriqueComparatorParPuissanceMaxDesc());

		// Comparator sur 2 champs
		// triEtAfficheListe(LISTE_APPAREILS, new
		// AppareilElectriqueComparatorParMarquePuisModelDesc());

		// Utilisation de Comparable
		// System.out.println("\n\nTri naturel avec Comparable");
		// Collections.sort(LISTE_APPAREILS_COMPARABLE);
		// System.out.println(LISTE_APPAREILS_COMPARABLE);

	}

	private static void triEtAfficheListe(List<AppareilElectrique> list, Comparator<AppareilElectrique> comparator) {
		System.out.println("\n\nTri avec " + comparator.toString());
		Collections.sort(list, comparator);
		System.out.println(list);
	}

}
