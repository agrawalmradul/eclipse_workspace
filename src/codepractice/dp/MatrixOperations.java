package codepractice.dp;

public class MatrixOperations {

	public static void main(String[] args) {
		int[] arr = {2,3,6,4};
		int operations = getOptimalSol(arr);
		System.out.println(operations);
	}

	public static int getOptimalSol(int[] arr) {
		int[][] result = new int[arr.length][arr.length];
		int q = 0;
		for(int r = 2; r<arr.length; r++) {
			for(int c = 0; c<arr.length-r; c++) {
				int j = r+c;
				result[c][j] = Integer.MAX_VALUE;
				for(int k = c+1; k<j; k++) {
					q = result[c][k] + result[k][j] + arr[c]*arr[k]*arr[j];
					if(q<result[c][j])
						result[c][j] = q;
				}
			}
		}
		return result[0][arr.length-1];
	}
}