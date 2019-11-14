
import java.util.*;

public class Giocatore {

	private int codice, vittorie;
	private String tipo,nomeCognome;
	private List<Partita> incontriDisputati;
	
	public Giocatore(int codice, String tipo, String nomeCognome) {
		// TODO Auto-generated constructor stub
		this.codice = codice;
		this.tipo = tipo;
		this.nomeCognome = nomeCognome;
		this.vittorie = 0;
		incontriDisputati = new LinkedList<Partita>();
	}
	
	public void addPartita(Partita p) {
		incontriDisputati.add(p);
	}
	
	public List<Partita> getPartite(){
		return incontriDisputati;
	}
	
	public String toString() {
		return nomeCognome + " " + codice + " " + tipo + " ";
	}

	public void addVittorie(int v) {
		vittorie = v;
	}
	
	public int getVittorie() {
		return vittorie;
	}
	
	public String getNome() {
		// TODO Auto-generated method stub
		return nomeCognome;
	}
}
