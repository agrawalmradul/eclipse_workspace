package com.interviews;

public class UberInterview {

	// nxn grid 0 - dead cell, 1 - live cell
	// Game of Life:

	// =============
	//	     |   |
	// =============
	//	     |   |        =>   ???
	// =============
	//	     |   |
	// =============
	// Live cell: 1
	// dead cell: 0

	// Any live cell with fewer than two live neighbours dies, as if by underpopulation.
	// Any live cell with two or three live neighbours lives on to the next generation.
	// Any live cell with more than three live neighbours dies, as if by overpopulation.

	// Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

	public static void main(String args[] ) throws Exception {

		int[][] initialGrid = {{1,0,1},{1,1,1},{0,0,0}};

		printGrid(initialGrid);

		int size = initialGrid.length;

		int[][] nextGrid = new int[size][size];

		for(int row = 0; row < size; row++){
			for(int col = 0; col < size; col++){

				int count = liveNeighbors(initialGrid, row, col);
				if(initialGrid[row][col] == 1) {
					if(count<2){
						nextGrid[row][col] = 0;
					}
					else if (count == 2 || count == 3){
						nextGrid[row][col] = 1;
					}
					else if (count > 3){
						nextGrid[row][col] = 0;
					}
				}
				else {
					if(count == 3){
						nextGrid[row][col] = 1;
					}
				}
			}
		}
		System.out.println("-------");
		printGrid(nextGrid);
	}

	private static void printGrid(int[][] grid){
		for(int row = 0; row<grid.length; row++){
			for(int col = 0; col<grid[0].length; col++){
				System.out.print(grid[row][col] + " ");
			}
			System.out.println();
		}
	}

	private static int liveNeighbors(int[][] grid, int row, int col){
		int count;

		count = isAlive(grid, row-1, col-1) + isAlive(grid, row-1, col) + isAlive(grid, row-1, col+1)
		+ isAlive(grid, row, col-1) + isAlive(grid, row, col+1)
		+ isAlive(grid, row+1, col-1) + isAlive(grid, row+1, col) + isAlive(grid, row+1, col+1);

		System.out.println("row: " + row + ",col: " + col + ",count: " + count);

		return count;
	}

	private static int isAlive(int[][] grid, int row, int col){
		if(row<0 || col<0 || row>= grid.length || col>=grid[0].length)
			return 0;

		return grid[row][col];
	}
}
