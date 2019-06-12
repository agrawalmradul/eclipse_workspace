package com.ctci.h_recursionDP;

public class A_TripleStep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(stepUpDP(38, new int[39]));
	}

	public static int stepUp(int n) {
		if (n < 0)
			return 0;
		if (n == 0)
			return 1;

		return stepUp(n - 1) + stepUp(n - 2) + stepUp(n - 3);
	}

	public static int stepUpDP(int n, int[] mem) {
		if (n < 0)
			return 0;
		if (n == 0)
			return 1;
		else if (mem[n] == 0)
			mem[n] = stepUpDP(n - 1, mem) + stepUpDP(n - 2, mem) + stepUpDP(n - 3, mem);
		
		return mem[n];
	}

}
