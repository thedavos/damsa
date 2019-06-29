package utils;

import app.Login;

public class Timer extends Thread {
	
	public void startCounter(Login login) throws InterruptedException {
		for (int i = 15; i >= 0; i--) {
			Login.lblCounter.setText(i + "s");
			Thread.sleep(1000);
		}
		
		//login.dispose();
		System.exit(0);
	}
	
}
