package edu.westga.cs1301.project2.controllers;

import edu.westga.cs1301.project2.model.AlarmClock;

/**
 * Controller for an AlarmClock
 * 
 * @author	CS1301
 * @version	Spring 2021
 *
 */
public class AlarmClockController {

	AlarmClock theClock; 
	
	/**
	 * Creates a new AlarmClockController containing an AlarmClock.
	 * 
	 * @precondition none
	 * @postcondition getAlarmClock().getHour()==0 AND getAlarmClock().getMinutes()==0
	 */
	public AlarmClockController() {
		AlarmClock theClock = new AlarmClock(); 
		this.theClock = theClock; 
	}

	/**
	 * Gets the Alarm Clock Object
	 * 
	 * @preCondition none
	 * @postCondition none
	 * @return the AlarmClock Object
	 */
	public AlarmClock getClock() {
		return this.theClock; 
	}
	
	/**
	 * Adds the given number of hours to the clock
	 * 
	 * @precondition hours >= 0
	 * @postcondition getClock().getHours() == getClock().getHours() @prev + hours % 24
	 * 
	 * @param hours: The number of hours to add
	 */
	public int addHours(int hours) {
		if (hours < 0) {
			throw new IllegalArgumentException("Hours cannot be less than 0"); 
		}
		for (int i = 0; i < hours; i++ ) {
			this.theClock.incrementHour(); 
		}
		return hours; 
	}
	
	/**
	 * Adds the given number of minutes to clock with Hours Roll Over
	 * 
	 * @precondition minutes >= 0
	 * @postCondition getClock().getMinutes() == getClock().getMinutes() @prev + minutes % 60
	 * 
	 * @param minutes: The number of minutes to add
	 */
	public int addMinutes(int minutes) {
		if (minutes < 0) {
			throw new IllegalArgumentException("Minutes cannot be less than 0");
		}
		
		int hoursToAdd = minutes / 60; 
		int minutesToAdd = minutes % 60; 
		
		for (int i = 0; i < hoursToAdd; i++) { 
			this.theClock.incrementHour();
		}
		for (int i = 0; i < minutesToAdd; i++) {
			this.theClock.incrementMinutes();
		}
		return minutes; 
	}
	
	/**
	 * Adds the given number of minutes to the clock with minutes and hours roll over
	 * 
	 * @precondition seconds >= 0 
	 * @postcondition getClock().getSeconds() == getClock().getSeconds() @prev + seconds % 60
	 * 
	 * @param seconds: the number of seconds to add
	 */
	public int addSeconds(int seconds) {
		if (seconds < 0) {
			throw new IllegalArgumentException("Seconds is too low"); 
		}
		
		int secondsInHour = seconds / 3600; 
		int minutesToAdd = seconds / 60; 
		int secondsToAdd = seconds % 60;
		
		for (int i = 0; i < secondsInHour; i++) {
			this.theClock.incrementHour(); 
		}
		for (int i = 0; i < minutesToAdd; i++) {
			this.theClock.incrementMinutes();
		}
		for (int i = 0; i < secondsToAdd; i++) {
			this.theClock.incrementSeconds();
		}
		return seconds; 
	}
}
