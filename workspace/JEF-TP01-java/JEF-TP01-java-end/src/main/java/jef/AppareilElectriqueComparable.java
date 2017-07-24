package jef;

public class AppareilElectriqueComparable implements Comparable<AppareilElectriqueComparable> {

	private boolean enMarche;
	private int graduation;
	private String marque;
	private String modele;
	private int nbTotalGraduations;
	private int puissanceMax;
	private boolean securisable;
	private boolean securiteOk;
	private boolean variable;

	public AppareilElectriqueComparable() {
		super();
	}

	public AppareilElectriqueComparable(String marque, String modele, int puissanceMax) {
		super();
		this.marque = marque;
		this.modele = modele;
		this.puissanceMax = puissanceMax;
	}

	@Override
	public int compareTo(AppareilElectriqueComparable _c) {
		return this.getModele().compareTo(_c.getModele());
	}

	public int getGraduation() {
		return graduation;
	}

	public String getMarque() {
		return marque;
	}

	public String getModele() {
		return modele;
	}

	public int getNbTotalGraduations() {
		return nbTotalGraduations;
	}

	public int getPuissanceMax() {
		return puissanceMax;
	}

	public boolean isEnMarche() {
		return enMarche;
	}

	public boolean isSecurisable() {
		return securisable;
	}

	public boolean isSecuriteOk() {
		return securiteOk;
	}

	public boolean isVariable() {
		return variable;
	}

	public void setEnMarche(boolean enMarche) {
		this.enMarche = enMarche;
	}

	public void setGraduation(int graduation) {
		this.graduation = graduation;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public void setNbTotalGraduations(int nbTotalGraduations) {
		this.nbTotalGraduations = nbTotalGraduations;
	}

	public void setPuissanceMax(int puissanceMax) {
		this.puissanceMax = puissanceMax;
	}

	public void setSecurisable(boolean securisable) {
		this.securisable = securisable;
	}

	public void setSecuriteOk(boolean securiteOk) {
		this.securiteOk = securiteOk;
	}

	public void setVariable(boolean variable) {
		this.variable = variable;
	}

	@Override
	public String toString() {
		return "AppareilElectrique [marque=" + marque + ", modele=" + modele + ", puissanceMax=" + puissanceMax + "]";
	}

}
