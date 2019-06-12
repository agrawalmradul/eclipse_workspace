package com.ctci.a_arrays;

/**
 * One Away: There are three types of edits that can be performed on strings:
 * insert a character, remove a character, or replace a character. Given two
 * strings, write a function to check if they are one edit (or zero edits) away.
 * EXAMPLE pale, ple -> true pales, pale -> true pale, bale -> true pale, bake
 * -> false
 * @author mradulagrawal
 */

public class E_OneAway {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(oneEditAway("aad", "aad"));
	}

	private static boolean oneEditAway(String s1, String s2) {
		int s1Len = s1.length();
		int s2Len = s2.length();

		if (s1Len == s2Len + 1)
			return insDelOne(s1, s2);
		else if (s1Len + 1 == s2Len)
			return insDelOne(s2, s1);
		else if (s1Len == s2Len)
			return replacement(s1, s2);

		return false;
	}

	private static boolean replacement(String s1, String s2) {
		boolean foundOne = false;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (foundOne)
					return false;
				foundOne = true;
			}
		}
		return foundOne;
	}

	private static boolean insDelOne(String s1, String s2) {
		boolean foundOne = false;
		int i = 0;
		int j = 0;
		while (i < s1.length()) {
			if (s1.charAt(i) != s2.charAt(j)) {
				if (foundOne)
					return false;
				i++;
				foundOne = true;
			} else {
				i++;
				j++;
			}
		}
		return true;
	}
}
