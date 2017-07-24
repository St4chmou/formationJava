package jef.comparator;

import java.util.Comparator;

import jef.AppareilElectrique;

public class AppareilElectriqueComparatorParPuissanceMaxDesc implements Comparator<AppareilElectrique> {

	@Override
	public int compare(AppareilElectrique _c1, AppareilElectrique _c2) {
		return _c2.getPuissanceMax() - _c1.getPuissanceMax();
	}
}
