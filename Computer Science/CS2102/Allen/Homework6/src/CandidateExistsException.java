/**
 * a class containing an exception for when a candidate is added who is already on the ballot
 * @author trstecko && acheung
 *
 */
public class CandidateExistsException extends Exception {
    private String name;

    // constructor
    CandidateExistsException(String name){
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
