
public class Individuo extends Iscritto {
	
	private String nominativo, indirizzo, username, password;
	
	public Individuo(String tipo, int id, String nominativo, String indirizzo, String username,
			String password) {
		super(tipo, id);
		this.nominativo = nominativo;
		this.indirizzo = indirizzo;
		this.username = username;
		this.password = password;
	}

	public String getNominativo() {
		return nominativo;
	}
	
	public String toString() {
		return super.toString() + "\t" + nominativo + " " + "\t-\t- " + indirizzo + "\t "+ username + "\t " + password.length();
	}
}
