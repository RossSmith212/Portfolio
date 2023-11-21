package edu.westga.cs1301.project2.test.alarmclockformatter;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.project2.model.AlarmClock;
import edu.westga.cs1301.project2.views.AlarmClockFormatter;

class formatTimeInConversationalTone {

	@Test
	public void testShouldNotAllowNullClock() {
		// Arrange: create the formatter object
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		
		// Act & Assert: call the method with null and assert
		// it throws the exception
		assertThrows(IllegalArgumentException.class, () -> {
			formatter.FormatTimeInConversationalTone(null);
		});
	}
	@Test
	public void testShouldFormatWhenTopOfHour() {
		// Arrange: create formatter and alarm clock objects
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		AlarmClock clock = new AlarmClock(4, 00, 0);
		
		// Act call the method using the given clock as parameter
		String actual = formatter.FormatTimeInConversationalTone(clock);
		
		// Assert: that the time has been properly formatted
		assertEquals("It is " + clock.getHour() + " o'clock", actual);
	}
	@Test
	public void testShouldFormatQuarterPastHour() {
		// Arrange: create formatter and alarm clock objects
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		AlarmClock clock = new AlarmClock(4, 15, 0);
		
		// Act call the method using the given clock as parameter
		String actual = formatter.FormatTimeInConversationalTone(clock);
		
		// Assert: that the time has been properly formatted
		assertEquals("It is a quarter past " + clock.getHour(), actual);
	}
	@Test
	public void testShouldFormatHalfPastHour() {
		// Arrange: create formatter and alarm clock objects
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		AlarmClock clock = new AlarmClock(4, 30, 0);
		
		// Act call the method using the given clock as parameter
		String actual = formatter.FormatTimeInConversationalTone(clock);
		
		// Assert: that the time has been properly formatted
		assertEquals("It is half past " + clock.getHour(), actual);
	}
	@Test
	public void testShouldFormatQuarterTillNextHour() {
		// Arrange: create formatter and alarm clock objects
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		AlarmClock clock = new AlarmClock(5, 45, 0);
		
		// Act call the method using the given clock as parameter
		String actual = formatter.FormatTimeInConversationalTone(clock);
		
		// Assert: that the time has been properly formatted
		assertEquals("It is quarter-till " + clock.getHour(), actual);
	}
	@Test
	public void testShouldFormatMinutesPastTheHour() {
		// Arrange: create formatter and alarm clock objects
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		AlarmClock clock = new AlarmClock(5, 27, 0);
		
		// Act call the method using the given clock as parameter
		String actual = formatter.FormatTimeInConversationalTone(clock);
		
		// Assert: that the time has been properly formatted
		assertEquals("It is " + clock.getMinutes() + " past the hour", actual);
	}
	@Test
	public void testShouldFormatMinutesTillNextHour() {
		// Arrange: create formatter and alarm clock objects
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		AlarmClock clock = new AlarmClock(5, 31, 0);
		
		// Act call the method using the given clock as parameter
		String actual = formatter.FormatTimeInConversationalTone(clock);
		
		// Assert: that the time has been properly formatted
		assertEquals("It is " + clock.getMinutes() + " minutes till " + clock.getHour(), actual);
	}
}

