
public class Pallacanestro extends Squadra {
	
	private int vittorie, sconfitte, puntiTotali;
	private double mediaFalli;
	
	public Pallacanestro(int codice, String sport, String nomeSquadra, int vittorie, int sconfitte, double mediaFalli,
			int puntiTotali) {
		// TODO Auto-generated constructor stub
		super(codice,sport,nomeSquadra);
		this.vittorie = vittorie;
		this.sconfitte = sconfitte;
		this.mediaFalli = mediaFalli;
		this.puntiTotali = puntiTotali;
	}
	
	public String toString() {
		return super.toString() + vittorie + " " + sconfitte + puntiTotali + " " + mediaFalli + "\t- " + super.getSport();
	}
}
