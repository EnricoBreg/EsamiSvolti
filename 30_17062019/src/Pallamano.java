
public class Pallamano extends Squadra {

	private int vittorie, sconfitte;
	private double mediaGoal;
	
	public Pallamano(int codice, String sport, String nomeSquadra, int vittorie, int sconfitte, double mediaGoal) {
		// TODO Auto-generated constructor stub
		super(codice, sport, nomeSquadra);
		this.vittorie = vittorie;
		this.sconfitte = sconfitte;
		this.mediaGoal = mediaGoal;
	}
	
	public String toString() {
		return super.toString() + vittorie + " " + sconfitte + " " + "\t-" + mediaGoal + " " + super.getSport();
	}
}
