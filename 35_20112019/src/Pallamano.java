
public class Pallamano extends Squadra {

	private int vittorie, sconfitte;
	private double mediaGoal;
	
	public Pallamano(int codice, String sport, String nomeSquadra,
			int vittorie, int sconfitte, double mediaGoal) {
		super(codice, sport, nomeSquadra);
		this.vittorie = vittorie;
		this.sconfitte = sconfitte;
		this.mediaGoal = mediaGoal;	
	}
	
	public int getVittorie(){
		return vittorie;
	}
	
	public String toString(){
		return super.toString() + vittorie + " " + sconfitte + " " + mediaGoal + "\t- " + super.getSport();
	}

}
