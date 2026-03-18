package session09.engine;

import session09.entity.Vehicle;
import session09.exceptioin.TrafficJamException;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class Intersection {

	private final BlockingQueue<Vehicle> queue = new LinkedBlockingQueue<>();
	private final ReentrantLock lock = new ReentrantLock();

	private final int MAX_CAPACITY = 10;

	public void arrive(Vehicle v) throws TrafficJamException {
		if (queue.size() >= MAX_CAPACITY) {
			throw new TrafficJamException("Kẹt xe!");
		}
		queue.add(v);
		System.out.println(v.getId() + " vào hàng chờ");
	}

	public void process() {
		new Thread(() -> {
			while (true) {
				try {
					Vehicle v = queue.take();

					lock.lock();
					try {
						System.out.println("[PASS] " + v.getId());
						Thread.sleep(1000);
					} finally {
						lock.unlock();
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}).start();
	}
}