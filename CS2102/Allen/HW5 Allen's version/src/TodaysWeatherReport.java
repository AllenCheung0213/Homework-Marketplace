/**
 * Class to initialize the date, temperature, and rainfall to certain values.
 * Makes a report of date, temperature, and rainfall
 * @author acheung@wpi.edu
 */

import java.util.LinkedList;
import java.util.GregorianCalendar;

public class TodaysWeatherReport {
    private GregorianCalendar date;
    private LinkedList<Double> temp;
    private LinkedList<Double> rainfall;

    public TodaysWeatherReport(GregorianCalendar date, LinkedList<Double> temp, LinkedList<Double> rainfall) {
        this.date=date;
        this.temp=temp;
        this.rainfall=rainfall;
    }
    
    public TodaysWeatherReport (GregorianCalendar date, LinkedList<Reading> daysReadings)
	{
		for(Reading thisReading: daysReadings)
		{
			rainfall.add(thisReading.getRainfall());
			temp.add(thisReading.getTemp());
		}
	}

    /**
     * returns the date
     * @return GregorianCalendar date
     */
    public GregorianCalendar getDate() {
        return date;
    }

    /**
     * returns the temperature data
     * @return LinkedList<Double> list of temperatures
     */
    public LinkedList<Double> getTemp() {
        return temp;
    }

    /**
     * returns the rainfall data
     * @return LinkedList<Double> list of rainfalls
     */
    public LinkedList<Double> getRainfall() {
        return rainfall;
    }

    /**
     * Checks to see if the month given is the same as the month in the instance
     * @param month integer month
     * @return true or false depending if the month is the same
     */
    public boolean checkMonth(int month){
        return month == this.getDate().get(GregorianCalendar.MONTH);
    }

    /**
     * Checks to see if the year given is the same as the year in the instance
     * @param year integer year
     * @return true of false depending if the year is the same
     */
    public boolean checkYear(int year){
        return year == this.getDate().get(GregorianCalendar.YEAR);
    }

    /**
     * Calculates the average temperature in the list of temperatures
     * @return double temperature
     */
    public double averageTemp(){
        double sum = 0;
        int count = 0;
        for (double num : this.getTemp()) {
            sum+=num;
            count++;
        }
        return sum/count;
    }

    /**
     * Calculates the total amount of rainfall in the list of rainfall amounts
     * @return double sum of rainfall amounts
     */
    public double totalRainfall(){
        double sum = 0;
        for (double num : this.getRainfall()) {
            sum+=num;
        }
        return sum;
    }

}
