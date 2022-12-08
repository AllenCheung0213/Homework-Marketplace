import java.util.LinkedList;
/**
 * 
 * @author trstecko && acheung
 * Earthquake1 handles interactions with sensor data for Earthquakes
 *
 */
class Earthquake1 {
  Earthquake1(){}

  // checks whether a datum is a date
  boolean isDate(double anum) { return (int)anum > 10000000; }
  // extracts the month from an 8-digit date
  int extractMonth(double dateNum) { return ((int)dateNum % 10000) / 100; }
  
  /*
   * Subtasks:
   * Create a list to store the sensor readings for the specified month
   * Run through the sensorDataList and, if a date is found for the specified month, 
   * - add the sensor readings for that date into the new list for the chosen month.
   * Create a list to store the sensor readings for valid sensor readings
   * Run through the list of readingsForChosenMonth and add all valid sensor readings to the list of valid readings
   * Create a list to store each date and its maximum reading
   * Run through the list of valid readings and add each date and its maximum reading to the new list
   * Create a list for storing the MaxHzReports
   * run through the list of dates and maximum readings. Use them to create MaxHzReport objects to be inserted into the list of MaxHzReports
   * Return the list of MaxHzReports
   */
  
  /**
   * Intakes a list of sensor values and a specified month and returns a list of MaxHzReports for the highest 
   * recorded sensor data for each day in the specified month
   * 
   * @param LinkedList<Double> sensorDataList - the sequence of values coming from the sensor
   * @param int month - the Month whose maxes will be reported
   * @return a LinkedList<MaxHzReport> of all the Maximum sensor readings for each recorded date in the month
   */
  
  public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> sensorDataList, int month)
  {
	  boolean currentlyInRightMonth = false;
	  
	  LinkedList<Double> dataWithoutFalseValues = new LinkedList<Double>();
	  for(Double thisDouble : sensorDataList)
	  {
		  if(isDate(thisDouble))
		  {
			  if(extractMonth(thisDouble) == month)
				  currentlyInRightMonth = true;
			  else
				  currentlyInRightMonth = false;
			  if(currentlyInRightMonth) {
				  dataWithoutFalseValues.add(thisDouble);}
		  }
		  else if (!(thisDouble > 500 || thisDouble < 0) && currentlyInRightMonth && !isDate(thisDouble)) {
			  dataWithoutFalseValues.add(thisDouble);
		  }
	  }
	 
	  LinkedList<Double> dataWithOnlyMaxSensorData = new LinkedList<Double>();
	  
	  Double maxValue = -999.0;
	  
	  for(int i=0; i<dataWithoutFalseValues.size();i++)
	  {
		  if(!isDate(dataWithoutFalseValues.get(i))) {
			  if(dataWithoutFalseValues.get(i) > maxValue) {
				  maxValue = dataWithoutFalseValues.get(i);
			
			  }
			  if(i==dataWithoutFalseValues.size()-1) {
				  dataWithOnlyMaxSensorData.add(maxValue);
			  }
		  }
		  if(isDate(dataWithoutFalseValues.get(i)))
		  {
			  if(maxValue != -999)
				  dataWithOnlyMaxSensorData.add(maxValue);
			  dataWithOnlyMaxSensorData.add(dataWithoutFalseValues.get(i));
			  maxValue = -999.0;
		  } 
	  }
	
	  LinkedList<MaxHzReport> listOfReports = new LinkedList<MaxHzReport>();
	  for(int i=1; i<dataWithOnlyMaxSensorData.size(); i+=2)
	  {
		  listOfReports.add(new MaxHzReport(dataWithOnlyMaxSensorData.get(i-1), dataWithOnlyMaxSensorData.get(i))) ;
	  }
	  return listOfReports;
  }
}  

