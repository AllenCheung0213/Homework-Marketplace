class MtBT implements IBinTree {
 MtBT(){}

 // returns false since empty tree has no elements
 public boolean hasElt(int e) {
  return false;
 }

 // returns 0 since enpty tree has no elements
 public int size() {
  return 0;
 }

 // returns 0 since empty tree has no branches
 public int height() {
  return 0;
 }

/**
 * Returns whether this MtBT is a heap
 * Always returns true because it is empty
 * 
 * @param int anInt
 * @return returns true
 */
 
 public boolean isHeap(int anInt)
 {
	 return true;
 }

/**
 * Returns how many occurrences of aNum there are in this MtBT
 * Always returns 0 because it is empty
 * 
 * @param int aNum
 * @return returns 0
 */
public int countOccurences(int aNum) {
	return 0;
}


/**
 * Returns whether this MtBT has the same occurrences of each element as DataBT aDBT
 * Returns false because this is an MtBT
 * 
 * @param int aNum
 * @return returns false
 */
public boolean checkOccurencesSame(DataBT aDBT) {
	return false;
}

public boolean checkOccurencesSame(IHeap hOrig, IBinTree hAdded,int addedElt) {
	return true;
}
public boolean checkOccurencesSame2(IBinTree aDBT) {
	return true;
}

}