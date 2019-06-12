package com.ctci.a_arrays;

/**
 * Rotate Matrix: Given an image represented by an NxN matrix, where each pixel
 * in the image is 4 bytes, write a method to rotate the image by 90 degrees.
 * Can you do this in place?
 */

public class G_RotateMatrix {

	public static void main(String[] args) {
		int[][] input = { { 1, 2, 3, 10 }, { 4, 5, 6, 11 }, { 7, 8, 9, 12 }, { 13, 14, 15, 16 } };
		printMatrix(input);
		rotMatrix(input);
		System.out.println("-----");
		printMatrix(input);
	}

	public static int[][] rotMatrix(int[][] in) {
		if (in.length == 0 || in.length != in[0].length)
			return in;

		int n = in.length;
		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; i++) {
				int offset = i - first;
				int top = in[first][i];
				in[first][i] = in[last - offset][first];
				in[last - offset][first] = in[last][last - offset];
				in[last][last - offset] = in[i][last];
				in[i][last] = top;
			}
		}
		return in;
	}

	public static void printMatrix(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
