
import java.util.*;

public class Studente {

	private int matricola;
	private String nomeCognome;
	private List<Voto> libretto;
	
	public Studente(int matricola, String nomeCognome) {
		// TODO Auto-generated constructor stub
		this.matricola = matricola;
		this.nomeCognome = nomeCognome;
		libretto = new LinkedList<Voto>();
	}
	
	public void addVoto(Voto v) {
		libretto.add(v);
	}
	
	public String toString() {
		return nomeCognome +" "+ getMedia() +" "+ libretto;
	}

	private float getMedia() {
		// TODO Auto-generated method stub
		float media = 0;
		for (Voto v : libretto) {
			media += v.getVoto();
		}
		return media / libretto.size();
	}

	public String getNome() {
		// TODO Auto-generated method stub
		return nomeCognome;
	}

	public String getNomeCorsoEVotoMax() {
		// TODO Auto-generated method stub
		float votoMax = 0;
		String nomeCorso = null;
		for (Voto v : libretto) {
			if(v.getVoto() > votoMax) {
				votoMax = v.getVoto();
				nomeCorso = v.getNome();
			}
		}
		return nomeCorso + " " + votoMax;
	}

	/* public float getMax() {
		// TODO Auto-generated method stub
		float votoMax = 0;
		for (Voto v : libretto) {
			if(v.getVoto() > votoMax)
				votoMax = v.getVoto();
		}
		return votoMax;
	}*/

}
