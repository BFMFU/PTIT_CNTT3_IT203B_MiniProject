package session09.pattern.observer;

public interface Subject {
	void attach(Observer o);
	void notifyObservers(String signal);
}