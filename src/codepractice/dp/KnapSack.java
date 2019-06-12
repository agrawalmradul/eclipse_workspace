package codepractice.dp;

public class KnapSack {

	public static void main(String[] args) {
		int[] weights = new int[] { 1, 3, 4, 5 };
		int[] value = new int[] { 1, 4, 5, 7 };
		int maxWeight = 7;
		// int[][] memo = new int[weights.length][maxWeight+1];

		 int result = knapsackRec(weights, value, maxWeight, weights.length-1);
//		System.out.println(knapsackDP(weights, value, maxWeight));

	}

	// recursion
	public static int knapsackRec(int[] weights, int[] values, int maxWeight, int i) {
		if (i == 0 || maxWeight == 0)
			return 0;
		else if (weights[i] > maxWeight)
			return knapsackRec(weights, values, maxWeight, i - 1);
		else {
			int temp1 = knapsackRec(weights, values, maxWeight, i - 1);
			int temp2 = values[i] + knapsackRec(weights, values, maxWeight - weights[i], i - 1);
			return Math.max(temp1, temp2);
		}
	}

	// bottomup
	public static int knapsackDP(int[] weights, int[] values, int maxWeight) {
		int[][] memo = new int[weights.length + 1][maxWeight + 1];

		for (int r = 0; r < memo.length; r++) {
			for (int c = 0; c < memo[0].length; c++) {
				if (r == 0 || c == 0) {
					memo[r][c] = 0;
				} else if (weights[r - 1] > c)
					memo[r][c] = memo[r - 1][c];
				else {
					memo[r][c] = Math.max(values[r - 1] + memo[r - 1][c - weights[r - 1]], memo[r - 1][c]);
				}
			}
		}
		return memo[weights.length][maxWeight];
	}
}
