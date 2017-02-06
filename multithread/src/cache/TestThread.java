package cache;

public class TestThread extends Thread {

	private int cachedVar = 1;
	
	public void run() {
		while(cachedVar == 1) {
			System.out.println("It is 1");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void setVar(int val) {
		this.cachedVar = val;
	}
}
