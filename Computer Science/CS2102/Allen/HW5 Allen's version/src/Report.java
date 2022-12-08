/**
 * Class to hold data for each report
 * @author acheung@wpi.edu
 */

import java.util.LinkedList;
import java.util.GregorianCalendar;

public class Report implements IReport{
    private LinkedList<TodaysWeatherReport> report;

    public Report(LinkedList<TodaysWeatherReport> report) {
        this.report = report;
    }

    /**
     finds the average temperature in a certain year in a certain month
     * @param month integer for month
     * @param year integer for year
     * @return a double for the average
     */
    public double averageMonthTemp(int month, int year){
        double average = 0;
        for(TodaysWeatherReport today :report){
            if(today.checkMonth(month) && today.checkYear(year)) {
                average += today.averageTemp();
            }
        }
        return average;
    }

    /**
     * Finds the total rainfall in a certain year in a certain month
     * @param month integer for month
     * @param year integer for year
     * @return a double for the total
     */
    public double totalMonthRainfall(int month, int year){
        double sum = 0;
        for(TodaysWeatherReport today :report){
            if(today.checkMonth(month) && today.checkYear(year)) {
                sum+= today.totalRainfall();
            }
        }
        return sum;
    }

    /**
     * adds the report to a list
     * @param date a GregorianCalendar
     * @param reading a LinkedList<Reading>
     */
    public void addTodaysReport (GregorianCalendar date, LinkedList<Reading> reading){
        LinkedList<Double> temp = new LinkedList<Double>();
        LinkedList<Double> rainfall = new LinkedList<Double>();
        for(Reading read: reading){
            temp.add(read.getTemp());
            rainfall.add(read.getRainfall());
        }
        report.add(new TodaysWeatherReport(date,temp, rainfall));
    }
}
