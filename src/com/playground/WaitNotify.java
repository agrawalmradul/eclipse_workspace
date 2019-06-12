  package com.playground;

public class WaitNotify {

	public static void main(String[] args) throws InterruptedException {
		ThreadB b = new ThreadB();
		b.start();
		Thread.yield();
		synchronized(b){
			System.out.println("calling wait()...");
			b.wait();
			System.out.println("got notification.");
			System.out.println(b.total);
		}
	}

}

class ThreadB extends Thread{
	int total = 0;
	
	public void run() {
		synchronized(this) {
			System.out.println("calculating...");
			for(int i = 0; i<= 100; i++) {
				total += i;
			}
			System.out.println("notifying...");
			this.notify();
		}
	}
}
