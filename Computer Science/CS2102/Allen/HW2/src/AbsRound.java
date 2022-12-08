import java.util.LinkedList;

/**
 * Represents a round
 * @author acheung && trstecko
 */
public abstract class AbsRound {
    LinkedList<Match> matches = new LinkedList<Match>();

    public AbsRound(LinkedList<Match> matches)
    {
    	this.matches = matches;
    }
    
    /**
     * Adds all the winners of the match to a new list
     * @return list of winners
     */
    public LinkedList<IContestant> getMatchWinners() {
        LinkedList<IContestant> winners = new LinkedList<IContestant>();
        for (Match thisMatch: this.matches) {
            if(thisMatch.winner()!= null){
                winners.add(thisMatch.winner());
            }
        }
        return winners;
    }

    /**
     * Counts the number of winners in a match
     * @return the number of winners
     */
    public int getNumWinners() {
        int count=0;
        for (IContestant thisContestant:this.getMatchWinners()){
            count++;
        }
        return count;
    }

    /**
     *Looks to see if the contestant is a winner
     * @param acontestant contestant name we want to match
     * @return true if the contestant was a winner at least once
     */
    public boolean isWinner(IContestant acontestant) {
        int count = 0;
        for (IContestant thisContestant:this.getMatchWinners()){
            if(thisContestant.equals(acontestant)){
                count++;
            }
        }
        return count>0;
    }
}
