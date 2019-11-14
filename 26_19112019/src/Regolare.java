
public class Regolare extends Partecipante {

	private String ente;
	private int numDip;
	private boolean accademico;

	public Regolare(int codice, String tipo, String nome, String cognome, String ente, int numDip, boolean accademico) {
		super(codice, tipo, nome, cognome);
		this.ente = ente;
		this.numDip = numDip;
		this.accademico = accademico;
	}
	
	public String toString() {
		return super.toString() + "\t-\t-\t- " + ente + " " + numDip + " " + accademico;
	}
}
