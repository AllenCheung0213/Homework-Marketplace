
public class SoccerTeam implements IContestant {

	String country;
	String jerseyColor;
	boolean hasRitual;
	int wins;
	int losses;
	

	public SoccerTeam(String country, String jerseyColor, boolean hasRitual, int wins, int losses) {
		this.country = country;
		this.jerseyColor = jerseyColor;
		this.hasRitual = hasRitual;
		this.wins = wins;
		this.losses = losses;
	}
	

	public boolean expectToBeat(SoccerTeam soccerTeamCheck) {
		// TODO Auto-generated method stub
		return false;
	}

}
