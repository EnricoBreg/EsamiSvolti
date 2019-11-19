
import java.util.*;

public class Iscritto {

	private int codiceUtente;
	private String nome, cognome;
	private List<Spettacolo> visualizzazioni;
	
	public Iscritto(int codiceUtente, String nome, String cognome) {
		this.codiceUtente = codiceUtente;
		this.nome = nome;
		this.cognome = cognome;
		visualizzazioni = new LinkedList<Spettacolo>(); 
	}
	
	public void addVisualizzazione(Spettacolo s) {
		visualizzazioni.add(s);
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public List<Spettacolo> getVisualizzazioni() {
		return visualizzazioni;
	}
	
	public String toString() {
		return nome + " " + cognome + " " + visualizzazioni.size();
	}
	

}
