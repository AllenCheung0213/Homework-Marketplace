/**
 * Class to hold data for each report
 * @author acheung@wpi.edu && trstecko@wpi.edu
 */

import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Report implements IReport {
	private LinkedList<TodaysWeatherReport> report;
	public Report(LinkedList<TodaysWeatherReport> report)
	{
		this.report = report;
	}
	
	/**
	 * Consumes a month and a year and returns the average temperature readings
	 * of all the TodaysWeatherReport in the specified month
	 * 
	 * @param month -- the integer 0-11 representing the month
	 * @param year -- the integer representing the year
	 * @return a double representing the average daily temps in the month
	 */
	public double averageMonthTemp(int month, int year) {
		
		LinkedList<TodaysWeatherReport> reportsInSpecifiedPeriod = onlyInSpecifiedMonth(month, year);
		double sumOfAverageTemps = 0.0;
		if(reportsInSpecifiedPeriod.size() == 0)
		{
			return -999.0;
		}
		for(TodaysWeatherReport thisReport : reportsInSpecifiedPeriod)
		{
			if(thisReport.todaysAvgTemperature() == -999.0)
			{
				return -999.0;
			}
			sumOfAverageTemps += thisReport.todaysAvgTemperature();
		}
		return sumOfAverageTemps/reportsInSpecifiedPeriod.size();
	}

	/**
	 * Consumes a month and a year and returns the average rainfall readings
	 * of all the TodaysWeatherReport in the specified month
	 * 
	 * @param month -- the integer 0-11 representing the month
	 * @param year -- the integer representing the year
	 * @return a double representing the average daily rainfall in the month
	 */
	public double totalMonthRainfall(int month, int year) {
		LinkedList<TodaysWeatherReport> reportsInSpecifiedPeriod = onlyInSpecifiedMonth(month, year);
		double sumOfTotalRains = 0.0;
		if(reportsInSpecifiedPeriod.size() == 0)
		{
			return -999.0;
		}
		for(TodaysWeatherReport thisReport : reportsInSpecifiedPeriod)
		{
			if(thisReport.todaysTotalRain() == -999.0)
			{
				return -999.0;
			}
			sumOfTotalRains += thisReport.todaysTotalRain();
		}
		return sumOfTotalRains;
	}

	public void addTodaysReport(GregorianCalendar date, LinkedList<Reading> reading) {
		report.add(new TodaysWeatherReport(date, reading));
	}
	
	
	/**
	 * Consumes an LL of TodaysWeatherReport, a month, and a year. Returns all of the TodaysWeatherReport in this objects
	 * report that match the specified month and year
	 * 
	 * @param month -- integer (0-11)
	 * @param year -- integer
	 * @return A LinkedList made only of TodaysWeatherReport from the specified month
	 */
	public LinkedList<TodaysWeatherReport> onlyInSpecifiedMonth(int month, int year)
	{
		LinkedList<TodaysWeatherReport> reportsInSpecifiedPeriod = new LinkedList<TodaysWeatherReport>();
		for(TodaysWeatherReport thisWeatherReport : report)
		{
			if(thisWeatherReport.isSpecifiedMonth(month, year))
			{
				reportsInSpecifiedPeriod.add(thisWeatherReport);
			}
		}
		return reportsInSpecifiedPeriod;
	}
}
