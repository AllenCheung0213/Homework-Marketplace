import static org.junit.Assert.*;
import org.junit.Test;

public class Examples {

    public Examples(){}
    
    /*
    // This shows what a test case looks like
    @Test 
    public void simpleCheck() {
	assertEquals(4, 4);
    }
    */
    Shark SmallJaws = new Shark(5,0);
    Shark MediumJaws = new Shark(6,0);
    Shark BigJaws = new Shark(10,0);
    Shark BiggerJaws = new Shark(10,1);
    Shark BiggestJaws = new Shark(10,2);
    Fish NotDangerous = new Fish (7, 6.5);
    Boa ManEater = new Boa("Harvey", 6, "people");
    Boa Vegan = new Boa("Barnabas", 8, "Lettuce");
    Dillo Jeffrey = new Dillo(8, false);
    
    @Test public void checkSharkIsNormalSizeLesser() { assertFalse(SmallJaws.isNormalSize());}
    @Test public void checkSharkIsNormalSizeEqual() { assertTrue(MediumJaws.isNormalSize());}
    @Test public void checkSharkIsNormalSizeGreater() { assertTrue(BigJaws.isNormalSize());}
    @Test public void checkSharkIsDangerousLess() { assertFalse(BigJaws.isDangerToPeople());}
    @Test public void checkSharkIsDangerousEqual() { assertTrue(BiggerJaws.isDangerToPeople());}
    @Test public void checkSharkIsDangerousGreater() { assertTrue(BiggestJaws.isDangerToPeople());}
    @Test public void checkFishIsDangerous() { assertFalse(NotDangerous.isDangerToPeople());}
    @Test public void checkBoaIsDangerousFalse() { assertFalse(Vegan.isDangerToPeople());}
    @Test public void checkBoaIsDangerousTrue() { assertTrue(ManEater.isDangerToPeople());}
    @Test public void checkDilloIsDangerous() { assertFalse(Jeffrey.isDangerToPeople());}
}

