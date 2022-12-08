import java.util.LinkedList;

/**
 * 
 * @author trstecko && acheung
 * Earthquake2 handles interactions with sensor data for Earthquakes
 *
 */

class Earthquake2 {
  Earthquake2(){}
      
  // checks whether a datum is a date
  boolean isDate(double anum) { return (int)anum > 10000000; }
  // extracts the month from an 8-digit date
  int extractMonth(double dateNum) { return ((int)dateNum % 10000) / 100; }

/*
 * Subtasks:
 * create a list of report
 * Increments through the LinkedList of sensor readings.
 * If the element is a date, look through following elements finding the max
 * Once the next element is another date, add the previous date and max to the LinkedList of reports
 * Return a list of reports
 */
  
  /**
 *Intakes a list of sensor values and a specified month and returns a list of MaxHzReports for the highest 
   * recorded sensor data for each day in the specified month
   * 
 * @param LinkedList<Double> sensorDataList - the sequence of values coming from the sensor
   * @param int month - the Month whose maxes will be reported
   * @return a LinkedList<MaxHzReport> of all the Maximum sensor readings for each recorded date in the month
 */
  public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data,
                                                  int month) {
    LinkedList<MaxHzReport> report = new LinkedList<MaxHzReport>();
      for (int i = 0; i < data.size(); i++) {
          if(isDate(data.get(i)) && extractMonth(data.get(i))==month){
              double greatest=-999;
              for (int j =i+1; j<data.size();j++){
                  if(!isDate(data.get(j))){
                      if(data.get(j)>greatest) {
                          greatest = data.get(j);
                      }
                  }else {
                	  i=j-1;
                      break;
                  }
              }
              report.add(new MaxHzReport(data.get(i), greatest));
          }
      }
      return report;
   }
}