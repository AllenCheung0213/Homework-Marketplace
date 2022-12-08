import java.util.LinkedList;

/**
 * represents an advanced round
 * @author acheung && trstecko
 */
public class AdvancedRound extends AbsRound implements IWinner{
    LinkedList<IContestant> previousWinners = new LinkedList<IContestant>();

    public AdvancedRound(LinkedList<Match> matches, LinkedList<IContestant> winners) {
    	super(matches);
        this.previousWinners=winners;
    }
    public boolean isWinner(IContestant acontestant) {
        int count = 0;
        for (IContestant thisContestant:previousWinners){
            if(thisContestant.equals(acontestant)){
                count++;
            }
        }
        return count>0;
    }

}
