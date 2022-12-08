
public class SoccerResult implements IResult{

	SoccerTeam SoccerTeam1;
	SoccerTeam SoccerTeam2;
	double team1Points;
	double team2Points;
	
	public SoccerResult(SoccerTeam soccerTeam1, SoccerTeam soccerTeam2, double team1Points, double team2Points) {
		this.SoccerTeam1 = SoccerTeam1;
		this.SoccerTeam2 = SoccerTeam2;
		this.team1Points = team1Points;
		this.team2Points = team2Points;
	}

	public boolean isValid()
	{
		return (150 > team1Points) && (150 > team2Points);
	}

	public IContestant getWinner() {
		if(team1Points > team2Points)
			return SoccerTeam1;
			return SoccerTeam2;		
	}

}
