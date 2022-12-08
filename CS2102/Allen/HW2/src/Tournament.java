import java.util.LinkedList;

/**
 * represents a tournament
 * @author acheung && trstecko
 */

public class Tournament {
    LinkedList<IWinner> matches = new LinkedList<IWinner>();

    public Tournament(LinkedList<IWinner> matches) {
        this.matches=matches;
    }

    /**
     * Checks to see if the contestant has won more than half of the matches
     * @param acontestant contestant name we want to match
     * @return true if the contestant has won more than half of the matches
     */
    public boolean finalWinnerIsValid(IContestant acontestant) {
        int count =0;
        
        for (IWinner winners: this.matches){
        	boolean hasWon = false;
            for (IContestant thisContestant:winners.getMatchWinners()){
                if(thisContestant.equals(acontestant)){
                    hasWon=true;
                }
            }
            if(hasWon){
                count++;
            }
        }
        return count>((matches.size())/2);
    }
}
