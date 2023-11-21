package edu.westga.cs1301.project2.test.alarmclock;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.project2.model.AlarmClock;

public class TestIncrementHour {

	@Test
	public void testShouldIncrementHourOfZero() {
		// Arrange: create an AlarmClock with the appropriate hour
		AlarmClock clock = new AlarmClock(0, 30, 0);
		
		// Act: increment the hour
		clock.incrementHour();
		
		// Assert: that the actual hour matches our expected hour
		assertEquals(1, clock.getHour());
	}
	
	@Test
	public void testShouldIncrementNonBoundaryHour() {
		// Arrange: create an AlarmClock with the appropriate hour
		AlarmClock clock = new AlarmClock(3, 30, 0);
		
		// Act: increment the hour
		clock.incrementHour();
		
		// Assert: that the actual hour matches our expected hour
		assertEquals(4, clock.getHour());
	}
	
	@Test
	public void testShouldIncrementHourOf23() {
		// Arrange: create an AlarmClock with the appropriate hour
		AlarmClock clock = new AlarmClock(23, 30, 0);
		
		// Act: increment the hour
		clock.incrementHour();
		
		// Assert: that the actual hour matches our expected hour
		assertEquals(0, clock.getHour());
	}
	
	@Test
	public void testShouldIncrementSeveralHours() {
		// Arrange: create an AlarmClock with the appropriate hour
		AlarmClock clock = new AlarmClock(3, 30, 0);
		
		// Act: increment the hour
		for (int i = 0; i < 10; i++) {
			clock.incrementHour();
		}	
		
		// Assert: that the actual hour matches our expected hour
		assertEquals(13, clock.getHour());
	}

}
