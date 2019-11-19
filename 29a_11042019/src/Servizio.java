
public class Servizio {

	private double durata, costoOrario;
	
	public Servizio(double durata, double costoOrario) {
		this.durata = durata;
		this.costoOrario = costoOrario;
	}
	
	public double getDurata() {
		return durata;
	}
	
	public double getCosto() {
		return costoOrario;
	}
}
