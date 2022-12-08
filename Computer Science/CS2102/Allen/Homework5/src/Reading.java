/**
 * Class to contain time, temperature, and amount of rainfall
 * @author acheung@wpi.edu && trstecko@wpi.edu
 */
public class Reading {
	private double temperature;
	private Time time;
	private double rainSinceLastReading;
	
	// constructor -- creates a Reading
	public Reading(Time time, double temperature, double rainSinceLastReading)
	{
		this.time = time;
		this.temperature = temperature;
		this.rainSinceLastReading = rainSinceLastReading;
	}
	
	/**
	 * Consumes nothing and returns the temperature double of this Reading
	 * @return temperature
	 */
	public double getTemperature()
	{
		return temperature;
	}
	
	/**
	 * Consumes nothing and returns the rain double of this Reading
	 * @return rain
	 */
	public double getRain()
	{
		return rainSinceLastReading;
	}
}
