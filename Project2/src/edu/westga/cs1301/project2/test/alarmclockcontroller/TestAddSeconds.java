package edu.westga.cs1301.project2.test.alarmclockcontroller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.project2.controllers.AlarmClockController;
import edu.westga.cs1301.project2.model.AlarmClock;

public class TestAddSeconds {

	@Test
	public void testShouldNotAllowSecondsLessThanZero() {
		// Arrange: create a controller
		AlarmClockController controller = new AlarmClockController();
		
		// Act & Assert: call addSeconds with a negative value
		// and assert it throws an exception
		assertThrows(IllegalArgumentException.class, () -> {
			controller.addSeconds(-1);
		});
	}
	
	@Test
	public void testShouldAddZeroSeconds() {
		// Arrange: create a controller
		AlarmClockController controller = new AlarmClockController();
		
		// Act: call the method with an appropriate parameter
		controller.addSeconds(0);
		
		// Assert: that the clock has the expected number of seconds
		AlarmClock clock = controller.getClock();
		assertEquals(0, clock.getHour());
		assertEquals(0, clock.getMinutes());
		assertEquals(0, clock.getSeconds());
	}

	@Test
	public void testShouldAddOneSecond() {
		// Arrange: create a controller
		AlarmClockController controller = new AlarmClockController();
		
		// Act: call the method with an appropriate parameter
		controller.addSeconds(1);
		
		// Assert: that the clock has the expected number of seconds
		AlarmClock clock = controller.getClock();
		assertEquals(0, clock.getHour());
		assertEquals(0, clock.getMinutes());
		assertEquals(1, clock.getSeconds());
	}
	
	@Test
	public void testShouldAddSeveralSeconds() {
		// Arrange: create a controller
		AlarmClockController controller = new AlarmClockController();
		
		// Act: call the method with an appropriate parameter
		controller.addSeconds(20);
		
		// Assert: that the clock has the expected number of seconds
		AlarmClock clock = controller.getClock();
		assertEquals(0, clock.getHour());
		assertEquals(0, clock.getMinutes());
		assertEquals(20, clock.getSeconds());
	}
	
	@Test
	public void testShouldAddSeveralSecondsWithSecondsRollover() {
		// Arrange: create a controller
		AlarmClockController controller = new AlarmClockController();
		
		// Act: call the method with an appropriate parameter
		controller.addSeconds(65);
		
		// Assert: that the clock has the expected number of seconds
		AlarmClock clock = controller.getClock();
		assertEquals(0, clock.getHour());
		assertEquals(1, clock.getMinutes());
		assertEquals(5, clock.getSeconds());
	}
	
	@Test
	public void testShouldAddSeveralSecondsWithMinutesRollover() {
		// Arrange: create a controller
		AlarmClockController controller = new AlarmClockController();
		
		// Act: call the method with an appropriate parameter
		controller.addSeconds(60*60 + 2*60 + 5);
		
		// Assert: that the clock has the expected number of seconds
		AlarmClock clock = controller.getClock();
		assertEquals(1, clock.getHour());
		assertEquals(2, clock.getMinutes());
		assertEquals(5, clock.getSeconds());
	}
	
	@Test
	public void testShouldAddSeveralSecondsWithHoursRollover() {
		// Arrange: create a controller
		AlarmClockController controller = new AlarmClockController();
		
		// Act: call the method with an appropriate parameter
		controller.addSeconds(26*60*60 + 2*60 + 5);
		
		// Assert: that the clock has the expected number of seconds
		AlarmClock clock = controller.getClock();
		assertEquals(2, clock.getHour());
		assertEquals(2, clock.getMinutes());
		assertEquals(5, clock.getSeconds());
	}
}
