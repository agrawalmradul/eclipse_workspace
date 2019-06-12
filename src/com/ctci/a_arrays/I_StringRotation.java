package com.ctci.a_arrays;

/**
 * String Rotation:Assume you have a method isSubstring which checks if one word
 * is a substring of another. Given two strings, sl and s2, write code to check
 * if s2 is a rotation of sl using only one call to isSubstring (e.g.,
 * "waterbottle" is a rotation of"erbottlewat").
 */

public class I_StringRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "coolwa";
		String s2 = "olwaco";
		System.out.println(isStringRotation(s1, s2));
	}

	public static boolean isStringRotation(String s1, String s2) {
		if (s1.length() != s2.length() || s1.length() == 0)
			return false;

		return (s2 + s2).indexOf(s1) != -1;
	}
}
