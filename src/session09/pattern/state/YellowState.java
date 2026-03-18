package session09.pattern.state;

import session09.engine.TrafficLight;

public class YellowState implements LightState {

	@Override
	public void next(TrafficLight light) {
		light.setState(new RedState());
	}

	@Override
	public String getColor() {
		return "YELLOW";
	}
}
