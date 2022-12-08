/**
 * Class that reports weather trends
 * @author acheung@wpi.edu && trstecko@wpi.edu
 */
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class WeatherStation {

	LinkedList<TodaysWeatherReport> listOfDailyReports = new LinkedList<TodaysWeatherReport>();
	private IReport reports;
	public WeatherStation(IReport reports) 
	{
		this.reports = reports;
	}
	/**
	 * Creates a new TodaysWeatherReport with the specified date and list of readings and adds it to the list of reports
	 * @param GregorianCalendar -- date
	 * @param LinkedList<Reading> -- daysReadings
	 */
	public void addTodaysReport(GregorianCalendar date, LinkedList<Reading> daysReadings)
	{
		listOfDailyReports.add(new TodaysWeatherReport (date, daysReadings));
	}

    /**
     * takes a month (designated by a number such as 0 for January, 1 for February, etc) and a year and produces the average temperature 
     * over all days that month.	
     * @param month integer for month
     * @param year integer for year
     * @return calls averageMonthTemp(month,year)
     */
	public double averageMonthTemp(int month, int year)
	{
	 return reports.averageMonthTemp(month, year);
	}
	
	/**
     * takes a month (designated by a number such as 0 for January, 1 for February, etc)
     * and a year and produces the total rainfall over all days that month.
     * @param month integer for month
     * @param year integer for year
     * @return calls totalMonthRainfall(month,year)
     */
	public double totalMonthRainfall(int month, int year)
	{
		return reports.totalMonthRainfall(month, year);
	}
}
