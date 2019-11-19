
public class Spettacolo {

	private String titolo, tipo;
	private int codice;
	
	public Spettacolo(String titolo, int codice, String tipo) {
		this.codice = codice;
		this.titolo = titolo;
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public String getTitolo() {
		return titolo;
	}
	
	public String toString() {
		return tipo + " " + titolo + " " + codice;
	}
}
