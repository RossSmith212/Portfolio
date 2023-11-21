package edu.westga.cs1301.project2.test.alarmclockformatter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.project2.model.AlarmClock;
import edu.westga.cs1301.project2.views.AlarmClockFormatter;

public class TestFindAmVsPm {

	@Test
	public void testShouldNotAllowNullClock() {
		// Arrange: create the formatter object
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		
		// Act & Assert: call the method with null and assert
		// it throws the exception
		assertThrows(IllegalArgumentException.class, () -> {
			formatter.findAmVsPm(null);
		});
	}
	
	@Test
	public void testShouldBeAmAtMidnight() {
		// Arrange: create formatter and alarm clock objects
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		AlarmClock clock = new AlarmClock(00, 00, 0);
		
		// Act call the method using the given clock as parameter
		String actual = formatter.findAmVsPm(clock);
		
		// Assert: that the time has been properly formatted
		assertEquals("AM", actual);
	}
	
	@Test
	public void testShouldBeAmAt0100() {
		// Arrange: create formatter and alarm clock objects
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		AlarmClock clock = new AlarmClock(01, 00, 0);
		
		// Act call the method using the given clock as parameter
		String actual = formatter.findAmVsPm(clock);
		
		// Assert: that the time has been properly formatted
		assertEquals("AM", actual);
	}
	
	@Test
	public void testShouldBeAmAt1100() {
		// Arrange: create formatter and alarm clock objects
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		AlarmClock clock = new AlarmClock(11, 00, 0);
		
		// Act call the method using the given clock as parameter
		String actual = formatter.findAmVsPm(clock);
		
		// Assert: that the time has been properly formatted
		assertEquals("AM", actual);
	}
	
	@Test
	public void testShouldBePmAtNoon() {
		// Arrange: create formatter and alarm clock objects
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		AlarmClock clock = new AlarmClock(12, 00, 0);
		
		// Act call the method using the given clock as parameter
		String actual = formatter.findAmVsPm(clock);
		
		// Assert: that the time has been properly formatted
		assertEquals("PM", actual);
	}

	@Test
	public void testShouldBePmAt1300() {
		// Arrange: create formatter and alarm clock objects
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		AlarmClock clock = new AlarmClock(13, 00, 0);
		
		// Act call the method using the given clock as parameter
		String actual = formatter.findAmVsPm(clock);
		
		// Assert: that the time has been properly formatted
		assertEquals("PM", actual);
	}
	
	@Test
	public void testShouldBePmAt2300() {
		// Arrange: create formatter and alarm clock objects
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		AlarmClock clock = new AlarmClock(23, 00, 0);
		
		// Act call the method using the given clock as parameter
		String actual = formatter.findAmVsPm(clock);
		
		// Assert: that the time has been properly formatted
		assertEquals("PM", actual);
	}
}
