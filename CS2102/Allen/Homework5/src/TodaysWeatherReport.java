/**
 * Class to initialize the date, temperature, and rainfall to certain values.
 * @author acheung@wpi.edu && trstecko@wpi.edu
 */
import java.util.GregorianCalendar;
import java.util.LinkedList;
public class TodaysWeatherReport
{

	private GregorianCalendar date = new GregorianCalendar();
	private LinkedList<Double> temperatureReadings = new LinkedList<Double>();
	private LinkedList<Double> deltaRainfalls = new LinkedList<Double>();
	
	/**
	 * Consumes a GregorianCalendar date and a list LL of Readings, creates a new TodaysWeatherReport
	 * @param GregorianCalendar -- date
	 * @param LinkedList<Reading> -- daysReadings
	 */
	public TodaysWeatherReport (GregorianCalendar date, LinkedList<Reading> daysReadings)
	{
		for(Reading thisReading: daysReadings)
		{
			deltaRainfalls.add(thisReading.getRain());
			temperatureReadings.add(thisReading.getTemperature());
		}
		this.date = date;
	}
	/**
	 * Consumes a GregorianCalendar date, a list LL of temp readings, and a LL of rain readings. Creates a new TodaysWeatherReport
	 * @param GregorianCalendar -- date
	 * @param LinkedList<Double> -- temperatureReadings
	 * @param LinkedList<Double> -- deltaRainFalls
	 */
	public TodaysWeatherReport (GregorianCalendar date, LinkedList<Double> temperatureReadings, LinkedList<Double> deltaRainfalls)
	{
		this.date = date;
		this.temperatureReadings = temperatureReadings;
		this.deltaRainfalls = deltaRainfalls;
	}	
	
	/**
	 * Finds the average temperature value of what is stored in this object's temperatureReadings LinkedList
	 * @return a double -- the average of this TodaysWeatherReport's temperature readings
	 */
	
	public boolean isSpecifiedMonth(int month, int year)
	{
		return(date.get(GregorianCalendar.MONTH) == month && date.get(GregorianCalendar.YEAR) == year);
	}
	
	
	public double todaysAvgTemperature()
	{
		if(temperatureReadings.size() == 0)
		{
			return -999.0;
		}
		double temperatureSum = 0.0;
		for(Double thisTempReading : temperatureReadings)
		{
			temperatureSum += thisTempReading;
		}
		return temperatureSum/temperatureReadings.size();
	}
	
	/**
	 * Finds the total rainfall value of what is stored in this object's deltaRainfalls LinkedList
	 * @return a double -- the total of this TodaysWeatherReport's rainfall readings
	 */
	public double todaysTotalRain()
	{
		if(deltaRainfalls.size()==0)
		{
			return -999.0;
		}
		double rainSum = 0.0;
		for(Double thisRainReading : deltaRainfalls)
		{
			rainSum += thisRainReading;
		}
		return rainSum;
	}
}
