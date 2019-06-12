package com.ctci.a_arrays;

//Given two strings, write a method to decide if one is a permutation of the other.

public class B_CheckPermunation {

	public static void main(String[] args) {
		String s1 = "arer";
		String s2 = "rbra";
		System.out.println(checkAnagram(s1, s2));
	}

	public static boolean checkAnagram(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		} else {
			int[] arr = new int[26];
			for (int i = 0; i < s1.length(); i++) {
				arr[s1.charAt(i) - 'a']++;
				arr[s2.charAt(i) - 'a']--;
			}

			for (int i : arr)
				if (i != 0)
					return false;
		}
		return true;
	}
}
