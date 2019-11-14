
public class Normale extends Giocatore {

	private String circolo;
	private int setVinti, partiteDisputate;
	public Normale(int codice, String tipo, String nomeCognome, String circolo, int setVinti, int partiteDisputate) {
		// TODO Auto-generated constructor stub
		super(codice,tipo,nomeCognome);
		this.circolo = circolo;
		this.setVinti = setVinti;
		this.partiteDisputate = partiteDisputate;
	}

	public String toString() {
		return super.toString() + "\t-\t-\t- " + " " + circolo + " " + setVinti + " " + partiteDisputate;
	}
}
