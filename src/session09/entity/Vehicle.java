package session09.entity;

import session09.pattern.observer.Observer;

public abstract class Vehicle implements Runnable, Observer {
	protected String id;
	protected int speed;
	protected volatile String currentLight = "RED";

	public Vehicle(String id, int speed) {
		this.id = id;
		this.speed = speed;
	}

	public abstract boolean isPriority();

	@Override
	public void update(String signal) {
		this.currentLight = signal;
	}

	public void waitForGreen() {
		while (!currentLight.equals("GREEN")) {
			if (isPriority()) break; // xe ưu tiên bỏ qua đèn đỏ

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public String getId() {
		return id;
	}
}