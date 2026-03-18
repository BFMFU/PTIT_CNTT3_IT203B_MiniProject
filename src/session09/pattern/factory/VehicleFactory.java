package session09.pattern.factory;

import session09.entity.PriorityVehicle;
import session09.entity.StandardVehicle;
import session09.entity.Vehicle;

import java.util.Random;

public class VehicleFactory {
	private static int count = 0;
	private static Random random = new Random();

	public static Vehicle createVehicle() {
		count++;
		int type = random.nextInt(4);

		switch (type) {
			case 0:
				return new PriorityVehicle("Ambulance-" + count, 100);
			default:
				return new StandardVehicle("Car-" + count, 60);
		}
	}
}