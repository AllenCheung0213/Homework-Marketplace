
/**
 * Represents a round result in a lego robot competition
 * @author acheung && trstecko
 */


public class LegoRobotResult implements IResult{
    IContestant team1;
    IContestant team2;
    double team1points;
    double team2points;
    int team1tasks;
    int team2tasks;
    boolean team1fell;
    boolean team2fell;

    public LegoRobotResult(IContestant team1, IContestant team2,
                    double team1points, int team1tasks, boolean team1fell,
                    double team2points, int team2tasks, boolean team2fell) {
        this.team1=team1;
        this.team2=team2;
        this.team1points=team1points;
        this.team2points=team2points;
        this.team1tasks=team1tasks;
        this.team2tasks=team2tasks;
        this.team1fell=team1fell;
        this.team2fell=team2fell;
    }
    public boolean isValid(){
        return ((team1tasks < 8 &&team2tasks < 8) && team1points<=16 && team2points<=16);
    }
    public double getScore(double points, int tasks, boolean fell){
        if(fell){
            return (points+tasks-5);
        }else{
            return (points+tasks);
        }
    }

    public IContestant getWinner(){
        if (getScore(team1points, team1tasks, team1fell)> getScore(team2points,team2tasks,team2fell)){
            return team1;
        }else{
            return team2;
        }
    }
}
