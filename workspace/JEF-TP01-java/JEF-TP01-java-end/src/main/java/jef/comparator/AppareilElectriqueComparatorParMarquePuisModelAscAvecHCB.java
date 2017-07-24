package jef.comparator;

import java.util.Comparator;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import jef.AppareilElectrique;

public class AppareilElectriqueComparatorParMarquePuisModelAscAvecHCB implements Comparator<AppareilElectrique> {

	@Override
	public int compare(AppareilElectrique _c1, AppareilElectrique _c2) {
		HashCodeBuilder hcb1 = new HashCodeBuilder();
		HashCodeBuilder hcb2 = new HashCodeBuilder();

		hcb1.append(_c1.getMarque());
		hcb2.append(_c2.getMarque());
		hcb1.append(_c1.getModele());
		hcb2.append(_c2.getModele());

		return hcb1.toHashCode() - hcb2.toHashCode();
	}
}
