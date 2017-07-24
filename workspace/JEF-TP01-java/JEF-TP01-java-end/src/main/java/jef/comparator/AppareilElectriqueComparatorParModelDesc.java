package jef.comparator;

import java.util.Comparator;

import jef.AppareilElectrique;

public class AppareilElectriqueComparatorParModelDesc implements Comparator<AppareilElectrique> {

	@Override
	public int compare(AppareilElectrique _c1, AppareilElectrique _c2) {
		return _c2.getModele().compareTo(_c1.getModele());
	}
}
