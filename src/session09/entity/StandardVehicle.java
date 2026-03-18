package session09.entity;

public class StandardVehicle extends Vehicle {

	public StandardVehicle(String id, int speed) {
		super(id, speed);
	}

	@Override
	public boolean isPriority() {
		return false;
	}

	@Override
	public void run() {
		System.out.println(id + " đang di chuyển...");
	}
}