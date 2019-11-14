
import java.util.*;

public class Squadra {
	
	private int codice;
	private String sport, nomeSquadra;
	private List<Giocatore> giocatori;
	
	public Squadra(int codice, String sport, String nomeSquadra) {
		// TODO Auto-generated constructor stub
		this.codice = codice;
		this.nomeSquadra = nomeSquadra;
		this.sport = sport;
		giocatori = new LinkedList<Giocatore>();
	}
	
	public void addGiocatore(Giocatore g) {
		giocatori.add(g);
	}
	
	public String getSport() {
		return sport;
	}
	
	public String getNome() {
		return nomeSquadra;
	}
	
	public int getNumeroGiocatori() {
		return giocatori.size();
	}
	
	public String toString() {
		return nomeSquadra + " " + codice+ " ";
	}
	
}
