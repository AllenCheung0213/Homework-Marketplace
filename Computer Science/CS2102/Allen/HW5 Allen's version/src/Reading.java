/**
 * Class to contain time, temperature, and amount of rainfall
 * @author acheung@wpi.edu
 */
public class Reading {
    private Time curTime;
    private double temp;
    private double rainfall;

    public Reading(Time time, double temperature, double rainSinceLastReading)
	{
		curTime = time;
		temp = temperature;
		rainfall = rainSinceLastReading;
	}
    
    /**
     * returns the current time
     * @return Time the current time
     */
    public Time getCurTime() {
        return curTime;
    }

    /**
     * returns the temperature
     * @return double the temperature
     */
    public double getTemp() {
        return temp;
    }

    /**
     * sets the temperature to a certain temperature
     * @param temp double temperature
     */
    public void setTemp(double temp) {
        this.temp = temp;
    }

    /**
     * returns the rainfall
     * @return double the rainfall
     */
    public double getRainfall() {
        return rainfall;
    }

    /**
     * sets the amount of rainfall to a certain number
     * @param rainfall double amount of rain
     */
    public void setRainfall(double rainfall) {
        this.rainfall = rainfall;
    }
}
