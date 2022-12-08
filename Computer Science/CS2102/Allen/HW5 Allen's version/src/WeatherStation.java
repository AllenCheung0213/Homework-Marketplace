/**
 * Class that reports weather trends
 * @author acheung@wpi.edu
 */

import java.util.LinkedList;
import java.util.GregorianCalendar;

public class WeatherStation {
    private IReport reports;
    public WeatherStation(IReport reports){
        this.reports=reports;
    }

    /**
     * finds the average temperature in a certain year in a certain month
     * @param month integer for month
     * @param year integer for year
     * @return calls averageMonthTemp(month,year)
     */
    public double averageMonthTemp(int month, int year){
        return reports.averageMonthTemp(month,year);
    }

    /**
     * Finds the total rainfall in a certain year in a certain month
     * @param month integer for month
     * @param year integer for year
     * @return calls totalMonthRainfall(month,year)
     */
    public double totalMonthRainfall(int month, int year){
        return reports.totalMonthRainfall(month,year);
    }

    /**
     * adds the report to a list
     * @param date a GregorianCalendar
     * @param reading a LinkedList<Reading>
     */
    public void addTodaysReport (GregorianCalendar date, LinkedList<Reading> reading){
        reports.addTodaysReport(date, reading);
    }

}
