package jef.comparator;

import java.util.Comparator;

import jef.AppareilElectrique;

public class AppareilElectriqueComparatorParModelAsc implements Comparator<AppareilElectrique> {

	@Override
	public int compare(AppareilElectrique _c1, AppareilElectrique _c2) {
		return _c1.getModele().compareTo(_c2.getModele());
	}
}
