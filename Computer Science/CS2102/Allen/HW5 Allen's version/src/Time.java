/**
 * Class to contain hour and minute
 * @author acheung@wpi.edu
 */
public class Time {
    private int hour;
    private int minute;

    public Time(int hour, int minute) {
        this.hour=hour;
        this.minute=minute;
    }

    /**
     * returns the hour
     * @return int hour
     */
    public int getHour() {
        return hour;
    }

    /**
     * sets the hour to the given hour
     * @param hour int hour
     */
    public void setHour(int hour) {
        this.hour = hour;
    }

    /**
     * returns the minute
     * @return int minute
     */
    public int getMinute() {
        return minute;
    }

    /**
     * sets the minute to the given minute
     * @param minute int minute
     */
    public void setMinute(int minute) {
        this.minute = minute;
    }
}
