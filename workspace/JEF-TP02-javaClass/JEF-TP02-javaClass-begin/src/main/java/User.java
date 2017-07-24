
public class User {

	private String nom;

	public User(String nom) {
		super();
		this.nom = nom;
	}	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "User [nom=" + nom + "]";
	}

}
