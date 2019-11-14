
public class Pub extends Ristorante {
	
	private int numDipendenti, numTavoli;
	
	public Pub(int codice, String tipo, String nome, int numDipendenti, int numTavoli) {
		// TODO Auto-generated constructor stub
		super(codice,tipo,nome);
		this.numDipendenti = numDipendenti;
		this.numTavoli = numTavoli;
	}

	public String toString() {
		return super.toString() + "\t " + numDipendenti + "\t " + numTavoli + "\t-\t-\t- ";
	}
}
