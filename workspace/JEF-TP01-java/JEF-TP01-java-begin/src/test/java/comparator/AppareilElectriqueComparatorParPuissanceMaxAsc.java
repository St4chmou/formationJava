package comparator;

import java.util.Comparator;

import jef.AppareilElectrique;

public class AppareilElectriqueComparatorParPuissanceMaxAsc implements Comparator<AppareilElectrique>{

	@Override
	public int compare(AppareilElectrique o1, AppareilElectrique o2) {
		return o1.getPuissanceMax() - o2.getPuissanceMax();
	}

}
