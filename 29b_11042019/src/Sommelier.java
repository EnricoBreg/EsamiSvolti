
public class Sommelier extends Impiegato {

	private int oreSettimanali;
	private double costoOrario;
	private String specialita;
	
	public Sommelier(int codice, String tipo, String nominativo, int oreSettimanali, double costoOrario,
			String specialita) {
		super(codice, tipo, nominativo);
		this.oreSettimanali = oreSettimanali;
		this.costoOrario = costoOrario;
		this.specialita = specialita;
	}
	
	public String toString() {
		return super.toString() + " " + oreSettimanali + " " + specialita + "\t-\t-\t- " + costoOrario;
	}
}
