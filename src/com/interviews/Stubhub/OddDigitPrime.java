package com.interviews.Stubhub;

public class OddDigitPrime {
	/*
	 * Complete the 'oddDigitPrime' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER l 2. INTEGER r 3. INTEGER t
	 */

	public static void main(String[] args) {
		OddDigitPrime obj = new OddDigitPrime();
		System.out.println(obj.oddDigitPrime(31, 45, 2));
		System.out.println(obj.isPrime(35));
	}

	public int oddDigitPrime(int l, int r, int t) {
		int count = 0;
		l = l % 2 == 0 ? l++ : l;
		for (int i = l; i <= r; i = i+2) {
			if (isPrime(i) && inCategory(i, t)) {
				count++;
				System.out.println(i);
			}
		}
		return count;
	}

	private Boolean isPrime(int num) {
		if (num == 1 || num % 2 == 0)
			return false;
		else if (num == 2 || num == 3)
			return true;
		else if (num % 2 == 0)
			return false;
		else if (num * (num - 1) % 24 == 0)
			return true;
		return false;
	}

	private boolean inCategory(int num, int t) {
		return t == 1 ? inFirstCategory(num) : inSecondCategory(num);
	}

	private static boolean inFirstCategory(int num) {
		while (num > 0) {
			if (num % 10 > 5 || num % 2 == 0) {
				return false;
			}
			num = num / 10;
		}
		return true;
	}

	private boolean inSecondCategory(int num) {
		while (num > 0) {
			if (num % 10 < 5 || num % 2 == 0) {
				return false;
			}
			num = num / 10;
		}
		return true;
	}
}
