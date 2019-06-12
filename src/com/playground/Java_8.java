package com.playground;

public class Java_8 {

	public static void main(String[] args) {
		Emp e = new Emp(1, 2, "me");
		e.show();
		e.show();

		Emp e2 = new Emp(3, 4, "you");
		e.show();
		e2.show();
		e = null;
		System.gc();
	}

}

class Emp {

	int id;
	int name = 4;
	static String ceo;

	public Emp(int a, int b, String ceo) {
		this.id = a;
		this.name = b;
		Emp.ceo = ceo;
	}

	public final void show() {
		System.out.println(id + "" + name + ceo);
	}
	
	public void finalize() {
		System.out.println("inside finalize");
	}
}