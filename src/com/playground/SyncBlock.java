package com.playground;

public class SyncBlock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Display2 d = new Display2();
		Display2 d2 = new Display2();
		Mythread2 t1 = new Mythread2(d, "Dhoni");
		Mythread2 t2 = new Mythread2(d2, "Yuvraj");
		t1.start();
		t2.start();
	}

}

class Display2 {

	public void wish(String name) {
		// ------- other lines of code
		// synchronized (this) {
		synchronized (Display2.class) { //class level lock 
			for (int i = 0; i < 5; i++) {
				System.out.print("Good morning: ");
				try {
					Thread.sleep(1000);    
				} catch (InterruptedException e) {
				}
				System.out.println(name);
			}
		}
		// ------- other lines of code
	}
}

class Mythread2 extends Thread {
	Display2 d;
	String name;

	Mythread2(Display2 d, String name) {
		this.d = d;
		this.name = name;
	}

	public void run() {
		d.wish(name);
	}
}