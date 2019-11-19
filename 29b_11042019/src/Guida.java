
public class Guida extends Impiegato {

	private int telefono, apppuntamenti;
	private boolean inglese;
	private double costoOrario;
	
	public Guida(int codice, String tipo, String nominativo, int telefono, boolean inglese, int appuntamenti,
			double costoOrario) {
		super(codice,tipo,nominativo);
		this.telefono = telefono;
		this.apppuntamenti = appuntamenti;
		this.inglese = inglese;
		this.costoOrario = costoOrario;
	}
	
	public String toString() {
		return super.toString() + "\t-\t- " + telefono + " " + inglese + " " + apppuntamenti + " " + costoOrario;
	}
}
