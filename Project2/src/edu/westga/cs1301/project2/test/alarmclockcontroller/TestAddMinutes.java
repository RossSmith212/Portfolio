package edu.westga.cs1301.project2.test.alarmclockcontroller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.project2.controllers.AlarmClockController;
import edu.westga.cs1301.project2.model.AlarmClock;

public class TestAddMinutes {

	@Test
	public void testShouldNotAllowMinutesLessThanZero() {
		// Arrange: create a controller
		AlarmClockController controller = new AlarmClockController();
		
		// Act & Assert: call addMinutes with a negative value
		// and assert it throws an exception
		assertThrows(IllegalArgumentException.class, () -> {
			controller.addMinutes(-1);
		});
	}
	
	@Test
	public void testShouldAddZeroMinutes() {
		// Arrange: create a controller
		AlarmClockController controller = new AlarmClockController();
		
		// Act: call the method with an appropriate parameter
		controller.addMinutes(0);
		
		// Assert: that the clock has the expected number of minutes
		AlarmClock clock = controller.getClock();
		assertEquals(0, clock.getHour());
		assertEquals(0, clock.getMinutes());
	}

	@Test
	public void testShouldAddOneMinute() {
		// Arrange: create a controller
		AlarmClockController controller = new AlarmClockController();
		
		// Act: call the method with an appropriate parameter
		controller.addMinutes(1);
		
		// Assert: that the clock has the expected number of minutes
		AlarmClock clock = controller.getClock();
		assertEquals(0, clock.getHour());
		assertEquals(1, clock.getMinutes());
	}
	
	@Test
	public void testShouldAddSeveralMinutes() {
		// Arrange: create a controller
		AlarmClockController controller = new AlarmClockController();
		
		// Act: call the method with an appropriate parameter
		controller.addMinutes(10);
		
		// Assert: that the clock has the expected number of minutes
		AlarmClock clock = controller.getClock();
		assertEquals(0, clock.getHour());
		assertEquals(10, clock.getMinutes());
	}
	
	@Test
	public void testShouldAddSeveralMinutesWithMinutesRollover() {
		// Arrange: create a controller
		AlarmClockController controller = new AlarmClockController();
		
		// Act: call the method with an appropriate parameter
		controller.addMinutes(65);
		
		// Assert: that the clock has the expected number of minutes
		AlarmClock clock = controller.getClock();
		assertEquals(1, clock.getHour());
		assertEquals(5, clock.getMinutes());
	}
	
	@Test
	public void testShouldAddSeveralMinutesWithHoursRollover() {
		// Arrange: create a controller
		AlarmClockController controller = new AlarmClockController();
		
		// Act: call the method with an appropriate parameter
		controller.addMinutes(26*60 + 10);
		
		// Assert: that the clock has the expected number of minutes
		AlarmClock clock = controller.getClock();
		assertEquals(2, clock.getHour());
		assertEquals(10, clock.getMinutes());
	}
}
