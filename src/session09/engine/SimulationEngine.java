package session09.engine;

import session09.entity.Vehicle;
import session09.exceptioin.TrafficJamException;
import session09.pattern.factory.VehicleFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimulationEngine {

	private final Intersection intersection = new Intersection();
	private final TrafficLight light = new TrafficLight();
	private final ExecutorService executor = Executors.newFixedThreadPool(10);

	public void start() {

		Thread lightThread = new Thread(light);
		lightThread.setDaemon(true);
		lightThread.start();

		intersection.process();

		for (int i = 0; i < 30; i++) {
			Vehicle v = VehicleFactory.createVehicle();

			light.attach(v);

			executor.submit(() -> {
				try {
					v.waitForGreen();
					intersection.arrive(v);
				} catch (TrafficJamException e) {
					System.out.println(e.getMessage());
				}
			});

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
