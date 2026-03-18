package session09;

import session09.engine.SimulationEngine;
import session09.engine.TrafficLight;

public class Main {
	public static void main(String[] args) {

		TrafficLight light = new TrafficLight();
		Thread lightThread = new Thread(light);
		lightThread.setDaemon(true);
		lightThread.start();

		SimulationEngine engine = new SimulationEngine();
		engine.start();
	}
}
