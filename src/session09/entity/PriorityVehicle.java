package session09.entity;

public class PriorityVehicle extends Vehicle {

	public PriorityVehicle(String id, int speed) {
		super(id, speed);
	}

	@Override
	public boolean isPriority() {
		return true;
	}

	@Override
	public void run() {
		System.out.println(id + " (Ưu tiên) vượt đèn!");
	}
}