import static org.junit.Assert.*;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

public class Examples {

	LinkedList<Double> listOfReadings1 = new LinkedList<Double>() {{
		add(1.0);
		add(2.5);
		add(-2.5);
		add(-999.0);
	}};
	// testing rainfall with a mix of positives and negatives
	@Test public void checkRainfallMix(){assertEquals(Planning.rainfall(listOfReadings1), 1.75, 0.1);}
	
	LinkedList<Double> listOfReadings2 = new LinkedList<Double>() {{
		add(-1.0);
		add(-2.0);
		add(-3.0);
		add(-999.0);
	}};
	// testing rainfall with just negatives
	@Test public void checkRainfallNeg(){assertEquals(Planning.rainfall(listOfReadings2), -1.0 , 0.1); }
	//
	
	LinkedList<Double> listOfReadings3 = new LinkedList<Double>() {{
		add(-999.0);
	}};
	// testing rainfall with just -999
	@Test public void checkRainfall999(){assertEquals(Planning.rainfall(listOfReadings3), -1.0 , 0.1); }
	
	LinkedList<Double> listOfReadings4 = new LinkedList<Double>() {{
		add(-999.0);
		add(1.0);
		add(2.5);
		add(-2.5);
	}};
	// testing rainfall with -999 and then others. Should be same as just -999
	@Test public void checkRainfall999Plus(){assertEquals(Planning.rainfall(listOfReadings4), -1.0 , 0.1); }
	
	LinkedList<Double> listOfReadings5 = new LinkedList<Double>() {{
		add(1.0);
		add(2.0);
		add(3.0);
	}};
	// testing rainfall without -999
	@Test public void checkRainfallNo999(){assertEquals(Planning.rainfall(listOfReadings5), 2.0 , 0.1); }
	
	
	
}
