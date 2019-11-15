
public class Noleggio {

	private int codice,durata;
	Veicolo veicolo;
	
	public Noleggio(int codice, int durata, Veicolo veicolo) {
		// TODO Auto-generated constructor stub
		this.codice = codice;
		this.durata = durata;
		this.veicolo = veicolo;
	}
	
	public double getCosto() {
		return veicolo.getCosto()*durata;
	}

	public String getTarga() {
		// TODO Auto-generated method stub
		return veicolo.getTarga();
	}
}
