
public class LegoRobotResult implements IResult{
	
	LegoRobotTeam robotTeam1;
	LegoRobotTeam robotTeam2;
	double pointsTeam1;
	int taskAttemptsTeam1;
	boolean fellDownTeam1;
	double pointsTeam2;
	int taskAttemptsTeam2;
	boolean fellDownTeam2;
	
	
	public LegoRobotResult(LegoRobotTeam robotTeam1, LegoRobotTeam robotTeam2, double pointsTeam1, int taskAttemptsTeam1, boolean fellDownTeam1,
			double pointsTeam2, int taskAttemptsTeam2, boolean fellDownTeam2)
	{
		this.robotTeam1 = robotTeam1;
		this.robotTeam2 = robotTeam2;
		this.pointsTeam1 = pointsTeam1;
		this.taskAttemptsTeam1 = taskAttemptsTeam1;
		this.fellDownTeam1 = fellDownTeam1;
		this.pointsTeam2 = pointsTeam2;
		this.taskAttemptsTeam2 = taskAttemptsTeam2;
		this.fellDownTeam2 = fellDownTeam2;
	}

	public boolean isValid() {
		return ((8 > taskAttemptsTeam1) && (8 > taskAttemptsTeam2) && (16 >= pointsTeam1) && (16 >= pointsTeam2));
	}

	public double getScore(double numPoints, int numTasks, boolean fellDown) {
		double score = 0;
		score = score + numPoints + numTasks;
		if(fellDown)
			score = score - 5;
		return score;
	}

	public IContestant getWinner() {
		if(getScore(pointsTeam1, taskAttemptsTeam1, fellDownTeam1) > getScore(pointsTeam2, taskAttemptsTeam2, fellDownTeam2))
			return robotTeam1;
			return robotTeam2;
	}

}
