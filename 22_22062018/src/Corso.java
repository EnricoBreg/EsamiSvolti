
public class Corso {
	
	private int codiceCorso;
	private String tipo, nomeCorso, docente;
	
	public Corso(int codiceCorso, String tipo, String nomeCorso, String docente) {
		// TODO Auto-generated constructor stub
		this.codiceCorso = codiceCorso;
		this.tipo = tipo;
		this.nomeCorso = nomeCorso;
		this.docente = docente;
	}
	
	public String toString() {
		return nomeCorso + "\t" + codiceCorso + "\t"+ docente +"\t" + tipo + "\t";
	}

}
