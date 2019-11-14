
public class Studente extends Partecipante {

	private int annoCorso;
	private String uni;
	private String corso;

	public Studente(int codice, String tipo, String nome, String cognome, String corso, String uni, int annoCorso) {
		super(codice,tipo,nome,cognome);
		this.corso = corso;
		this.uni = uni;
		this.annoCorso = annoCorso;
	}
	
	public String toString() {
		return super.toString() + corso + " " + uni + " " + annoCorso + "\t-\t-\t- ";
	}

}
