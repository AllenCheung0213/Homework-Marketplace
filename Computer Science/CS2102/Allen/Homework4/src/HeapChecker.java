/**
 * @author Allen Cheung, Timothy Stecko
 * Class to check if remMinElt and addElt are working
 */
public class HeapChecker {

	/**
	 * 
	 * @param hOrig -- The original IHeap being added to
	 * @param elt -- The int element being added to the heap
	 * @param hAdded -- The IBinTree which contains the binary tree result of the addElt
	 * @return True if the hAdded is a valid expected result of the addElt method
	 */
	boolean addEltTester(IHeap hOrig, int elt, IBinTree hAdded) {

		DataBT tempDBT = new DataBT(elt, hOrig, new MtHeap());
	    if(hAdded.isHeap(Integer.MIN_VALUE))
	    	if(hOrig.checkOccurencesSame(hOrig, hAdded,elt))
	    		if(tempDBT.countOccurences(elt) == hAdded.countOccurences(elt))
	    		return true;
	    return false;
	  }
	
	/**
     * checks if the heap with the removed element is the equal to the actual heap
     * @param hOrig original heap
     * @param hRemoved heap with root removed
     * @return true if they are the same false if otherwise
     */
    boolean remMinEltTester(IHeap hOrig, IBinTree hRemoved) {
        return hOrig.remMinElt().isHeap(Integer.MIN_VALUE) && hRemoved.isHeap(-99) && hOrig.remMinElt().checkOccurencesSame2(hRemoved);
    }
	
}
