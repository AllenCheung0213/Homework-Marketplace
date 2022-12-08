import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.LinkedList;

/**
 * 
 * @author trstecko && acheung
 * EarthquakeExamples handles a host of testcases for Earthquake1 and Earthquake2 methods
 *
 */

public class EarthquakeExamples {
  Earthquake1 E1 = new Earthquake1();
  Earthquake1 E2 = new Earthquake1();
  LinkedList<Double> noData = new LinkedList<Double>();
  LinkedList<Double> threeDates = new LinkedList<Double>();  
  LinkedList<MaxHzReport> NovReports = new LinkedList<MaxHzReport>();
  
 
  public EarthquakeExamples() {
    threeDates.add(20151013.0);
    threeDates.add(10.0);
    threeDates.add(5.0);
    threeDates.add(20151020.0);
    threeDates.add(40.0);
    threeDates.add(50.0);
    threeDates.add(45.0);
    threeDates.add(20151101.0);
    threeDates.add(6.0);
    NovReports.add(new MaxHzReport(20151101.0,6.0));
  }

  @Test
  public void instructorTestEQ() { 
    assertEquals(NovReports, 
                E1.dailyMaxForMonth(threeDates, 11));
	//   
  }
  
  @Test
  // Tests that the Earthquake1 dailyMaxForMonth returns the expected values with multiple readings within 1 month
  public void multipleDatesInAMonthE1()
  {
	  LinkedList<MaxHzReport> NovReports = new LinkedList<MaxHzReport>();
	  NovReports.add(new MaxHzReport(20151013.0,10.0));
	  NovReports.add(new MaxHzReport(20151020.0,50.0));
	  assertEquals(NovReports, 
              E1.dailyMaxForMonth(threeDates, 10));
  }
  
  @Test
  public void instructorTestEQE2() { 
    assertEquals(NovReports, 
                E2.dailyMaxForMonth(threeDates, 11));
	//   
  }
  
//Tests that the Earthquake2 dailyMaxForMonth returns the expected values with multiple readings within 1 month
  @Test
  public void multipleDatesInAMonthE2()
  {
	  LinkedList<MaxHzReport> NovReports = new LinkedList<MaxHzReport>();
	  NovReports.add(new MaxHzReport(20151013.0,10.0));
	  NovReports.add(new MaxHzReport(20151020.0,50.0));
	  assertEquals(NovReports, 
              E2.dailyMaxForMonth(threeDates, 10));
  }
  
//Tests that the Earthquake1 dailyMaxForMonth returns the expected empty list for no readings within the specified month
  @Test
  public void noDatesInAMonthE1()
  {
	  LinkedList<MaxHzReport> EmptyReports = new LinkedList<MaxHzReport>();
	  assertEquals(EmptyReports, 
              E1.dailyMaxForMonth(threeDates, 12));
  }
  
//Tests that the Earthquake2 dailyMaxForMonth returns the expected empty list for no readings within the specified month
  @Test
  public void noDatesInAMonthE2()
  {
	  LinkedList<MaxHzReport> EmptyReports = new LinkedList<MaxHzReport>();
	  assertEquals(EmptyReports, 
              E2.dailyMaxForMonth(threeDates, 12));
  }

}
