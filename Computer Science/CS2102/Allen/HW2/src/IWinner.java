import java.util.LinkedList;

/**
 * represents both rounds
 * @author acheung & trstecko
 */
public interface IWinner {
    /**
     * Adds all the winners of the match to a new list
     * @return list of winners
     */
    public LinkedList<IContestant> getMatchWinners();

    /**
     *Looks to see if the contestant is a winner
     * @param acontestant contestant name we want to match
     * @return true if the contestant was a winner at least once
     */
    public boolean isWinner(IContestant acontestant);

}
