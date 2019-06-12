package codepractice.dp;

public class PathsInGrid {

	public static void main(String[] args) {
		int r = 3;
		int c = 3;
		int[][] grid = new int[r][c];
		grid[1][0] = -1;
		System.out.println(findPaths(grid));
	}
	
	public static int findPaths(int[][] grid) {
		int rows = grid.length;
		int columns = grid[0].length;
		int[][] paths = new int[rows][columns];
		paths[0][0] = 1;
		for(int r = 0; r<rows; r++) {
			for(int c = 0; c<columns; c++) {
				if(grid[r][c] == -1)
					paths[r][c] = 0;
				else if (r>0 && c>0) {
					paths[r][c] = paths[r-1][c] + paths[r][c-1]; 
				}
				else if (r>0)
					paths[r][c] = paths[r-1][c];
				else if (c>0)
					paths[r][c] = paths[r][c-1];
			}
		}
		return paths[rows-1][columns-1];
	}
}
