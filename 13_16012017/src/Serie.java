
public class Serie extends Spettacolo {
	
	private int stagione, numeroPuntate, annoUscita;
	private String produttore;
	
	public Serie(String titolo, int codice, String tipo, int stagione, int numeroPuntate, String produttore,
			int annoUscita) {
		super(titolo,codice,tipo);
		this.stagione = stagione;
		this.numeroPuntate = numeroPuntate;
		this.annoUscita = annoUscita;
		this.produttore = produttore;
	}
	
	public String toString() {
		return super.toString() + " " + stagione + " " + numeroPuntate + "\t- " + annoUscita + " " + produttore;
	}


}
