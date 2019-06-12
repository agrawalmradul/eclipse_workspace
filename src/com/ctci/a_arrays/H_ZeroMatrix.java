package com.ctci.a_arrays;

/**
 * Zero Matrix: Write an algorithm such that if an element in an MxN matrix is
 * 0, its entire row and column are set to 0.
 */

public class H_ZeroMatrix {

	public static void main(String[] args) {
		int[][] input = { { 0, 2, 3, 10 }, { 4, 5, 0, 11 }, { 7, 8, 9, 12 }, { 13, 14, 15, 16 } };
		printMatrix(input);
		System.out.println("------");
		zeroIt(input);
		printMatrix(input);
	}

	public static int[][] zeroIt(int[][] in) {
		boolean[] rows = new boolean[in.length];
		boolean[] cols = new boolean[in[0].length];

		for (int row = 0; row < in.length; row++) {
			for (int col = 0; col < in[0].length; col++) {
				if (in[row][col] == 0) {
					rows[row] = true;
					cols[col] = true;
				}
			}
		}

		for (int i = 0; i < rows.length; i++) {
			if (rows[i])
				nullifyRow(in, i);
		}

		for (int j = 0; j < cols.length; j++) {
			if (cols[j])
				nullifyCol(in, j);
		}

		return in;
	}

	private static void nullifyRow(int[][] in, int row) {
		for (int i = 0; i < in[0].length; i++) {
			in[row][i] = 0;
		}
	}

	private static void nullifyCol(int[][] in, int col) {
		for (int i = 0; i < in.length; i++) {
			in[i][col] = 0;
		}
	}

	private static void printMatrix(int[][] in) {
		for (int row = 0; row < in.length; row++) {
			for (int col = 0; col < in[0].length; col++) {
				System.out.print(in[row][col] + " ");
			}
			System.out.println();
		}
	}
}
