
public class Giocatore {
	
	private int codiceSquadra, numeroMaglia, eta;
	private String cognome, nome, ruolo, nomeSquadra;
	private boolean titolare;
	
	public Giocatore(int codiceSquadra, String nomeSquadra, String cognome, String nome, boolean titolare, int eta, int numeroMaglia,
			String ruolo) {
		// TODO Auto-generated constructor stub
		this.codiceSquadra = codiceSquadra;
		this.nomeSquadra = nomeSquadra;
		this.cognome = cognome;
		this.nome = nome;
		this.eta = eta;
		this.titolare = titolare;
		this.numeroMaglia = numeroMaglia;
		this.ruolo = ruolo;
	}
	
	public String toString() {
		return nome + " " + cognome + " " + eta + " " + numeroMaglia + " " + ruolo + " " + nomeSquadra;
	}

}
