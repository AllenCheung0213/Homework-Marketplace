
/**
 * a class for catching exceptions on Election Data
 * @author trstecko && acheung
 *
 */
import java.util.Scanner;

public class VotingMachine {
    Scanner scan = new Scanner(System.in);
    ElectionData ED;
   // constructor
    VotingMachine(){
        ED = new ElectionData();
    }

    /**
     * makes the interface that the user interacts with
     * @throws UnknownCandidateException when there is an unknown candidate
     * @throws DuplicateVotesException when there is an duplicate candidate
     * @throws CandidateExistsException when the candidate already exists
     */
    public void screen() throws UnknownCandidateException, DuplicateVotesException, CandidateExistsException {
        try {
            ED.printBallot();
            System.out.println("Round 1: Who do you vote?");
            String name1 = scan.next();
            System.out.println("Round 2: Who do you vote?");
            String name2 = scan.next();
            System.out.println("Round 3: Who do you vote?");
            String name3 = scan.next();
            System.out.println("You voted for: " + name1 +", "+name2+", and "+name3);
            ED.processVote(name1,name2,name3);
        }catch (UnknownCandidateException name){
            System.out.println(name.getName() + " is not on the ballot, would you like to add them? Y/N");
            String add = scan.next();
            if (add.equals("Y") || add.equals("y")){
                addWriteIn(name.getName());
                System.out.println("Candidate was added.");;
                screen();
            }
        }catch (DuplicateVotesException candidate) {
            System.out.println("You cannot vote for the same person twice.");
            screen();
        }
    }

    /**
     * Adds the name to the ballot
     * @param name name of the candidate
     * @throws CandidateExistsException when the candidate already exists
     */
    public void addWriteIn(String name) throws CandidateExistsException{
        try {
            ED.addCandidate(name);
            System.out.println("Added Successfully");
        }catch (CandidateExistsException ex){
            System.out.println(ex.getName()+" already exists");
        }
    }
}
