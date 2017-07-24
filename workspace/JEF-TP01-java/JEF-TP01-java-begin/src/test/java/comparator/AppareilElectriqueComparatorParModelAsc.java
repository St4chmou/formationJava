package comparator;

import java.util.Comparator;

import jef.AppareilElectrique;

public class AppareilElectriqueComparatorParModelAsc implements Comparator<AppareilElectrique>{

	@Override
	public int compare(AppareilElectrique o1, AppareilElectrique o2) {
		return o1.getModele().compareTo(o2.getModele());
	}

}
