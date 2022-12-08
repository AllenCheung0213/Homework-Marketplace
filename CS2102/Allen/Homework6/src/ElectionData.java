/**
 * a class handling the election process
 * @author trstecko && acheung
 *
 */
import java.util.LinkedList;
import java.util.Scanner;
import java.util.HashMap;

class ElectionData {
    private LinkedList<String> ballot = new LinkedList<String>();
    private LinkedList<String> votes = new LinkedList<String>();
    Scanner keyboard = new Scanner(System.in);
    private HashMap<String, Integer> hash1 = new HashMap<String, Integer>();
    private HashMap<String, Integer> hash2 = new HashMap<String, Integer>();
    private HashMap<String, Integer> hash3 = new HashMap<String, Integer>();

    ElectionData() {
        //this.ballot.add("Gompei");
        //this.ballot.add("Husky");
    }

    /**
     * returns the ballot
     * @return ballot
     */
    public LinkedList<String> getBallot(){
        return new LinkedList<String>(hash1.keySet());
    }

    /**
     * processes the votes
     * @param one String first candidate
     * @param two String second candidate
     * @param three String third  candidate
     * @throws UnknownCandidateException when there is an unknown candidate
     * @throws DuplicateVotesException when there is an 2 of the same candidate
     */
    public void processVote (String one, String two, String three)
            throws UnknownCandidateException, DuplicateVotesException {
        LinkedList<String> names = new LinkedList<>();
        names.add(one);
        names.add(two);
        names.add(three);
        for (String checkName : names) {
            if (hash1.containsKey(checkName) == false) {
                throw new UnknownCandidateException(checkName);
            }
        }
        if (one.equals(two)) {
            throw new DuplicateVotesException(one);
        }
        else if (one.equals(three)) {
            throw new DuplicateVotesException(one);
        }
        else if (two.equals(three)) {
            throw new DuplicateVotesException(two);
        }
        else {
            hash1.replace(one, (hash1.get(one)+1));
            hash2.replace(two, (hash2.get(two)+1));
            hash3.replace(three, (hash3.get(three)+1));
        }
    }

    /**
     * adds the candidate to the ballot
     * @param name name of the candidate
     * @throws CandidateExistsException when the candidate already exists
     */
    public void addCandidate(String name)throws CandidateExistsException{
        if (!hash1.containsKey(name)){
            hash1.put(name,0);
            hash2.put(name,0);
            hash3.put(name,0);
        }else{
            throw new CandidateExistsException(name);
        }
    }

    /**
     * prints the ballot
     */
    public void printBallot() {
        System.out.println("The candidates are ");
        for (String s : ballot) {
            System.out.println(s);
        }
    }

    /**
     * Is makes the interface work
     */
    public void screen() {
        this.printBallot();
        System.out.println("Who do you want to vote for?");
        String candidate = keyboard.next();
        votes.add(candidate);
        System.out.println("You voted for " + candidate);
    }

    /**
     * find the winner with the most votes
     * @return a name of the winner
     */
    public String findWinnerMostFirstVotes() {
        double total = 0;
        double highest = 0;
        String top = "none";
        boolean tie = false;
        LinkedList<String> listOfKeys = new LinkedList<String>(hash1.keySet());
        for (String name:listOfKeys) {
            total += hash1.get(name);
            if (hash1.get(name) == highest) {
                tie = true;
            }
            if (hash1.get(name)> highest) {
                highest = hash1.get(name);
                top = name;
                tie = false;
            }
        }
        if (tie) {
            return "Runoff required";
        }
        if ((highest/total) >= 0.5) {
            return top;
        }
        return "Runoff required";
    }

    /**
     * Finds the name of the winner with the most points
     * @return name of winner with the most points
     */
    public String findWinnerMostPoints() {
        LinkedList<String> listOfKeys = new LinkedList<String>(hash1.keySet());
        String top = "none";
        int mostPoints = 0;
        for(String name:listOfKeys) {
            int total;
            total = (hash1.get(name)*3)+(hash2.get(name)*2)+(hash3.get(name));
            if (total>=mostPoints) {
                mostPoints = total;
                top = name;
            }
        }
        return top;
    }
}
