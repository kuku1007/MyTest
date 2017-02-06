package cache;

public class MemTest {
	public static void main(String[] args) {
		Thread t = new TestThread();
		System.out.println("Started");
		t.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		((TestThread)t).setVar(2);
	}
}
