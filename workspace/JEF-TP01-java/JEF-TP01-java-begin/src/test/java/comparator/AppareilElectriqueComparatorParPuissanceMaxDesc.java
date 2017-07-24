package comparator;

import java.util.Comparator;

import jef.AppareilElectrique;

public class AppareilElectriqueComparatorParPuissanceMaxDesc implements Comparator<AppareilElectrique>{

	@Override
	public int compare(AppareilElectrique o1, AppareilElectrique o2) {
		return o2.getPuissanceMax() - o1.getPuissanceMax();
	}

}
