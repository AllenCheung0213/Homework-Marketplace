/**
 * Represents a match in a competition
 * @author acheung && trstecko
 */

public class Match {
    IResult result;
    IContestant team1;
    IContestant team2;

    public Match(IContestant team1, IContestant team2, IResult result) {
        this.team1=team1;
        this.team2=team2;
        this.result=result;
    }

    public IContestant winner(){
        if(this.result.isValid()){
            return this.result.getWinner();
        }else{
            return null;
        }
    }
}
