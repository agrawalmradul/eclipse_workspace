package com.ctci.h_recursionDP;

public class E_recursiveMultiply {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reMultiply(121, 99) + 121);
	}

	public static int reMultiply(int a, int b) {
		int smaller = a < b ? a : b;
		int larger = a < b ? b : a;
		int temp = 0;
		while (smaller != 1) {
			if (smaller % 2 != 0)
				temp += larger;
			larger <<= 1;
			smaller >>= 1;
		}
		return larger + temp;
	}
}
