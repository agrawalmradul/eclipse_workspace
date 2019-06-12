package com.ctci.a_arrays;

/**
 * String Compression: Implement a method to perform basic string compression
 * using the counts of repeated characters. For example, the string aabcccccaaa
 * would become a2blc5a3. If the "compressed" string would not become smaller
 * than the original string, your method should return the original string. You
 * can assume the string has only uppercase and lowercase letters (a - z).
 */

public class F_StringCompression {

	public static void main(String[] args) {
		String in = "azabbbcccddw";
		System.out.println(compressMe(in));
	}

	public static String compressMe(String in) {
		StringBuilder sb = new StringBuilder();
		sb.append(in.charAt(0));
		int count = 1;
		for (int i = 1; i < in.length(); i++) {
			if (in.charAt(i) == in.charAt(i - 1))
				count++;
			else {
				sb.append(count);
				sb.append(in.charAt(i));
				count = 1;
			}
		}
		sb.append(count);
		return sb.toString();
	}

}
