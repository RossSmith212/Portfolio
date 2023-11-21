package edu.westga.cs1301.project2.test.alarmclockcontroller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.project2.controllers.AlarmClockController;
import edu.westga.cs1301.project2.model.AlarmClock;

public class TestAddHours {

	@Test
	public void testShouldNotAllowHoursLessThanZero() {
		// Arrange: create a controller
		AlarmClockController controller = new AlarmClockController();
		
		// Act & Assert: call addHours with a negative value
		// and assert it throws an exception
		assertThrows(IllegalArgumentException.class, () -> {
			controller.addHours(-1);
		});
	}
	
	@Test
	public void testShouldAddZeroHours() {
		// Arrange: create a controller
		AlarmClockController controller = new AlarmClockController();
		
		// Act: call the method with an appropriate parameter
		controller.addHours(0);
		
		// Assert: that the clock has the expected number of hours
		AlarmClock clock = controller.getClock();
		assertEquals(0, clock.getHour());
	}

	@Test
	public void testShouldAddOneHour() {
		// Arrange: create a controller
		AlarmClockController controller = new AlarmClockController();
		
		// Act: call the method with an appropriate parameter
		controller.addHours(1);
		
		// Assert: that the clock has the expected number of hours
		AlarmClock clock = controller.getClock();
		assertEquals(1, clock.getHour());
	}
	
	@Test
	public void testShouldAddSeveralHours() {
		// Arrange: create a controller
		AlarmClockController controller = new AlarmClockController();
		
		// Act: call the method with an appropriate parameter
		controller.addHours(14);
		
		// Assert: that the clock has the expected number of hours
		AlarmClock clock = controller.getClock();
		assertEquals(14, clock.getHour());
	}
	
	@Test
	public void testShouldAddSeveralHoursWithRollover() {
		// Arrange: create a controller
		AlarmClockController controller = new AlarmClockController();
		
		// Act: call the method with an appropriate parameter
		controller.addHours(25);
		
		// Assert: that the clock has the expected number of hours
		AlarmClock clock = controller.getClock();
		assertEquals(1, clock.getHour());
	}
}
