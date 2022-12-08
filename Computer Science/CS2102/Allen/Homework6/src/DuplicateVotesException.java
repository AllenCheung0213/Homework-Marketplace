/**
 * a class containing an exception for when duplicate votes are case
 * @author trstecko && acheung
 *
 */
public class DuplicateVotesException extends Exception {
    private String name;

    // constructor
    DuplicateVotesException(String name){
        this.name = name;
    }

    /**
     * gets the name of the candidate
     * @return name of the candidate
     */
    public String getName() {
        return this.getName();
    }
}
