package session09.engine;

import session09.pattern.observer.Observer;
import session09.pattern.observer.Subject;
import session09.pattern.state.LightState;
import session09.pattern.state.RedState;

import java.util.ArrayList;
import java.util.List;

public class TrafficLight implements Runnable, Subject {

	private LightState state;
	private List<Observer> observers = new ArrayList<>();

	public TrafficLight() {
		state = new RedState();
	}

	public void setState(LightState state) {
		this.state = state;
	}

	public String getColor() {
		return state.getColor();
	}

	@Override
	public void run() {
		try {
			while (true) {
				String color = getColor();
				System.out.println("Đèn: " + color);

				notifyObservers(color);

				Thread.sleep(3000);
				state.next(this);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void attach(Observer o) {
		observers.add(o);
	}

	@Override
	public void notifyObservers(String signal) {
		for (Observer o : observers) {
			o.update(signal);
		}
	}
}