package edu.westga.cs1301.project2.test.alarmclockformatter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.project2.model.AlarmClock;
import edu.westga.cs1301.project2.views.AlarmClockFormatter;

public class TestFormatMinutesInConversationalTone {

	@Test
	public void testShouldNotAllowNullClock() {
		// Arrange: create the formatter object
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		
		// Act & Assert: call the method with null and assert
		// it throws the exception
		assertThrows(IllegalArgumentException.class, () -> {
			formatter.formatMinutesInConversationalTone(null);
		});
	}
	
	@Test
	public void testShouldFormatAtTopOfTheHour() {
		// Arrange: create formatter and alarm clock objects
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		AlarmClock clock = new AlarmClock(4, 00, 0);
		
		// Act call the method using the given clock as parameter
		String actual = formatter.formatMinutesInConversationalTone(clock);
		
		// Assert: that the time has been properly formatted
		assertEquals("It is the top-of-the-hour", actual);
	}
	
	@Test
	public void testShouldFormatAtOnePastTheHour() {
		// Arrange: create formatter and alarm clock objects
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		AlarmClock clock = new AlarmClock(4, 01, 0);
		
		// Act call the method using the given clock as parameter
		String actual = formatter.formatMinutesInConversationalTone(clock);
		
		// Assert: that the time has been properly formatted
		assertEquals("It is 1 minutes past the hour", actual);
	}

	@Test
	public void testShouldFormatAt14PastTheHour() {
		// Arrange: create formatter and alarm clock objects
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		AlarmClock clock = new AlarmClock(4, 14, 0);
		
		// Act call the method using the given clock as parameter
		String actual = formatter.formatMinutesInConversationalTone(clock);
		
		// Assert: that the time has been properly formatted
		assertEquals("It is 14 minutes past the hour", actual);
	}
	
	@Test
	public void testShouldFormatAtQuarterPastTheHour() {
		// Arrange: create formatter and alarm clock objects
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		AlarmClock clock = new AlarmClock(4, 15, 0);
		
		// Act call the method using the given clock as parameter
		String actual = formatter.formatMinutesInConversationalTone(clock);
		
		// Assert: that the time has been properly formatted
		assertEquals("It is quarter-past the hour", actual);
	}
	
	@Test
	public void testShouldFormatAt16PastTheHour() {
		// Arrange: create formatter and alarm clock objects
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		AlarmClock clock = new AlarmClock(4, 16, 0);
		
		// Act call the method using the given clock as parameter
		String actual = formatter.formatMinutesInConversationalTone(clock);
		
		// Assert: that the time has been properly formatted
		assertEquals("It is 16 minutes past the hour", actual);
	}
	
	@Test
	public void testShouldFormatAt29PastTheHour() {
		// Arrange: create formatter and alarm clock objects
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		AlarmClock clock = new AlarmClock(4, 29, 0);
		
		// Act call the method using the given clock as parameter
		String actual = formatter.formatMinutesInConversationalTone(clock);
		
		// Assert: that the time has been properly formatted
		assertEquals("It is 29 minutes past the hour", actual);
	}
	
	@Test
	public void testShouldFormatAtHalfPastTheHour() {
		// Arrange: create formatter and alarm clock objects
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		AlarmClock clock = new AlarmClock(4, 30, 0);
		
		// Act call the method using the given clock as parameter
		String actual = formatter.formatMinutesInConversationalTone(clock);
		
		// Assert: that the time has been properly formatted
		assertEquals("It is half-past the hour", actual);
	}
	
	@Test
	public void testShouldFormatAt31PastTheHour() {
		// Arrange: create formatter and alarm clock objects
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		AlarmClock clock = new AlarmClock(4, 31, 0);
		
		// Act call the method using the given clock as parameter
		String actual = formatter.formatMinutesInConversationalTone(clock);
		
		// Assert: that the time has been properly formatted
		assertEquals("It is 31 minutes past the hour", actual);
	}
	
	@Test
	public void testShouldFormatAt44PastTheHour() {
		// Arrange: create formatter and alarm clock objects
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		AlarmClock clock = new AlarmClock(4, 44, 0);
		
		// Act call the method using the given clock as parameter
		String actual = formatter.formatMinutesInConversationalTone(clock);
		
		// Assert: that the time has been properly formatted
		assertEquals("It is 44 minutes past the hour", actual);
	}
	
	@Test
	public void testShouldFormatAtQuarterTillTheHour() {
		// Arrange: create formatter and alarm clock objects
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		AlarmClock clock = new AlarmClock(4, 45, 0);
		
		// Act call the method using the given clock as parameter
		String actual = formatter.formatMinutesInConversationalTone(clock);
		
		// Assert: that the time has been properly formatted
		assertEquals("It is quarter-till the hour", actual);
	}
	
	@Test
	public void testShouldFormatAt46PastTheHour() {
		// Arrange: create formatter and alarm clock objects
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		AlarmClock clock = new AlarmClock(4, 46, 0);
		
		// Act call the method using the given clock as parameter
		String actual = formatter.formatMinutesInConversationalTone(clock);
		
		// Assert: that the time has been properly formatted
		assertEquals("It is 46 minutes past the hour", actual);
	}
	
	@Test
	public void testShouldFormatAt59PastTheHour() {
		// Arrange: create formatter and alarm clock objects
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		AlarmClock clock = new AlarmClock(4, 59, 0);
		
		// Act call the method using the given clock as parameter
		String actual = formatter.formatMinutesInConversationalTone(clock);
		
		// Assert: that the time has been properly formatted
		assertEquals("It is 59 minutes past the hour", actual);
	}
}
