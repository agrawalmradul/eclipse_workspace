package com.playground;

public class SychPlay {

	public static void main(String[] args) {
		Display d = new Display();
		Display d2 = new Display();
		Mythread t1 = new Mythread(d, "Dhoni");
//		Mythread t2 = new Mythread(d, "Dhoni");
		Mythread t2 = new Mythread(d, "Yuvraj");
		t1.start();
		t2.start();
	}

}

class Display {
	
//	public void wish(String name) {
//	public synchronized void wish(String name) { //regular output for same objects and different threads - object level lock
	public synchronized void wish(String name) {//regular output for different objects and different threads - class level lock
		for (int i = 0; i < 5; i++) {
			System.out.print("Good morning: ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			System.out.println(name);
		}
	}
}

class Mythread extends Thread {
	Display d;
	String name;

	Mythread(Display d, String name) {
		this.d = d;
		this.name = name;
	}

	public void run() {
		d.wish(name);
	}
}