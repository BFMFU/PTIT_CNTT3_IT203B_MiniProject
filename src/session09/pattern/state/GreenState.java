package session09.pattern.state;

import session09.engine.TrafficLight;

public class GreenState implements LightState {

	@Override
	public void next(TrafficLight light) {
		light.setState(new YellowState());
	}

	@Override
	public String getColor() {
		return "GREEN";
	}
}