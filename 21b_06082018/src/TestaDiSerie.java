
public class TestaDiSerie extends Giocatore {
	
	private int ranking, eta;
	private boolean professionista;
	
	public TestaDiSerie(int codice, String tipo, String nomeCognome, int ranking, int eta, boolean professionista) {
		// TODO Auto-generated constructor stub
		super(codice,tipo,nomeCognome);
		this.ranking = ranking;
		this.eta = eta;
		this.professionista = professionista;
	}
	
	public String toString() {
		return super.toString() + " " + ranking + " " + eta + " " + professionista + "\t-\t-\t- ";
	}

}
