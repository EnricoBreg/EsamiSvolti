
public class Servizio {

	private double costoOrario,totale;
	private String nomeImpiegato;
	
	public Servizio(String nomeImpiegato, double costoOrario, double totale) {
		this.costoOrario = costoOrario;
		this.totale = totale;
		this.nomeImpiegato = nomeImpiegato;
	}
	
	public String toString() {
		return nomeImpiegato + " " + costoOrario + " " + totale;
	}

}
