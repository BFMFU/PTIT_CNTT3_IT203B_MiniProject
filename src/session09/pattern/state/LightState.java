package session09.pattern.state;

import session09.engine.TrafficLight;

public interface LightState {
	void next(session09.engine.TrafficLight light);
	String getColor();
}