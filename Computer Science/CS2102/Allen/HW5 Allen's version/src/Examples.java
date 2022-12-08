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

	@Test
	public void test1()
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
			add(new TodaysWeatherReport(new GregorianCalendar(2015, 12, 21), listOfReadings));
			add(new TodaysWeatherReport(new GregorianCalendar(2015, 12, 22), listOfReadings));
		}};
		IReport aReport = new Report(listOfWeatherReports);
		WeatherStation aWeatherStation = new WeatherStation(aReport);
		System.out.println(aWeatherStation.averageMonthTemp(11, 2015));
		assertEquals(1.5, aWeatherStation.averageMonthTemp(11, 2015));
		}
	}
