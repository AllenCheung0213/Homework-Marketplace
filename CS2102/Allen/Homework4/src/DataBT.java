class DataBT implements IBinTree {
 int data;
 IBinTree left;
 IBinTree right;
 
 DataBT(int data, IBinTree left, IBinTree right) {
  this.data = data;
  this.left = left;
  this.right = right;
 }
 
 // an alternate constructor for when both subtrees are empty
 DataBT(int data) {
   this.data = data;
   this.left = new MtBT();
   this.right = new MtBT();
 }

 // determines whether this node or node in subtree has given element
 public boolean hasElt(int e) {
  return this.data == e || this.left.hasElt(e) || this.right.hasElt(e) ;
 }

 // adds 1 to the number of nodes in the left and right subtrees
 public int size() {
  return 1 + this.left.size() + this.right.size();
 }

 // adds 1 to the height of the taller subtree
 public int height() {
  return 1 + Math.max(this.left.height(), this.right.height());
 }
 
/**
 * Intakes an int equal to or less than the least element in the heap and returns true if binary tree is a heap
 * 
 * @param int anInt -- an integer that should be equal to or less than the least value in the heap
 * @return True if the binary tree is a proper heap
 */
 public boolean isHeap(int anInt)
	{
		return(this.data >= anInt && this.left.isHeap(this.data) && this.right.isHeap(this.data));
	}
 
/**
 * 
 * Intakes an int and returns the number of times that int occurs in this DataBT
 * 
 * @param an int
 * @return number of times that int occurs in this DataBT
 */
 public int countOccurences(int aNum)
 {
	 if( aNum == this.data)
	 {
		 return 1 + left.countOccurences(aNum) + right.countOccurences(aNum);
	 } else {
		 return 0 + left.countOccurences(aNum) + right.countOccurences(aNum);
	 }
 }
 /**
  * Consumes an IHeap, an IBinTree, and an int. Checks to see if the IHeap with the addedElt occur the same number of times as
  * in the IBinTree
  * 
  * @param hOrig -- an IHeap representing the heap being added to
  * @param hAdded - an IBinTree representing the tree after the addition
  * @param addedElt -- an int the represents the element being added
  * @return True if both hOrig and hAdded share the same occurences of each element
  */
 public boolean checkOccurencesSame(IHeap hOrig, IBinTree hAdded, int addedElt)
 {
	 if(this.data==addedElt) {
		 return hOrig.countOccurences(this.data)+1 == hAdded.countOccurences(this.data) && this.left.checkOccurencesSame(hOrig, hAdded, addedElt) && this.right.checkOccurencesSame(hOrig, hAdded, addedElt);	  
	 }
	 return hOrig.countOccurences(this.data) == hAdded.countOccurences(this.data) && this.left.checkOccurencesSame(hOrig, hAdded, addedElt) && this.right.checkOccurencesSame(hOrig, hAdded, addedElt);	 
 }
 public boolean checkOccurencesSame2(IBinTree aDBT)
 {
	 return(this.countOccurences(this.data) == aDBT.countOccurences(this.data));
 }
}