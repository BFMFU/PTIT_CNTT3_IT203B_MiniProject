package test;

import org.junit.jupiter.api.Test;
import session09.engine.TrafficLight;

import static org.junit.jupiter.api.Assertions.*;

class TrafficLightTest {

	@Test
	void testTrafficLightCycle() throws InterruptedException {
		TrafficLight light = new TrafficLight();

		Thread thread = new Thread(light);
		thread.setDaemon(true);
		thread.start();

		Thread.sleep(100);

		String first = light.getColor();

		Thread.sleep(3100); // sau 3s đổi state
		String second = light.getColor();

		Thread.sleep(3100);
		String third = light.getColor();

		assertNotEquals(first, second);
		assertNotEquals(second, third);
	}
}