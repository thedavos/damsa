package utils;

import app.Login;

public class Timer extends Thread {
	
	public void startCounter() throws InterruptedException {
		for (int i = 10; i >= 0; i--) {
			Login.lblCounter.setText(i + "s");
			Thread.sleep(1000);
		}
		Login.dialog.dispose();
	}
	
}
