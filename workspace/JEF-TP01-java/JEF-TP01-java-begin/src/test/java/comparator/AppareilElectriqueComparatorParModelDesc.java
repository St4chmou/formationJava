package comparator;

import java.util.Comparator;

import jef.AppareilElectrique;

public class AppareilElectriqueComparatorParModelDesc implements Comparator<AppareilElectrique>{

	@Override
	public int compare(AppareilElectrique o1, AppareilElectrique o2) {
		return o2.getModele().compareTo(o1.getModele());
	}

}
