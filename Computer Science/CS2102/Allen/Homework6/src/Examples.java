/**
 * a class for testing ElectionData methods
 * @author trstecko && acheung
 *
 */
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class Examples {
    // method to set up a ballot and cast votes
    ElectionData Setup1 () {
        ElectionData ED = new ElectionData();
        // put candidates on the ballot
        try {
            ED.addCandidate("gompei");
            ED.addCandidate("husky");
            ED.addCandidate("ziggy");
        } catch (Exception e) {}
        // cast votes
        try {
            ED.processVote("gompei", "husky", "ziggy");
            ED.processVote("gompei", "ziggy", "husky");
            ED.processVote("husky", "gompei", "ziggy");
        } catch (Exception e) {}
        return(ED);
    }
    ElectionData Setup2 () {
        ElectionData ED = new ElectionData();
        // put candidates on the ballot
        try {
            ED.addCandidate("yes");
            ED.addCandidate("no");
            ED.addCandidate("maybe");
        } catch (Exception e) {}
        // cast votes
        try {
            ED.processVote("no","yes","maybe");
            ED.processVote("yes","no","maybe");
        } catch (Exception e) {}
        return(ED);
    }
    ElectionData Setup3 () throws UnknownCandidateException, DuplicateVotesException, CandidateExistsException{
        ElectionData ED = new ElectionData();
        // put candidates on the ballot
        try {
            ED.addCandidate("no");
            ED.addCandidate("yes");
            ED.addCandidate("maybe");
        } catch (Exception e) {}
        // cast votes
        try {
            ED.processVote("yes","hello","maybe");
            ED.processVote("no","yes","maybe");
        } catch (Exception e) {
            throw e;
        }
        return(ED);
    }
    ElectionData Setup4 () throws UnknownCandidateException, DuplicateVotesException, CandidateExistsException{
        ElectionData ED = new ElectionData();
        // put candidates on the ballot
        try {
            ED.addCandidate("no");
            ED.addCandidate("yes");
            ED.addCandidate("maybe");
        } catch (Exception e) {}
        // cast votes
        try {
            ED.processVote("yes","yes","yes");
            ED.processVote("no","yes","maybe");
        } catch (Exception e) {
            throw e;
        }
        return(ED);
    }
    ElectionData Setup5 () throws UnknownCandidateException, DuplicateVotesException, CandidateExistsException{
        ElectionData ED = new ElectionData();
        // put candidates on the ballot
        try {
            ED.addCandidate("no");
            ED.addCandidate("yes");
            ED.addCandidate("maybe");
            ED.addCandidate("maybe");
        } catch (Exception e) {
            throw e;
        }
        // cast votes
        try {
            ED.processVote("yes","yes","maybe");
            ED.processVote("no","yes","maybe");
        } catch (Exception e) {
            throw e;
        }
        return(ED);
    }
    // now run a test on a specific election
   // tests that when a candidate has the majority of first votes, that candidate wins
    @Test
    public void testMostFirstWinner () {
        assertEquals ("gompei", Setup1().findWinnerMostFirstVotes());
    }
    // tests that when no candidate has a majority for first votes, a runoff is triggered
    @Test
    public void testMostFirstWinner_Tie () {
        assertEquals ("Runoff required", Setup2().findWinnerMostFirstVotes());
    }
    // tests that when a runoff is required, the candidate with the most points wins
    @Test
    public void  textMostFirstWinnerPoints(){
        assertEquals("gompei", Setup1().findWinnerMostPoints());
    }
    // tests that when there is a tie for number of points, one of the valid candidates is winner
    @Test
    public void  textMostFirstWinnerPoints_Tie(){
        assertEquals("yes", Setup2().findWinnerMostPoints());
    }
    // tests that when an unknown candidate is added, the proper error throws
    @Test(expected=UnknownCandidateException.class)
    public void testUnknown() throws UnknownCandidateException, CandidateExistsException, DuplicateVotesException {
        Setup3().findWinnerMostPoints();
    }
    // tests that when there are duplicate votes, the proper error throws
    @Test(expected=DuplicateVotesException.class)
    public void testDuplicates() throws UnknownCandidateException, CandidateExistsException, DuplicateVotesException {
        Setup4().findWinnerMostPoints();
    }
    // tests that when there a candidate is added who already exists on the ballot
    @Test(expected=CandidateExistsException.class)
    public void testCandidateExists() throws UnknownCandidateException, CandidateExistsException, DuplicateVotesException {
        Setup5().findWinnerMostPoints();
    }
}
