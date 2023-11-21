package edu.westga.cs1301.project2.test.alarmclockformatter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.project2.views.AlarmClockFormatter;

public class TestFindNormalizedHour {

	@Test
	public void testShouldNotAllowNegativeHour() {
		// Arrange: create a formatter object
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		
		// Act & Assert: call the method with -1 and assert
		// it throws the exception
		assertThrows(IllegalArgumentException.class, () -> {
			formatter.findNormalizedHour(-1);
		});
	}
	
	@Test
	public void testShouldNotAllowHourGreaterThan23() {
		// Arrange: create a formatter object
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		
		// Act & Assert: call the method with 24 and assert
		// it throws the exception
		assertThrows(IllegalArgumentException.class, () -> {
			formatter.findNormalizedHour(24);
		});
	}
	
	@Test
	public void testShouldNormalizeMidnight() {
		// Arrange: create a formatter object
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		
		// Act: call the method using an appropriate parameter
		int actual = formatter.findNormalizedHour(00);
		
		// Assert: that the time has been properly formatted
		assertEquals(12, actual);
	}
	
	@Test
	public void testShouldNormalize0100() {
		// Arrange: create a formatter object
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		
		// Act: call the method using an appropriate parameter
		int actual = formatter.findNormalizedHour(01);
		
		// Assert: that the time has been properly formatted
		assertEquals(1, actual);
	}

	@Test
	public void testShouldNormalize1100() {
		// Arrange: create a formatter object
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		
		// Act: call the method using an appropriate parameter
		int actual = formatter.findNormalizedHour(11);
		
		// Assert: that the time has been properly formatted
		assertEquals(11, actual);
	}
	
	@Test
	public void testShouldNormalizeNoon() {
		// Arrange: create a formatter object
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		
		// Act: call the method using an appropriate parameter
		int actual = formatter.findNormalizedHour(12);
		
		// Assert: that the time has been properly formatted
		assertEquals(12, actual);
	}
	
	@Test
	public void testShouldNormalize1300() {
		// Arrange: create a formatter object
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		
		// Act: call the method using an appropriate parameter
		int actual = formatter.findNormalizedHour(13);
		
		// Assert: that the time has been properly formatted
		assertEquals(1, actual);
	}
	
	@Test
	public void testShouldNormalize2300() {
		// Arrange: create a formatter object
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		
		// Act: call the method using an appropriate parameter
		int actual = formatter.findNormalizedHour(23);
		
		// Assert: that the time has been properly formatted
		assertEquals(11, actual);
	}
}
