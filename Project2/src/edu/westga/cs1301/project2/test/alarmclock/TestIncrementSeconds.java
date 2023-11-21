package edu.westga.cs1301.project2.test.alarmclock;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.project2.model.AlarmClock;

public class TestIncrementSeconds {

	@Test
	public void testShouldIncrementSecondsOfZero() {
		// Arrange: create an AlarmClock (defaults to 0 seconds)
		AlarmClock clock = new AlarmClock(10, 0, 0);
		
		// Act: increment the seconds
		clock.incrementSeconds();
		
		// Assert: that the actual seconds matches our expected seconds
		assertEquals(1, clock.getSeconds());
	}
	
	@Test
	public void testShouldIncrementManySeconds() {
		// Arrange: create an AlarmClock (defaults to 0 seconds)
		AlarmClock clock = new AlarmClock(10, 0, 0);
		
		// Act: increment the seconds several times
		for (int i = 0; i < 10; i++) {
			clock.incrementSeconds();
		}
		
		// Assert: that the actual seconds matches our expected seconds
		assertEquals(10, clock.getSeconds());
	}
	
	@Test
	public void testShouldIncrementEnoughSecondsToRollOver() {
		// Arrange: create an AlarmClock (defaults to 0 seconds)
		AlarmClock clock = new AlarmClock(10, 0, 0);
		
		// Act: increment the seconds several times
		for (int i = 0; i < 65; i++) {
			clock.incrementSeconds();
		}
		
		// Assert: that the actual seconds matches our expected seconds
		assertEquals(5, clock.getSeconds());
	}

}
