package com.nauka.design;

public class ProdCons {
	
	private static int message;
	private static Queue queue;
	public static void main(String args[]) throws InterruptedException {
		queue = new Queue();
		Producer p = new Producer();
		Consumer c = new Consumer();
		
		Thread t1 = new Thread(c);
		
		Thread t2 = new Thread(p);
		t2.start();
		t1.start();
		
		
		t1.join();
	
		
	}
	
	
	static class Queue {
		private static int q;
		synchronized void addMessage() {

			while (q != 0) {
				System.out.println("Q is full");
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.println("Inserting message: " + ++message);
			q = message;
			notify();
		}
		
		synchronized void getMessage() {

			while (q == 0) {
				System.out.println("Q is empty");
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.println("Getting message: " + q);
			q = 0;
			notify();
		}
	}

	static class Producer implements Runnable{

		void addMessage() {

			queue.addMessage();
		}

		public void run() {
			while(true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				addMessage();
			}
						
		}
	}

	static class Consumer implements Runnable {
		
		
		public void run() {
			while(true) {
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				getMessage();
			}
						
		}
		
		void getMessage() {

			queue.getMessage();
		}
	}

}
