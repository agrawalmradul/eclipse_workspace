package com.playground;

public class Singleton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EnumSingleton obj = EnumSingleton.Instance;
		obj.i = 5;
		obj.show();

		EnumSingleton obj2 = EnumSingleton.Instance;
		obj2.i = 6;
		obj.show();
	}

}

// Eager Implementation
// objES will always be there in memory
// it consumes resources
class EagerlySingleton {
	static EagerlySingleton objES = new EagerlySingleton();

	private EagerlySingleton() { }

	public static EagerlySingleton getInstance() {
		return objES;
	}
}

// Lazy Implementation
// If used multi-thread each thread will create different objects
class LazySingleton {
	static LazySingleton objLS;

	private LazySingleton() { }

	public static LazySingleton getInstance() {
		if (objLS == null) {
			objLS = new LazySingleton();
		}
		return objLS;
	}
}

// Thread safe Implementation
// it keep threads in waiting state making performance slow
class ThreadSafeSingleton {
	static ThreadSafeSingleton objTS;

	private ThreadSafeSingleton() { }

	public static synchronized ThreadSafeSingleton getInstance() {
		if (objTS == null) {
			objTS = new ThreadSafeSingleton();
		}
		return objTS;
	}
}

// Double checked locking
// improving performance
class ThreadLockSingleton {
	static ThreadLockSingleton objTS;

	private ThreadLockSingleton() { }

	public static ThreadLockSingleton getInstance() {
		if (objTS == null) {
			synchronized (ThreadLockSingleton.class) {
				if (objTS == null) {
					objTS = new ThreadLockSingleton();
				}
			}
		}
		return objTS;
	}
}

//Bill Pugh singleton
class BillPughSingleton {

    private BillPughSingleton(){}
    
    private static class SingletonHelper{ //this class will be called only when getInstance() method is called
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
    
    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}

// Using enum - special type of class
// java v1.5 and above
enum EnumSingleton {
	Instance;
	int i;

	public void show() {
		System.out.println("i: " + i);
	}
}
