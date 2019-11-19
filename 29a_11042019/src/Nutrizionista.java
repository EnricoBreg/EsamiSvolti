
public class Nutrizionista extends Dipendente {

	private int telefono, appuntamenti;
	private boolean medico;
	private double costoOrario;
	
	public Nutrizionista(int codice, String tipo, String nominativo, int telefono, boolean medico, int appuntamenti,
			double costoOrario) {
		super(codice, tipo, nominativo);
		this.telefono = telefono;
		this.medico = medico;
		this.appuntamenti = appuntamenti;
		this.costoOrario = costoOrario;
	}
	
	public String toString() {
		return super.toString() + "\t-\t- " + telefono + " " +  medico + " " + appuntamenti + " " + costoOrario;
	}

}
