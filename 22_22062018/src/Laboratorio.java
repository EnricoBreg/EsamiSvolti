
public class Laboratorio extends Corso {

	private String lab, assistente;
	private int posti;
	
	public Laboratorio(int codiceCorso, String tipo, String nomeCorso, String docente, String lab, String assistente,
			int posti) {
		// TODO Auto-generated constructor stub
		super(codiceCorso,tipo,nomeCorso,docente);
		this.lab = lab;
		this.assistente = assistente;
		this.posti = posti;
	}
	
	public String toString() {
		return super.toString() + "\t-\t-\t-\t" + lab + "\t" + assistente + "\t" + posti;
	}

}
