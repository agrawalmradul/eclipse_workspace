package com.ctci.a_arrays;

/**
 * Write a method to replace all spaces in a string with '%20'. You may assume
 * that the string has sufficient space at the end to hold the additional
 * characters, and that you are given the "true" length of the string. (Note: If
 * implementing in Java, please use a character array so that you can perform
 * this operation in place.) EXAMPLE Input: "Mr John Smith ", 13 Output:
 * "Mr%20John%20Smith"
 */

public class C_URLify {

	public static void main(String[] args) {
		String in = "Mr John Smith    ";
		System.out.println(urlMe(in, 13));
	}

	public static String urlMe(String in, int len) {
		char[] arr = in.toCharArray();
		int i = len - 1, j = in.length() - 1;
		while (i >= 0) {
			if (arr[i] != ' ') {
				arr[j--] = arr[i--];
			} else {
				arr[j] = '0';
				arr[j - 1] = '2';
				arr[j - 2] = '%';
				i--;
				j -= 3;
			}
		}
		return String.valueOf(arr);
	}
}
