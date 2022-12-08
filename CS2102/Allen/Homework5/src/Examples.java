/**
 * class to test WeatherStation methods
 * @author acheung@wpi.edu && trstecko@wpi.edu
 *
 */
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;
public class Examples {

	// Tests AverageMonthTemp, should equal 1.25
	@Test
	public void testAverageMonthTemp()
	{
		LinkedList<Reading> listOfReadings = new LinkedList<Reading>()
		{{
			add(new Reading(new Time(5, 36) , 1.0, 0.0));
			add(new Reading(new Time(5, 36) , 1.0, 0.0));
			add(new Reading(new Time(5, 36) , 1.0, 0.0));
			add(new Reading(new Time(5, 36) , 2.0, 0.0));
		}};
		LinkedList<TodaysWeatherReport> listOfWeatherReports = new LinkedList<TodaysWeatherReport>()
		{{
			add(new TodaysWeatherReport(new GregorianCalendar(2015, 11, 21), listOfReadings));	
			add(new TodaysWeatherReport(new GregorianCalendar(2015, 11, 22), listOfReadings));
			add(new TodaysWeatherReport(new GregorianCalendar(2015, 10, 21), listOfReadings));
			add(new TodaysWeatherReport(new GregorianCalendar(2015, 10, 22), listOfReadings));
		}};
		IReport aReport = new Report(listOfWeatherReports);
		WeatherStation aWeatherStation = new WeatherStation(aReport);
		assertEquals(1.25, aWeatherStation.averageMonthTemp(11, 2015), 0.1);
		}
	
	// Tests AverageMonthTemp when the wrong month is input all the valid readings are excluded.
	// Should return -999.0 since all valid readings are excluded.
		@Test
		public void testAverageMonthTempWhenWrongMonth()
		{
			LinkedList<Reading> listOfReadings = new LinkedList<Reading>()
			{{
				add(new Reading(new Time(5, 36) , 1.0, 0.0));
				add(new Reading(new Time(5, 36) , 1.0, 0.0));
				add(new Reading(new Time(5, 36) , 1.0, 0.0));
				add(new Reading(new Time(5, 36) , 2.0, 0.0));
			}};
			LinkedList<TodaysWeatherReport> listOfWeatherReports = new LinkedList<TodaysWeatherReport>()
			{{
				add(new TodaysWeatherReport(new GregorianCalendar(2015, 10, 21), listOfReadings));	
				add(new TodaysWeatherReport(new GregorianCalendar(2015, 10, 22), listOfReadings));
				add(new TodaysWeatherReport(new GregorianCalendar(2015, 10, 21), listOfReadings));
				add(new TodaysWeatherReport(new GregorianCalendar(2015, 10, 22), listOfReadings));
			}};
			IReport aReport = new Report(listOfWeatherReports);
			WeatherStation aWeatherStation = new WeatherStation(aReport);
			assertEquals(-999.0, aWeatherStation.averageMonthTemp(13, 2015), 0.1);
			}
		
		// Tests AverageMonthTemp when the wrong year is input all the valid readings are excluded.
		// Should return -999.0 since all valid readings are excluded.
			@Test
			public void testAverageMonthTempWhenWrongYear()
			{
				LinkedList<Reading> listOfReadings = new LinkedList<Reading>()
				{{
					add(new Reading(new Time(5, 36) , 1.0, 0.0));
					add(new Reading(new Time(5, 36) , 1.0, 0.0));
					add(new Reading(new Time(5, 36) , 1.0, 0.0));
					add(new Reading(new Time(5, 36) , 2.0, 0.0));
				}};
				LinkedList<TodaysWeatherReport> listOfWeatherReports = new LinkedList<TodaysWeatherReport>()
				{{
					add(new TodaysWeatherReport(new GregorianCalendar(2015, 10, 21), listOfReadings));	
					add(new TodaysWeatherReport(new GregorianCalendar(2015, 10, 22), listOfReadings));
					add(new TodaysWeatherReport(new GregorianCalendar(2015, 10, 21), listOfReadings));
					add(new TodaysWeatherReport(new GregorianCalendar(2015, 10, 22), listOfReadings));
				}};
				IReport aReport = new Report(listOfWeatherReports);
				WeatherStation aWeatherStation = new WeatherStation(aReport);
				assertEquals(-999.0, aWeatherStation.averageMonthTemp(10, 2050), 0.1);
				}
	
	// Tests the averageMonthTemp method when there are not any temps to process. 
	// Recognizing the error, the code should return -999.0
	@Test
	public void testAverageMonthTempWhenEmpty()
	{
		LinkedList<Reading> listOfReadings = new LinkedList<Reading>();
		LinkedList<TodaysWeatherReport> listOfWeatherReports = new LinkedList<TodaysWeatherReport>()
		{{
			add(new TodaysWeatherReport(new GregorianCalendar(2015, 11, 21), listOfReadings));	
			add(new TodaysWeatherReport(new GregorianCalendar(2015, 11, 22), listOfReadings));
			add(new TodaysWeatherReport(new GregorianCalendar(2015, 10, 21), listOfReadings));
			add(new TodaysWeatherReport(new GregorianCalendar(2015, 10, 22), listOfReadings));
		}};
		IReport aReport = new Report(listOfWeatherReports);
		WeatherStation aWeatherStation = new WeatherStation(aReport);
		assertEquals(-999, aWeatherStation.averageMonthTemp(11, 2015), 0.1);
		}
	// Tests TotalMonthRainfall, should return 7.0
	@Test
	public void testTotalMonthRainfall()
	{
		LinkedList<Reading> listOfReadings = new LinkedList<Reading>()
		{{
			add(new Reading(new Time(5, 36) , 1.0, 1.0));
			add(new Reading(new Time(5, 36) , 1.0, 1.0));
			add(new Reading(new Time(5, 36) , 1.0, 2.0));
			add(new Reading(new Time(5, 36) , 2.0, 3.0));
		}};
		LinkedList<TodaysWeatherReport> listOfWeatherReports = new LinkedList<TodaysWeatherReport>()
		{{
			add(new TodaysWeatherReport(new GregorianCalendar(2015, 11, 21), listOfReadings));	
			add(new TodaysWeatherReport(new GregorianCalendar(2015, 11, 22), listOfReadings));
			add(new TodaysWeatherReport(new GregorianCalendar(2015, 10, 21), listOfReadings));
			add(new TodaysWeatherReport(new GregorianCalendar(2015, 10, 22), listOfReadings));
		}};
		IReport aReport = new Report(listOfWeatherReports);
		WeatherStation aWeatherStation = new WeatherStation(aReport);
		assertEquals(14.0, aWeatherStation.totalMonthRainfall(11, 2015), 0.1);
		}
	
	// Tests totalMonthRainfall when the wrong month is input all the valid readings are excluded.
	// Should return -999.0 since all valid readings are excluded.
		@Test
		public void testTotalMonthRainfallWhenWrongMonth()
		{
			LinkedList<Reading> listOfReadings = new LinkedList<Reading>()
			{{
				add(new Reading(new Time(5, 36) , 1.0, 1.0));
				add(new Reading(new Time(5, 36) , 1.0, 1.0));
				add(new Reading(new Time(5, 36) , 1.0, 2.0));
				add(new Reading(new Time(5, 36) , 2.0, 3.0));
			}};
			LinkedList<TodaysWeatherReport> listOfWeatherReports = new LinkedList<TodaysWeatherReport>()
			{{
				add(new TodaysWeatherReport(new GregorianCalendar(2015, 10, 21), listOfReadings));	
				add(new TodaysWeatherReport(new GregorianCalendar(2015, 10, 22), listOfReadings));
				add(new TodaysWeatherReport(new GregorianCalendar(2015, 10, 21), listOfReadings));
				add(new TodaysWeatherReport(new GregorianCalendar(2015, 10, 22), listOfReadings));
			}};
			IReport aReport = new Report(listOfWeatherReports);
			WeatherStation aWeatherStation = new WeatherStation(aReport);
			assertEquals(-999.0, aWeatherStation.totalMonthRainfall(13, 2015), 0.1);
			}
		
		// Tests totalMonthRainfall when the wrong year is input all the valid readings are excluded.
		// Should return -999.0 since all valid readings are excluded.
			@Test
			public void testTotalMonthRainfallWhenWrongYear()
			{
				LinkedList<Reading> listOfReadings = new LinkedList<Reading>()
				{{
					add(new Reading(new Time(5, 36) , 1.0, 1.0));
					add(new Reading(new Time(5, 36) , 1.0, 1.0));
					add(new Reading(new Time(5, 36) , 1.0, 2.0));
					add(new Reading(new Time(5, 36) , 2.0, 3.0));
				}};
				LinkedList<TodaysWeatherReport> listOfWeatherReports = new LinkedList<TodaysWeatherReport>()
				{{
					add(new TodaysWeatherReport(new GregorianCalendar(2015, 10, 21), listOfReadings));	
					add(new TodaysWeatherReport(new GregorianCalendar(2015, 10, 22), listOfReadings));
					add(new TodaysWeatherReport(new GregorianCalendar(2015, 10, 21), listOfReadings));
					add(new TodaysWeatherReport(new GregorianCalendar(2015, 10, 22), listOfReadings));
				}};
				IReport aReport = new Report(listOfWeatherReports);
				WeatherStation aWeatherStation = new WeatherStation(aReport);
				assertEquals(-999.0, aWeatherStation.totalMonthRainfall(10, 2050), 0.1);
				}
	
	// Tests TotalMonthRainfall when there are not rainfall values to process.
	// Recognizing the error, the return value should be -999.0
		@Test
		public void testTotalMonthRainfallWhenEmpty()
		{
			LinkedList<Reading> listOfReadings = new LinkedList<Reading>();
			LinkedList<TodaysWeatherReport> listOfWeatherReports = new LinkedList<TodaysWeatherReport>()
			{{
				add(new TodaysWeatherReport(new GregorianCalendar(2015, 11, 21), listOfReadings));	
				add(new TodaysWeatherReport(new GregorianCalendar(2015, 11, 22), listOfReadings));
				add(new TodaysWeatherReport(new GregorianCalendar(2015, 10, 21), listOfReadings));
				add(new TodaysWeatherReport(new GregorianCalendar(2015, 10, 22), listOfReadings));
			}};
			IReport aReport = new Report(listOfWeatherReports);
			WeatherStation aWeatherStation = new WeatherStation(aReport);
			assertEquals(-999, aWeatherStation.totalMonthRainfall(11, 2015), 0.1);
			}
	
	}
