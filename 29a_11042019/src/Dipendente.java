
public class Dipendente {
	
	private int codice, serviziSvolti;
	private String tipo, nominativo;
	
	public Dipendente(int codice, String tipo, String nominativo) {
		this.codice = codice;
		this.tipo = tipo;
		this.nominativo = nominativo;
		serviziSvolti = 0;
	}
	
	public void incServiziSvolti() {
		serviziSvolti++;
	}
	
	public int getServiziSvolti() {
		return serviziSvolti;
	}
	
	public String getNominativo(){
		return nominativo;
	}
	
	public String toString() {
		return nominativo + " " + codice + " " + tipo + " ";
	}

}
