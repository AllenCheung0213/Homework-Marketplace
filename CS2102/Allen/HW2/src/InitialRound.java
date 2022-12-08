import java.util.LinkedList;

/**
 * represents an initial round
 * @author acheung && trstecko
 */
public class InitialRound extends AbsRound implements IWinner{
    LinkedList<Match> matches = new LinkedList<Match>();

    public InitialRound(LinkedList<Match> matches) {
        //this.matches=matches;
    	super(matches);
    }

    /**
     *Looks to see if the contestant is a winner
     * @param acontestant contestant name we want to match
     * @return true if the contestant was a winner at least once this match
     */
    public boolean isWinner(IContestant acontestant) {
        int count = 0;
        for (IContestant thisContestant:this.getMatchWinners()){
            if(thisContestant.equals(acontestant)){
                count++;
            }
        }
        return count>1;
    }
}
