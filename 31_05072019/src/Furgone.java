
public class Furgone extends Veicolo {
	
	private boolean rimorchio, vanoCarico;
	private int posti;
	
	public Furgone(int codice, String tipo, String targa, String modello, String marca, boolean rimorchio, int posti,
			boolean vanoCarico, double costoGiornaliero) {
		// TODO Auto-generated constructor stub
		super(codice, tipo, targa, modello, marca, costoGiornaliero);
		this.rimorchio = rimorchio;
		this.posti = posti;
		this.vanoCarico = vanoCarico;
	}
	
	public String toString() {
		return super.toString() + " \t-\t-\t- " + rimorchio + " " + posti + " " + vanoCarico;
	}

}
