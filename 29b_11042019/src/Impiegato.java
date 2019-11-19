
public class Impiegato {

	private int codice, serviziSvolti;
	private String tipo, nominativo;
	
	public Impiegato(int codice, String tipo, String nominativo) {
		this.codice = codice;
		this.tipo = tipo;
		this.nominativo = nominativo;
		this.serviziSvolti = 0;
	}
	
	public void setServizio() {
		serviziSvolti++;
	}
	
	public int getNumeroServizi() {
		return serviziSvolti;
	}
	
	public String toString() {
		return nominativo + " " + codice + " " + tipo;
	}
}
