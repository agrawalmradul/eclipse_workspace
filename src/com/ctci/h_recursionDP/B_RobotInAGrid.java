package com.ctci.h_recursionDP;

public class B_RobotInAGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = new int[][] { { 0, 0, 0, 0 }, { 0, -1, -1, -1 }, { 0, 0, 0, 0 }, { -1, 0, -1, 0 } };
		findPath(grid, 3, 3);
	}

	public static boolean findPath(int[][] grid, int r, int c) {
		if (r < 0 || c < 0 || grid[r][c] == -1)
			return false;
		boolean isOrigin = (r == 0 && c == 0);
		if (isOrigin || findPath(grid, r - 1, c) || findPath(grid, r, c-1)) {
			System.out.println(r + " " + c);
			return true;
		}
		return false;
	}
}
