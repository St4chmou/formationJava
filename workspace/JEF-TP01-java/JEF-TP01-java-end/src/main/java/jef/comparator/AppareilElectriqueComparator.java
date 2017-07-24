package jef.comparator;

import java.util.Comparator;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import jef.AppareilElectrique;

public class AppareilElectriqueComparator implements Comparator<AppareilElectrique> {

	private enum Mode {
		marque, marqueEtModele, modele, puissanceMax
	}

	private enum Ordre {
		asc, desc
	}

	public static final AppareilElectriqueComparator PAR_MARQUE_ASC = new AppareilElectriqueComparator(Mode.marque,
			Ordre.asc);
	public static final AppareilElectriqueComparator PAR_MARQUE_DESC = new AppareilElectriqueComparator(Mode.marque,
			Ordre.desc);
	public static final AppareilElectriqueComparator PAR_MARQUE_ET_MODELE_ASC = new AppareilElectriqueComparator(
			Mode.marqueEtModele, Ordre.asc);
	public static final AppareilElectriqueComparator PAR_MARQUE_ET_MODELE_DESC = new AppareilElectriqueComparator(
			Mode.marqueEtModele, Ordre.desc);
	public static final AppareilElectriqueComparator PAR_MODELE_ASC = new AppareilElectriqueComparator(Mode.modele,
			Ordre.asc);
	public static final AppareilElectriqueComparator PAR_MODELE_DESC = new AppareilElectriqueComparator(Mode.modele,
			Ordre.desc);
	public static final AppareilElectriqueComparator PAR_PUISSANCE_MAX_ASC = new AppareilElectriqueComparator(
			Mode.puissanceMax, Ordre.asc);
	public static final AppareilElectriqueComparator PAR_PUISSANCE_MAX_DESC = new AppareilElectriqueComparator(
			Mode.puissanceMax, Ordre.desc);

	private Mode champ;
	private Ordre ordre;

	public AppareilElectriqueComparator(Mode champ, Ordre ordre) {
		this.champ = champ;
		this.ordre = ordre;
	}

	@Override
	public int compare(AppareilElectrique _c1, AppareilElectrique _c2) {
		HashCodeBuilder hcb1 = new HashCodeBuilder();
		HashCodeBuilder hcb2 = new HashCodeBuilder();

		if (Mode.marque.equals(this.champ) || Mode.marqueEtModele.equals(this.champ)) {
			hcb1.append(_c1.getMarque());
			hcb2.append(_c2.getMarque());
		}
		if (Mode.modele.equals(this.champ) || Mode.marqueEtModele.equals(this.champ)) {
			hcb1.append(_c1.getModele());
			hcb2.append(_c2.getModele());
		}
		if (Mode.puissanceMax.equals(this.champ)) {
			hcb1.append(_c1.getPuissanceMax());
			hcb2.append(_c2.getPuissanceMax());
		}

		int resultat = hcb1.toHashCode() - hcb2.toHashCode();
		if (Ordre.desc.equals(this.ordre)) {
			resultat *= -1;
		}
		return resultat;
	}

	@Override
	public String toString() {
		return "AppareilElectriqueComparator [champ=" + champ + ", ordre=" + ordre + "]";
	}
}
