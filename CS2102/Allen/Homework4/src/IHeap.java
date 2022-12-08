import java.util.Random;

interface IHeap extends IBinTree {
 // adds given element to the heap without removing other elements
 IHeap addElt(int e);
 
 // removes one occurrence of the smallest element from the heap
 IHeap remMinElt();
 
 // Merge the current heap with another heap
 IHeap merge(IHeap withHeap);
 
 // Determine if the root of this heap is bigger than the given element
 boolean isBigger(int e);
 
 // Determine if the heap and the binary tree share the same occurrences of their elements
 boolean checkOccurencesSame(IHeap hOrig, IBinTree hAdded);
}




