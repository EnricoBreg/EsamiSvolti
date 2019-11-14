
public class Partita {
	
	private int giocatore1, giocatore2;
	private int punti1, punti2;
	
	public Partita(int giocatore1, int giocatore2, int punti1, int punti2) {
		this.giocatore1 = giocatore1;
		this.giocatore2 = giocatore2;
		this.punti1 = punti1;
		this.punti2 = punti2;
	}
	
	public int getPunti1() {
		return punti1;
	}
	
	public int getPunti2() {
		return punti2;
	}
	
	public String toString() {
		return giocatore2 + ":" + punti1 + "-"+punti2; 
	}
}
