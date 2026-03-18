package session09.util;

public class Logger {
	public static void log(String msg) {
		System.out.println("[Time: " + System.currentTimeMillis()/1000 + "s] " + msg);
	}
}