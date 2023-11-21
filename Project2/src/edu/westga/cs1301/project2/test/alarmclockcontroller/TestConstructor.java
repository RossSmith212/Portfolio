package edu.westga.cs1301.project2.test.alarmclockcontroller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1301.project2.controllers.AlarmClockController;

public class TestConstructor {

	@Test
	public void testShouldCreateController() {
		// Arrange & Act: create the controller
		AlarmClockController controller = new AlarmClockController();
		
		// Assert: that it has a non-null clock
		assertNotNull(controller.getClock());
	}

}
