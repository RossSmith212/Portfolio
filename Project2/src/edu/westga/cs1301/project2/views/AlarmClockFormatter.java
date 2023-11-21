package edu.westga.cs1301.project2.views;

import edu.westga.cs1301.project2.model.AlarmClock;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter; 


/**
 * Class with methods for formatting the time from an AlarmClock object
 * 
 * @author	CS1301
 * @version	Spring 2021
 *
 */
public class AlarmClockFormatter {

	/**
	 * 
	 * @return
	 */
	public AlarmClockFormatter() {
		 
	}
	
	/**
	 * Returns "AM" or "PM" depending on the clock time.
	 * 
	 * @precondition clock != null
	 * @postcondition none
	 * 
	 * @param clock the clock
	 * @return "AM" if the time is in the morning (between midnight and 11:59), "PM" otherwise
	 */
	public String findAmVsPm(AlarmClock clock) {
		if (clock == null) {
			throw new IllegalArgumentException("Clock Cannot be null"); 
		}
		if (clock.getHour() < 12){
			return "AM"; 
		}
		else {
			return "PM"; 
		}
	}

	/**
	 * Given an hour between 0 and 23 (from 24-hour format),
	 * convert it to an hour appropriate for 12-hour format
	 * 
	 * @precondition 0 <= hour <= 23
	 * @postcondition none
	 * 
	 * @param hour the hour, in 24-hour format
	 * @return an hour between 1 and 12, as appropriate
	 */
	public int findNormalizedHour(int hour) {
		if (0 > hour) {
			throw new IllegalArgumentException("Hour cannot be less than 0");
		}
		if (hour > 23) {
			throw new IllegalArgumentException("Hour cannot be greater than 23"); 
		}
		int normalizedHour = 0; 
		
		
		if (hour == 00) {
			normalizedHour = 12; 
		}
		if (hour == 1) {
			normalizedHour = 01; 
		}
		if (hour == 11) {
			normalizedHour = 11;
		}
		if (hour == 13) {
			normalizedHour = 1;
		}
		if (hour == 23) {
			normalizedHour = 11; 
		}
		if (hour == 12) {
			normalizedHour = 12;
		}
		return normalizedHour;
	}
	
	/**
	 * Takes a 1- or 2-digit integer (valid for minutes or seconds)
	 * and returns a String version
	 * of that integer padded out to 2 digits. In other words,
	 * 2-digit integers are returns as simply the string version
	 * of that integer. 1-digit integers are returned as a string
	 * of that integer with a leading 0.
	 * 
	 * @precondition 0 <= value <= 59
	 * @postcondition none
	 * 
	 * @param value the number to convert
	 * @return the string version of that number, with a zero in the first digit if needed.
	 */
	public String convertToTwoDigitNumericString(int value) {
		if (value < 0 || value > 59) {
			throw new IllegalArgumentException("value must be between 0 and 59");
		}
		
		if (value < 10) {
			return "0" + value;
		} else {
			return "" + value;
		}
	}
	/**
	 * 
	 * @param clock
	 * @return
	 */
	private boolean isAM(AlarmClock clock) {
		return clock.getHour() < 12;
	}
	
	/**
	 * Creates a new AlarmClockFormatter.
	 * Formats the time as one of the following sayings:
	 * "It is the top of the hour" (if minutes is 0)
	 * "It is a quarter past the hour" (if minutes is 15)
	 * "It's half past the hour" (If minutes is 30)
	 * "It's a quarter till the hour (If minutes at 45)
	 * 
	 * @precondition clock != null
	 * @postcondition none
	 * 
	 * @param clock 
	 * @return String of time phrases 
	 * 
	 */
	public String formatMinutesInConversationalTone(AlarmClock clock) {
		if (clock == null) {
			throw new IllegalArgumentException("Clock cannnot be null"); 
		}
		
		String formattedTime; 
		
		if (clock.getMinutes() == 0) {
			formattedTime = "It is the top-of-the-hour";
		}
		else if (clock.getMinutes() == 15) {
			formattedTime = "It is quarter-past the hour";
		}
		else if (clock.getMinutes() == 30) {
			formattedTime = "It is half-past the hour"; 
		}
		else if (clock.getMinutes() == 45) {
			formattedTime = "It is quarter-till the hour";   
		}
		else {
			formattedTime = "It is " + clock.getMinutes() + " minutes past the hour"; 
		}
		return formattedTime; 
	}
	
	/**
	 * Returns time based on city
	 * 
	 * @precondition clock != null
	 * @postcondition String with time and city 
	 * 
	 * @param clcok 
	 */
	public String formatTimeBasedOnCityTimeZone(int city, AlarmClock time) {
		if (time == null) {
		throw new IllegalArgumentException("Clock cannot be null"); 
		}
		if (city < 1 && city > 5) {
			throw new IllegalArgumentException("Cannot be less than 0 or greater than 5");
		}
		String cityName = ""; 
		if (city == 1) {
			cityName = "Atlanta"; 
		}
		else if (city == 2) {
			cityName = "Chicago";
		}
		else if (city == 3) {
			cityName = "Santa Fe";
		}
		else if (city == 4) {
			cityName = "Sacramento";
		}
		else {
			cityName = "Not Applicable"; 
		}
		 
		return "The time is " + time.getHour() +":" + time.getMinutes() + " in " + cityName;
	}
	
	/**
	 * Puts the time in conversational tone
	 * 
	 * @precondition clock != null; 
	 * @postcondition none
	 * 
	 * @param AlarmClock clock
	 * 
	 * @return Conversational time of clock
	 */
	public String FormatTimeInConversationalTone(AlarmClock clock) {
		if (clock == null) {
			throw new IllegalArgumentException("Clock cannot be null"); 
		}
		
		String formattedTime = null; 
		if (clock.getMinutes() == 0) {
			formattedTime = "It is " + clock.getHour() + " o'clock"; 
		}
		if (clock.getMinutes() == 15) {
			formattedTime = "It is a quarter past " + clock.getHour();  
		}
		if (clock.getMinutes() == 30) {
			formattedTime = "It is half past " + clock.getHour(); 
		}
		if (clock.getMinutes() == 45) {
			formattedTime = "It is quarter-till " + clock.getHour(); 
		}
		if (clock.getMinutes() < 30 && clock.getMinutes() != 15 && clock.getMinutes() != 0) {
			formattedTime = "It is " + clock.getMinutes() + " past the hour"; 
		}
		if (clock.getMinutes() > 30 && clock.getMinutes() != 45 && clock.getMinutes() != 0) {
			formattedTime = "It is " + clock.getMinutes() + " minutes till " + clock.getHour(); 
		}
		return formattedTime;
		
	}
}

