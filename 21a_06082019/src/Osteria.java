
public class Osteria extends Ristorante {
	
	private int numPosti;
	private double superficie;
	private boolean disabili;
	
	public Osteria(int codice, String tipo, String nome, int numPosti, double superficie, boolean disabili) {
		// TODO Auto-generated constructor stub
		super(codice,tipo,nome);
		this.numPosti = numPosti;
		this.superficie = superficie;
		this.disabili = disabili;
	}
	
	public String toString() {
		return super.toString() + "\t-\t- " + numPosti + "\t " + superficie + "\t " + disabili;
	}
}
