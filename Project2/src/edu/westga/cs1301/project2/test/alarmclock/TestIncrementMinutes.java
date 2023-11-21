package edu.westga.cs1301.project2.test.alarmclock;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.project2.model.AlarmClock;

public class TestIncrementMinutes {

	@Test
	public void testShouldIncrementMinutesOfZero() {
		// Arrange: create an AlarmClock with the appropriate minutes
		AlarmClock clock = new AlarmClock(10, 0, 0);
		
		// Act: increment the minutes
		clock.incrementMinutes();
		
		// Assert: that the actual minutes matches our expected minutes
		assertEquals(1, clock.getMinutes());
	}
	
	@Test
	public void testShouldIncrementNonBoundaryMinutes() {
		// Arrange: create an AlarmClock with the appropriate minutes
		AlarmClock clock = new AlarmClock(10, 44, 0);
		
		// Act: increment the minutes
		clock.incrementMinutes();
		
		// Assert: that the actual minutes matches our expected minutes
		assertEquals(45, clock.getMinutes());
	}
	
	@Test
	public void testShouldIncrementMinutesOf59() {
		// Arrange: create an AlarmClock with the appropriate minutes
		AlarmClock clock = new AlarmClock(10, 59, 0);
		
		// Act: increment the minutes
		clock.incrementMinutes();
		
		// Assert: that the actual minutes matches our expected minutes
		assertEquals(0, clock.getMinutes());
	}
	
	@Test
	public void testShouldIncrementSeveralMinutes() {
		// Arrange: create an AlarmClock with the appropriate minutes
		AlarmClock clock = new AlarmClock(10, 0, 0);
		
		// Act: increment the minutes
		for (int i = 0; i < 10; i++) {
			clock.incrementMinutes();
		}
		
		// Assert: that the actual minutes matches our expected minutes
		assertEquals(10, clock.getMinutes());
	}

}
