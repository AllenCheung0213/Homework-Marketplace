

import java.util.Random;

class DataHeap extends DataBT implements IHeap {
 IHeap left;
 IHeap right;

 DataHeap(int data, IHeap left, IHeap right) {
  super (data, left, right);
  this.left = left;
  this.right = right;
 }

  // an alternate constructor for when both subheaps are empty
 DataHeap(int data) {
   super(data);
   this.left = new MtHeap();
   this.right = new MtHeap();
 }
 
 public IHeap merge(IHeap withHeap) {
  int newRoot;
  IHeap H1, H2, H3;

  // make sure withHeap isn't empty
  // we'd rather not use instanceOf here, but it makes the merge algorithm easier to see
  if (withHeap instanceof MtHeap) { return this; }
  // determine the new root value and the three subtrees to consider merging
  else if (withHeap.isBigger(this.data)) {
   newRoot = this.data;
   H1 = this.left;
   H2 = this.right;
   H3 = withHeap;
  } else {
   // Since a MtHeap will always return true on isBigger, satisfying
   //  the first condition, we know that withHeap is a DataHeap.
   //  Therefore, we can cast it.
   newRoot = ((DataHeap) withHeap).data;
   H1 = ((DataHeap) withHeap).left;
   H2 = ((DataHeap) withHeap).right;
   H3 = this;
  }
  
  // choose which trees to merge and construct the new tree
  if (H1.height() > H2.height() && H1.height() > H3.height()) {
   return new DataHeap (newRoot, H1, H2.merge (H3));
  } else if (H2.height() > H1.height() && H2.height() > H3.height()) {
   return new DataHeap (newRoot, H2, H1.merge (H3));
  } else if (H3.height() > H1.height() && H3.height() > H2.height()){
   return new DataHeap (newRoot, H3, H1.merge (H2));
  } else {
   // If the two bigger heaps are of the same size, choose one at random.
   Random coinFlip = new Random();
   if (H1.height() == H2.height()) {
    if (coinFlip.nextInt() % 2 == 1) {
     return new DataHeap (newRoot, H1, H2.merge(H3));
    } else {
     return new DataHeap (newRoot, H2, H1.merge(H3));
    }
   } else if (H2.height() == H3.height()) {
    if (coinFlip.nextInt() % 2 == 1) {
     return new DataHeap (newRoot, H2, H3.merge(H1));
    } else {
     return new DataHeap (newRoot, H3, H2.merge(H1));
    }
   } else {
    if (coinFlip.nextInt() %2 == 1) {
     return new DataHeap (newRoot, H3, H1.merge(H2));
    } else {
     return new DataHeap (newRoot, H1, H3.merge(H2));
    }
   }
  }
 }

 /**
 * 
 * Intakes an int and returns the number of times that int occurs in this DataHeap
 * 
 * @param an int
 * @return number of times that int occurs in this DataHeap
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
 * Consumes an IHeap, an IBinTree. Checks to see if the IHeap's elements occur the same number of times as
 * in the IBinTree
 * 
 * @param hOrig -- an IHeap representing the heap being added to
 * @param hAdded - an IBinTree representing the tree after the addition
 * @return True if both hOrig and hAdded share the same occurences of each element
 */
public boolean checkOccurencesSame(IHeap hOrig, IBinTree hAdded)
{
	 return hOrig.countOccurences(this.data) == hAdded.countOccurences(this.data) && this.left.checkOccurencesSame(hOrig, hAdded) && this.right.checkOccurencesSame(hOrig, hAdded);	 
}


 @Override
 public IHeap addElt(int e) {
  return this.merge(new DataHeap(e, new MtHeap(), new MtHeap()));
 }

 @Override
 public IHeap remMinElt() {
  return this.right.merge(this.left);
 }

 @Override
 public boolean isBigger(int e) {
  return (this.data >= e);
 }
}