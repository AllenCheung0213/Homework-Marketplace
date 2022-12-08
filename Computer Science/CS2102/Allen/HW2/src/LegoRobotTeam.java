/**
 * Represents a lego robot team
 * @author acheung && trstecko
 */


public class LegoRobotTeam implements IContestant{
    String school;
    String teamName;
    int previous_score;
    public LegoRobotTeam(String school, String teamName, int previous_score) {
        this.school=school;
        this.teamName=teamName;
        this.previous_score=previous_score;
    }
    public boolean expectToBeat(LegoRobotTeam team2){
        return (this.previous_score>team2.previous_score);
    }
}
