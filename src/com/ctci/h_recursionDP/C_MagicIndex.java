package com.ctci.h_recursionDP;

public class C_MagicIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println(magicIndex(input, 0, input.length - 1));
	}

	public static int magicIndex(int[] in, int start, int end) {
		while (start <= end) {
			int mid = (start + end) / 2;
			if (in[mid] == mid)
				return mid;
			else if (in[mid] < mid)
				return magicIndex(in, mid + 1, end);
			else
				return magicIndex(in, start, mid - 1);
		}
		return -1;
	}
}
