package edu.westga.cs1301.project2.test.alarmclockformatter;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.project2.model.AlarmClock;
import edu.westga.cs1301.project2.views.AlarmClockFormatter;

class TestFormatTimeBasedOnCityTimeZone {

	@Test
	public void testShouldNotAllowNullClock() {
		/// Arrange: create the formatter object
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		
		// Act & Assert: call the method with null and assert
		// it throws the exception
		assertThrows(IllegalArgumentException.class, () -> {
			formatter.formatTimeBasedOnCityTimeZone(0, null);
		});
	}
	
	@Test
	public void testShouldNotBeLessThan1() {
		// Arrange: create a controller
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		
		// Act & Assert: call addHours with a negative value
		// and assert it throws an exception
		assertThrows(IllegalArgumentException.class, () -> {
			formatter.formatTimeBasedOnCityTimeZone(0, null);
		});
	}
		@Test
		public void testShouldNotBeMoreThan5() {
			// Arrange: create a controller
			AlarmClockFormatter formatter = new AlarmClockFormatter();
			
			// Act & Assert: call addHours with a negative value
			// and assert it throws an exception
			assertThrows(IllegalArgumentException.class, () -> {
				formatter.formatTimeBasedOnCityTimeZone(6, null);
			});	
	}
		
	@Test
	public void testShouldFormat1ToBeAtlanta() {
		// Arrange: create formatter and alarm clock objects
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		AlarmClock clock = new AlarmClock(4, 30, 16);
		
		// Act call the method using the given clock as parameter
		String actual = formatter.formatTimeBasedOnCityTimeZone(1, clock);
		
		// Assert: that the time has been properly formatted
		assertEquals("The time is " + clock.getHour() +":" + clock.getMinutes() + " in Atlanta" , actual);
	}
	
	@Test
	public void testShouldFormat2ToBeChicago() {
		// Arrange: create formatter and alarm clock objects
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		AlarmClock clock = new AlarmClock(4, 30, 16);
		
		// Act call the method using the given clock as parameter
		String actual = formatter.formatTimeBasedOnCityTimeZone(2, clock);
		
		// Assert: that the time has been properly formatted
		assertEquals("The time is " + clock.getHour() +":" + clock.getMinutes() + " in Chicago" , actual);
	}
	@Test
	public void testShouldFormat23ToBeSantaFe() {
		// Arrange: create formatter and alarm clock objects
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		AlarmClock clock = new AlarmClock(4, 30, 16);
		
		// Act call the method using the given clock as parameter
		String actual = formatter.formatTimeBasedOnCityTimeZone(3, clock);
		
		// Assert: that the time has been properly formatted
		assertEquals("The time is " + clock.getHour() +":" + clock.getMinutes() + " in Santa Fe" , actual);
	}
	
	@Test
	public void testShouldFormat4ToBeSacramento() {
		// Arrange: create formatter and alarm clock objects
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		AlarmClock clock = new AlarmClock(4, 30, 16);
		
		// Act call the method using the given clock as parameter
		String actual = formatter.formatTimeBasedOnCityTimeZone(4, clock);
		
		// Assert: that the time has been properly formatted
		assertEquals("The time is " + clock.getHour() +":" + clock.getMinutes() + " in Sacramento" , actual);
	}
	
	@Test
	public void testShouldFormat5ToNotApplicable() {
		// Arrange: create formatter and alarm clock objects
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		AlarmClock clock = new AlarmClock(4, 30, 16);
		
		// Act call the method using the given clock as parameter
		String actual = formatter.formatTimeBasedOnCityTimeZone(5, clock);
		
		// Assert: that the time has been properly formatted
		assertEquals("The time is " + clock.getHour() +":" + clock.getMinutes() + " in Not Applicable" , actual);
	}
}


