package com.interviews.Stubhub;

import java.util.Arrays;

public class RemoveDups {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 4, 5 };
		remDups(a);

		System.out.println(Arrays.toString(a));
	}

	public static void remDups(int[] arr) {
		int j = 1;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[i - 1]) {
				arr[j++] = arr[i];
			}
		}
	}
}
