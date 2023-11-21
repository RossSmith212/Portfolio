package edu.westga.cs1301.project2.test.alarmclockformatter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.project2.views.AlarmClockFormatter;

public class TestConvertToTwoDigitNumericString {

	@Test
	public void testShouldNotAllowValueLessThanZero() {
		// Arrange: create the formatter object
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		
		// Act & Assert: call the method with -1 and assert
		// it throws the exception
		assertThrows(IllegalArgumentException.class, () -> {
			formatter.convertToTwoDigitNumericString(-1);
		});
	}
	
	@Test
	public void testShouldNotAllowValueGreaterThan59() {
		// Arrange: create the formatter object
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		
		// Act & Assert: call the method with 60 and assert
		// it throws the exception
		assertThrows(IllegalArgumentException.class, () -> {
			formatter.convertToTwoDigitNumericString(60);
		});
	}

	@Test
	public void testShouldConvertZero() {
		// Arrange: create formatter and alarm clock objects
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		
		// Act call the method using with an appropriate parameter
		String actual = formatter.convertToTwoDigitNumericString(0);
		
		// Assert: that we get the expected result
		assertEquals("00", actual);
	}
	
	@Test
	public void testShouldConvertNine() {
		// Arrange: create formatter and alarm clock objects
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		
		// Act call the method using with an appropriate parameter
		String actual = formatter.convertToTwoDigitNumericString(9);
		
		// Assert: that we get the expected result
		assertEquals("09", actual);
	}
	
	@Test
	public void testShouldConvertTen() {
		// Arrange: create formatter and alarm clock objects
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		
		// Act call the method using with an appropriate parameter
		String actual = formatter.convertToTwoDigitNumericString(10);
		
		// Assert: that we get the expected result
		assertEquals("10", actual);
	}
	
	@Test
	public void testShouldConvert59() {
		// Arrange: create formatter and alarm clock objects
		AlarmClockFormatter formatter = new AlarmClockFormatter();
		
		// Act call the method using with an appropriate parameter
		String actual = formatter.convertToTwoDigitNumericString(59);
		
		// Assert: that we get the expected result
		assertEquals("59", actual);
	}
}
