
public class Giocatore {

	private int eta, numeroMaglia;
	private String cognome, nome, ruolo, squadra;
	private boolean titolare;
	
	public Giocatore(String cognome, String nome, int eta,
			int numeroMaglia, String ruolo, boolean titolare, String squadra) {
		this.cognome = cognome;
		this.nome = nome;
		this.eta = eta;
		this.numeroMaglia = numeroMaglia;
		this.ruolo = ruolo;
		this.titolare = titolare;
		this.squadra = squadra;
	}
	
	public String toString(){
		return nome + "\t" + cognome + "\t" + eta + "\t" + numeroMaglia + "\t" + ruolo + "\t" + titolare + "\t" + squadra;
	}

}
