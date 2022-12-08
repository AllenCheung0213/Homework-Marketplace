import java.util.LinkedList;

public class Planning {

	public static double rainfall(LinkedList<Double> listOfReadings)
	{
		double sumOfGoodReadings = 0.0;
		int numOfGoodReadings = 0;
		for(Double reading : listOfReadings)
		{
			if(reading >= 0)
			{
				sumOfGoodReadings += reading;
				numOfGoodReadings++;
			}
			if(reading == -999)
			{
				if(numOfGoodReadings == 0)
					return -1.0;
				return sumOfGoodReadings/numOfGoodReadings; 
			}
		}
		if(numOfGoodReadings == 0)
			return -1.0;
		return sumOfGoodReadings/numOfGoodReadings;
	}
}
