package utils;

public class Timer extends Thread {
	
	public void startCounter() throws InterruptedException {
		for (int i = 10; i >= 0; i--) {
//			Login.timer.setText(i + "s");
			Thread.sleep(1000);
		}
		
//		login.dispose();
	}
	
}
