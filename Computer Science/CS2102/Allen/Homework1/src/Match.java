
public class Match {
	IResult result;
    IContestant team1;
    IContestant team2;

	public Match(SoccerTeam soccerTeamCheck, SoccerTeam soccerTeamCheck2, SoccerResult soccerResultCheck) {
		// TODO Auto-generated constructor stub
	}

	public Match(LegoRobotTeam robotsTeamCheck, LegoRobotTeam robotsTeamCheck2, LegoRobotResult robotsResultCheck) {
		// TODO Auto-generated constructor stub
	}

	public IContestant winner() {
		if(this.result.isValid())
			return this.result.getWinner();
		return null;
	}

}
