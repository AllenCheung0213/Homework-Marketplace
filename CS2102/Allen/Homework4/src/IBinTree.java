import java.lang.Math;

interface IBinTree {
 // determines whether element is in the tree
 boolean hasElt(int e);
 // returns number of nodes in the tree; counts duplicate elements as separate items
 int size();
 // returns depth of longest branch in the tree
 int height();
//Determine if this is a heap
 boolean isHeap(int anInt);
// Determine the number of times the specified int occurs in the heap
 public int countOccurences(int aNum);
// Determines if the Heap and the Binary Tree share the same occurrences of their elements
 public boolean checkOccurencesSame(IHeap hOrig, IBinTree hAdded, int addedElt);
//Determines if the Heap and the Binary Tree share the same occurrences of their elements Alternate Implementation for remMinElt
 public boolean checkOccurencesSame2(IBinTree aDBT);
 
}
