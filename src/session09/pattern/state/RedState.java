package session09.pattern.state;

import session09.engine.TrafficLight;

public class RedState implements LightState {

	@Override
	public void next(TrafficLight light) {
		light.setState(new GreenState());
	}

	@Override
	public String getColor() {
		return "RED";
	}
}