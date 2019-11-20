
public class Hockey extends Squadra {

	private int vittorie, sconfitte;
	private double mediaGoal, mediaFalli;
	
	public Hockey(int codice, String sport, String nomeSquadra, int vittorie,
			int sconfitte, double mediaGoal, double mediaFalli) {
		super(codice, sport, nomeSquadra);
		this.vittorie = vittorie;
		this.sconfitte = sconfitte;
		this.mediaGoal = mediaGoal;
		this.mediaFalli = mediaFalli;
	}
	
	public int getVittorie(){
		return vittorie;
	}
	
	public String toString(){
		return super.toString() + vittorie + " " + sconfitte + " " + mediaGoal + " " + mediaFalli + " " + super.getSport();
	}

}
