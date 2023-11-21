package edu.westga.cs1301.project2.model;


/**
 * Models an alarm clock that can set time and alarm.
 * 
 * @author	CS1301
 * @version	Spring 2021
 *
 */
public class AlarmClock {

	private int hour;
	private int minutes;
	private int seconds; 
	
	/**
	 * Creates a new alarm clock set at midnight (00:00)
	 * 
	 * @precondition none
	 * @postcondition getHour()==0 AND getMinutes()==0 AND getSeconds()==0
	 * 
	 */
	public AlarmClock() {
		this.hour = 0;
		this.minutes = 0;
		this.seconds = 0; 
	}
	
	/**
	 * Creates a new alarm clock with the time set at the given hours and minutes.
	 * 
	 * @precondition 0 <= hour <= 23 AND 0 <= minutes <= 59
	 * @postcondition getHour()==hour AND getMinutes()==minutes AND getSeconds()==0
	 * 
	 * @param hour the hour to set for the time
	 * @param minutes the minutes to set for the time
	 */
	public AlarmClock(int hour, int minutes, int seconds) {
		if (hour < 0 || hour > 23) {
			throw new IllegalArgumentException("hour should be between 0 and 23");
		}
		
		if (minutes < 0 || minutes > 59) {
			throw new IllegalArgumentException("minutes shoulbe be between 0 and 59");
		}
		
		this.hour = hour;
		this.minutes = minutes;
		this.seconds = seconds; 
	}

	/**
	 * Gets the hour
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the hour portion of the time
	 */
	public int getHour() {
		return this.hour;
	}

	/**
	 * Gets the minutes
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the minutes portion of the time
	 */
	public int getMinutes() {
		return this.minutes;
	}
	
	
	/**
	 * Gets the Seconds
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the seconds portion of the time
	 */
	public int getSeconds() {
		return this.seconds;
	}

	/**
	 * Increments the hour by 1
	 * 
	 * @precondition none
	 * @postcondition getHour()==getHour()@prev+1 % 24
	 */
	public void incrementHour() {
		this.hour = (this.hour + 1) % 24;
	}
	
	/**
	 * Increments the minutes by 1
	 * 
	 * @precondition none
	 * @postcondition getMinutes()==getMinutes()@prev+1 % 60
	 */
	public void incrementMinutes() {
		this.minutes = (this.minutes + 1) % 60;
	}
	
	/**
	 * Increments seconds by 1
	 * 
	 * @precondition none
	 * @postcondition getSeconds()==getSeconds()@prev+1 % 59
	 */
	public void incrementSeconds() {
		this.seconds = (this.seconds + 1) % 60; 
	}
}
