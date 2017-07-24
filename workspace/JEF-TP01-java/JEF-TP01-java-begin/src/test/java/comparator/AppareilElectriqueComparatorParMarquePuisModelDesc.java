package comparator;

import java.util.Comparator;

import jef.AppareilElectrique;

public class AppareilElectriqueComparatorParMarquePuisModelDesc implements Comparator<AppareilElectrique> {

	@Override
	public int compare(AppareilElectrique o1, AppareilElectrique o2) {
		int diff = o1.getMarque().compareTo(o2.getMarque());
		if (diff == 0) {
			diff = o1.getModele().compareTo(o2.getModele());
		}
		return diff;
	}

}
