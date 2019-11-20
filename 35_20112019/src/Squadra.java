
public class Squadra {

	private int codice;
	private String sport, nomeSquadra;
	
	public Squadra(int codice, String sport, String nomeSquadra) {
		this.codice = codice;
		this.sport = sport;
		this.nomeSquadra = nomeSquadra;
	}

	public String getSport(){
		return sport;
	}
	
	public String toString(){
		return nomeSquadra + " " + codice + " ";
	}
	
}
