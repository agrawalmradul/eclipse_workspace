package com.ctci.a_arrays;

import java.util.HashSet;

/**
 * A palindrome is a word or phrase that is the same forwards and backwards. A
 * permutation is a rearrangement of letters. The palindrome does not need to be
 * limited to just dictionary words. EXAMPLE Input: Tact Coa Output: True
 * (permutations: "taco cat", "atco eta", etc.)
 */

public class D_PermuntationPalindrome {

	public static void main(String[] args) {
		// System.out.println(isPermuPalin("ab b"));
		System.out.println(isPermuPalin2("aasaf as"));
	}

	public static boolean isPermuPalin(String in) {
		int[] table = mapChars(in);
		boolean foundOdd = false;
		for (int temp : table) {
			if (temp % 2 == 1) {
				if (foundOdd)
					return false;
				foundOdd = true;
			}
		}
		return true;
	}

	private static int getCharNumber(Character c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if (a <= val && val <= z) {
			return val - a;
		}
		return -1;
	}

	private static int[] mapChars(String s) {
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for (char c : s.toCharArray()) {
			int t = getCharNumber(c);
			if (t != -1) {
				table[t]++;
			}
		}
		return table;
	}

	public static boolean isPermuPalin2(String in) {
		HashSet<Character> hs = new HashSet<>();
		int count = 0;
		for (Character ch : in.toCharArray()) {
			if (hs.contains(ch))
				hs.remove(ch);
			else if ('a' <= (int) ch && 'z' >= (int) ch)
				hs.add(ch);
			else
				count--;
			count++;
		}
		return (count % 2 == 0) ? hs.size() == 0 : hs.size() == 1;
	}
}
