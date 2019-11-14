import java.util.*;

public class Conferenza {

	private String nome;
	private String luogo;
	private List<Partecipazione> listaPartecipanti;
	
	public Conferenza(String nomeConferenza, String luogoConferenza) {
		// TODO Auto-generated constructor stub
		this.nome = nomeConferenza;
		this.luogo = luogoConferenza;
		listaPartecipanti = new LinkedList<Partecipazione>();
	}

	public int getTotale() {
		int totale = 0;
		for (Partecipazione p : listaPartecipanti) {
			totale += p.getCosto();
		}
		return totale;
	}
	
	public void addPartecipante(int costo, Partecipante p) {
		// TODO Auto-generated method stub
		Partecipazione part = new Partecipazione(costo,p);
		listaPartecipanti.add(part);
	}
	
	public String toString() {
		return luogo + "\n" + nome + "\n" + getTotale() +" "+listaPartecipanti.size() +"\n"+ listaPartecipanti;
	}
}
