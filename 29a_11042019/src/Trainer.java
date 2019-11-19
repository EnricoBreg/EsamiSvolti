
public class Trainer extends Dipendente {
	
	private int oreSettimanali;
	private double costoOrario;
	private String specialita;
	
	public Trainer(int codice, String tipo, String nominativo, int oreSettimanali, double costoOrario,
			String specialita) {
		super(codice, tipo, nominativo);
		this.costoOrario = costoOrario;
		this.oreSettimanali = oreSettimanali;
		this.specialita = specialita;
	}
	
	public String toString() {
		return super.toString() + oreSettimanali + " " + specialita + "\t-\t-\t- " + costoOrario; 
	}

}
