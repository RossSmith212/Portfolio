package edu.westga.cs1301.project2.test.alarmclock;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.project2.model.AlarmClock;

public class TestConstructor {

	@Test
	public void testShouldCreateWithZeroParamConstructor() {
		// Arrange & Act: create the AlarmClock object
		AlarmClock clock = new AlarmClock();
		
		// Assert: that its initial values are correct
		assertEquals(0, clock.getHour());
		assertEquals(0, clock.getMinutes());
	}

	@Test
	public void testShouldNotAllowHourLessThanZero() {
		// Arrange, Act, and Assert: create the AlarmClock object
		// with a bad hour value
		assertThrows(IllegalArgumentException.class, () -> {
			new AlarmClock(-1, 45, 0);
		});
	}
	
	@Test
	public void testShouldNotAllowHourGreaterThan23() {
		// Arrange, Act, and Assert: create the AlarmClock object
		// with a bad hour value
		assertThrows(IllegalArgumentException.class, () -> {
			new AlarmClock(24, 45, 0);
		});
	}
	
	@Test
	public void testShouldNotAllowMinutesLessThanZero() {
		// Arrange, Act, and Assert: create the AlarmClock object
		// with a bad minutes value
		assertThrows(IllegalArgumentException.class, () -> {
			new AlarmClock(12, -1, 0);
		});
	}
	
	@Test
	public void testShouldNotAllowMinutesGreaterThan59() {
		// Arrange, Act, and Assert: create the AlarmClock object
		// with a bad minutes value
		assertThrows(IllegalArgumentException.class, () -> {
			new AlarmClock(12, 60, 0);
		});
	}
	
	@Test
	public void testShouldCreateAtHourZero() {
		// Arrange & Act: create the AlarmClock object
		AlarmClock clock = new AlarmClock(0, 45, 0);
		
		// Assert: that its initial values are correct
		assertEquals(0, clock.getHour());
		assertEquals(45, clock.getMinutes());
	}
	
	@Test
	public void testShouldCreateAtHour23() {
		// Arrange & Act: create the AlarmClock object
		AlarmClock clock = new AlarmClock(23, 45, 0);
		
		// Assert: that its initial values are correct
		assertEquals(23, clock.getHour());
		assertEquals(45, clock.getMinutes());
	}
	
	@Test
	public void testShouldCreateAtMinutesZero() {
		// Arrange & Act: create the AlarmClock object
		AlarmClock clock = new AlarmClock(12, 0, 0);
		
		// Assert: that its initial values are correct
		assertEquals(12, clock.getHour());
		assertEquals(0, clock.getMinutes());
	}
	
	@Test
	public void testShouldCreateAtMinutes59() {
		// Arrange & Act: create the AlarmClock object
		AlarmClock clock = new AlarmClock(12, 59, 0);
		
		// Assert: that its initial values are correct
		assertEquals(12, clock.getHour());
		assertEquals(59, clock.getMinutes());
	}
	
	@Test
	public void testShouldCreateWithTwoParamConstructor() {
		// Arrange & Act: create the AlarmClock object
		AlarmClock clock = new AlarmClock(8, 45, 0);
		
		// Assert: that its initial values are correct
		assertEquals(8, clock.getHour());
		assertEquals(45, clock.getMinutes());
	}
}
