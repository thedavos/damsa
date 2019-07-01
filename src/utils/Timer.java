package utils;

import app.Login;

public class Timer extends Thread {
	
	public void startThread() {
		start();
	}
	
	public void startCounter(Login login) throws Throwable {
		System.out.println(login);
		for (int i = 30; i >= 0; i--) {
			Login.lblCounter.setText(i + "s");
			Thread.sleep(1000);
		}
		login.dispose();
	}
	
}
