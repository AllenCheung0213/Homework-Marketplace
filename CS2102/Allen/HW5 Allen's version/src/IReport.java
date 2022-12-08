/**
 * Class to initialize methods in Report
 * @author acheung@wpi.edu
 */

import java.util.GregorianCalendar;
import java.util.LinkedList;

public interface IReport {

    /**
     * finds the average temperature in a certain year in a certain month
     * @param month integer for month
     * @param year integer for year
     * @return a double for the average
     */
    public double averageMonthTemp(int month, int year);

    /**
     * Finds the total rainfall in a certain year in a certain month
     * @param month integer for month
     * @param year integer for year
     * @return a double for the total
     */
    public double totalMonthRainfall(int month, int year);

    /**
     * adds the report to a list
     * @param date a GregorianCalendar
     * @param reading a LinkedList<Reading>
     */
    public void addTodaysReport (GregorianCalendar date, LinkedList<Reading> reading);

}
