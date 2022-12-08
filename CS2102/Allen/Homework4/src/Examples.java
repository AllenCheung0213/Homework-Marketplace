/**
 * @author Allen Cheung, Timothy Stecko
 * Class to test methods
 */
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
public class Examples {
	HeapChecker HC = new HeapChecker();
	// Tests the AddEltMethod when the value is added properly. Should return true
	@Test
	public void testAddEltTestWhenCorrect()
	{
		IHeap originalHeap = new DataHeap(2, new DataHeap(4, new MtHeap(), new MtHeap()), new DataHeap(7, new DataHeap(8, new MtHeap(), new MtHeap()), new MtHeap()));
		IBinTree BTwithNine = new DataBT(2, new DataBT(4, new MtBT(), new MtBT()), new DataBT(7, new DataBT(8, new DataBT(9, new MtBT(), new MtBT()), new MtBT()), new MtBT()));
		assertTrue(HC.addEltTester(originalHeap, 9, BTwithNine));
	}
	// Tests the AddEltMethod when the order of the heap being added to is not correct. Should return false
	@Test
	public void testAddEltTestWhenIncorrect()
	{
		IHeap originalHeap = new DataHeap(2, new DataHeap(4, new MtHeap(), new MtHeap()), new DataHeap(7, new DataHeap(8, new MtHeap(), new MtHeap()), new MtHeap()));
		IBinTree BTwithNine = new DataBT(2, new DataBT(4, new MtBT(), new MtBT()), new DataBT(7, new DataBT(9, new DataBT(8, new MtBT(), new MtBT()), new MtBT()), new MtBT()));
		assertFalse(HC.addEltTester(originalHeap, 9, BTwithNine));
		
	}
	// Tests the AddEltMethod when the original heap has the same value as the heap being added to. Should return false.
	@Test
	public void testAddEltTestWhenSame()
	{
		IHeap originalHeap = new DataHeap(2, new DataHeap(4, new MtHeap(), new MtHeap()), new DataHeap(7, new DataHeap(8, new MtHeap(), new MtHeap()), new MtHeap()));
		IBinTree originalBT = new DataBT(2, new DataBT(4, new MtBT(), new MtBT()), new DataBT(7, new DataBT(8, new MtBT(), new MtBT()), new MtBT()));
		assertFalse(HC.addEltTester(originalHeap, 9, originalBT));
	}
	// Tests the AddEltMethod when the added to tree is smaller than it should be. Returns false
	@Test
	public void testAddEltTestWhenFewer()
	{
		IHeap originalHeap = new DataHeap(2, new DataHeap(4, new MtHeap(), new MtHeap()), new DataHeap(7, new DataHeap(8, new MtHeap(), new MtHeap()), new MtHeap()));
		IBinTree smallBT = new DataBT(2, new MtBT(), new MtBT());
		assertFalse(HC.addEltTester(originalHeap, 9, smallBT));
	}
	// Tests the AddEltMethod when a value is added to a heap already containing that value. Should return true
	@Test
	public void testAddEltTestWhenDuplicates()
	{
		IHeap originalHeap = new DataHeap(2, new DataHeap(4), new DataHeap(7, new DataHeap(8), new MtHeap()));
		IBinTree BTwithEight = new DataBT(2, new DataBT(4), new DataBT(7, new DataBT(8, new DataBT(8), new MtBT()), new MtBT()));
		assertTrue(HC.addEltTester(originalHeap, 8, BTwithEight));
	}
	// Tests the AddEltMethod when a value is added to a heap already containing multiple of that value. Should return true
	@Test
	public void testAddEltTestWhenManyDuplicates()
	{
		IHeap originalHeap = new DataHeap(2, new DataHeap(4), new DataHeap(8, new DataHeap(8), new MtHeap()));
		IBinTree BTwithEight = new DataBT(2, new DataBT(4), new DataBT(8, new DataBT(8, new DataBT(8), new MtBT()), new MtBT()));
		assertTrue(HC.addEltTester(originalHeap, 8, BTwithEight));
	}
	
	 DataHeap test1 = new DataHeap(5);
	    DataHeap test2 = new DataHeap(6);
	    DataHeap test12 = new DataHeap(100);
	    DataHeap test11 = new DataHeap(1000);
	    DataHeap test14 = new DataHeap(10000);
	    DataHeap test3 = new DataHeap(3, test1, test2);
	    DataHeap test4 = new DataHeap(2, test3, test2);
	    DataHeap test5 = new DataHeap(1, test3, test4);
	    DataHeap test10 = new DataHeap(5, test1, test1);
	    DataHeap test15 = new DataHeap(100, test11, test14);
	    DataHeap test16 = new DataHeap(100, test1, test2);
	    IBinTree test6 = test1.merge(test2);
	    IBinTree test7 = test3.merge(test2);
	    IBinTree test8 = test3.merge(test2).merge(test1);
	    IBinTree test9 = test1.merge(test1);
	    IBinTree test13 = test11.merge(test14);
	    IBinTree test17 = test12.merge(test2);
	    IBinTree test18 = test3.merge(test4);
	    IBinTree test19 = test5.remMinElt().remMinElt();
	    IBinTree test20 = test1.addElt(5).addElt(5);
	    IBinTree test21 = test3.merge(test2).addElt(2).addElt(3);

	    HeapChecker yes =new HeapChecker();

	    @Test
	    public void testRemEltTester_2nums(){
	        assertTrue(yes.remMinEltTester(test3,test6));
	    }
	    //total number of elements is incorrect
	    @Test
	    public void testRemEltTester_4nums(){
	        assertFalse(yes.remMinEltTester(test4,test21));
	    }
	    @Test
	    public void testRemEltTester_duplicates(){
	        assertTrue(yes.remMinEltTester(test10,test9));
	    }
	    @Test
	    public void testRemEltTester_test1BigNumber(){
	        assertTrue(yes.remMinEltTester(test15,test13));
	    }
	    //not a heap
	    @Test
	    public void testRemEltTester_testNotHeap(){
	        assertFalse(yes.remMinEltTester(test16,test17));
	    }
	    @Test
	    public void testRemEltTester_bigHeap(){
	        assertTrue(yes.remMinEltTester(test5,test18));
	    }
	    //removed elt occurs wrong number of times
	    @Test
	    public void testRemEltTester_abigHeap(){
	        assertFalse(yes.remMinEltTester(test5,test19));
	    }
	    //elts occur wrong number of times
	    @Test
	    public void testRemEltTester_anbigHeap(){
	        assertFalse(yes.remMinEltTester(test10,test20));
	    }
	    @Test
	    public void testNotHeap(){
	        assertFalse(test16.isHeap(-9999));
	    }
}
