
public class Teoria extends Corso {

	private int codiceAula, oreSettimanali;
	private double oreLezione;
	
	public Teoria(int codiceCorso, String tipo, String nomeCorso, String docente, int codiceAula, double oreLezione,
			int oreSettimanali) {
		// TODO Auto-generated constructor stub
		super(codiceCorso,tipo,nomeCorso,docente);
		this.codiceAula = codiceAula;
		this.oreLezione = oreLezione;
		this.oreSettimanali = oreSettimanali;
	}
	
	public String toString() {
		return super.toString() + codiceAula + "\t" + oreSettimanali + "\t" + oreLezione + "\t" + "\t-\t-\t-"; 
	}
}
