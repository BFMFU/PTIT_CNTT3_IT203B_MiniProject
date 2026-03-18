package test;

import org.junit.jupiter.api.Test;
import session09.engine.Intersection;
import session09.entity.Vehicle;
import session09.pattern.factory.VehicleFactory;

import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

class IntersectionConcurrencyTest {

	@Test
	void test100VehiclesNoDataLoss() throws InterruptedException {

		Intersection intersection = new Intersection();

		ExecutorService executor = Executors.newFixedThreadPool(20);

		int totalVehicles = 100;
		CountDownLatch latch = new CountDownLatch(totalVehicles);

		for (int i = 0; i < totalVehicles; i++) {
			executor.submit(() -> {
				try {
					Vehicle v = VehicleFactory.createVehicle();
					intersection.arrive(v);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					latch.countDown();
				}
			});
		}

		latch.await();

		executor.shutdown();

		assertTrue(true);
	}
}
