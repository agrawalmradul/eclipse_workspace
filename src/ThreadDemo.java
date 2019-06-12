
public class ThreadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ThreadInterface ti = new ThreadInterface();
//		Thread t1 = new Thread(ti);
//		t1.start();
		Thread.currentThread().setPriority(1);

		System.out.println(Thread.currentThread().getPriority());
		ThreadClass t2 = new ThreadClass();
		
		t2.setPriority(10);
//		Thread.currentThread().setPriority(1);
//		System.out.println(t2.getPriority());
		t2.start();
		
		System.out.println("main thread");
//		new MyThread("One");
//		new MyThread("Two");
//		new MyThread("Three");
//		try {
//			Thread. (1000);
//		} catch (InterruptedException e) {
//			System.out.println("Main thread Interrupted");
//		}
//		System.out.println("Main thread exiting.");
	}

}

class ThreadInterface implements Runnable {

	@Override
	public void run() {
		System.out.println("ThreadInterface Running");
	}

}

class ThreadClass extends Thread {
	
	@Override
	public void run() {
		System.out.println("ThreadClass Running");
	}
}

//class MyThread implements Runnable {
//	String name;
//	Thread t;
//
//	MyThread(String thread) {
//		name = thread;
//		t = new Thread(this, name);
//		System.out.println("New thread: " + t);
//		t.start();
//	}
//
//	public void run() {
//		try {
//			for (int i = 5; i > 0; i--) {
//				System.out.println(name + ": " + i);
//				Thread.sleep(1000);
//			}
//		} catch (InterruptedException e) {
//			System.out.println(name + "Interrupted");
//		}
//		System.out.println(name + " exiting.");
//	}
//}