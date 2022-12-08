/**
 * a class containing an exception for when an unknown candidate is added to ballot
 * @author trstecko && acheung
 *
 */
public class UnknownCandidateException extends Exception {
    private String name;

    // constructor
    UnknownCandidateException(String name){
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
