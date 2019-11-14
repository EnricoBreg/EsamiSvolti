
public class Partecipazione {
	
	private Partecipante p;
	private int costo;
	
	public Partecipazione(int costo, Partecipante p) {
		this.p = p;
		this.costo = costo;
	}
	
	public int getCosto() {
		return costo;
	}
	
	public String toString() {
		return p.getCognome() + " " + costo;
	}
}
