
public class Azienda extends Iscritto {

	private String ragioneSociale, indirizzo, gestore, username, password;
	
	public Azienda(String tipo, int id, String ragioneSociale, String indirizzo, String gestore, String username,
			String password) {
		super(tipo, id);
		this.ragioneSociale = ragioneSociale;
		this.indirizzo = indirizzo;
		this.gestore = gestore;
		this.username = username;
		this.password = password;
	}
	
	public String getRagioneSociale() {
		return ragioneSociale;
	}
	
	public String toString() {
		return super.toString() + "\t "+ragioneSociale+"\t"+gestore+"\t"+indirizzo+"\t"+username+"\t"+password.length();
	}

}
