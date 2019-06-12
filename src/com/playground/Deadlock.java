package com.playground;

public class Deadlock extends Thread {

	A a = new A();
	B b = new B();

	public static void main(String[] args) {
		Deadlock d = new Deadlock();
		d.method1();
	}

	public void method1() {
		this.start();
		a.d1(b);
	}

	public void run() {
		b.d2(a);
	}

}

class A {
	public synchronized void d1(B b) {
		System.out.println("Thread1 starts execution of d1 method");
		try {
			Thread.sleep(5000); // if we remove sleep there is no guarantee for dead lock
		} catch (InterruptedException e) {
		}
		System.out.println("Thread1 trying to call B's last() method");
		b.last();
	}

	public synchronized void last() {
		System.out.println("inside A's last method");
	}
}

class B {
	public synchronized void d2(A a) {
		System.out.println("Thread2 starts execution of d2 method");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println("Thread2 trying to call A's last() method");
		a.last();
	}

	public synchronized void last() {
		System.out.println("inside B's last method");
	}
}