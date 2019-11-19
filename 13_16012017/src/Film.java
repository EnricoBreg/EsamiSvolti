
public class Film extends Spettacolo {

	private int durata, annoUscita;
	private String produttore;
	
	public Film(String titolo, int codice, String tipo, int durata, String produttore, int annoUscita) {
		super(titolo, codice, tipo);
		this.annoUscita = annoUscita;
		this.produttore = produttore;
		this.durata = durata;
	}

	public String toString() {
		return super.toString() + "\t-\t- " + durata + " " + annoUscita + " " + produttore;
	}
}
