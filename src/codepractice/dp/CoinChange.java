package codepractice.dp;

import java.util.Arrays;

//given an array of denomination of coins D = [1,9,13] and a total T
//find the minimum # coins to reach T
public class CoinChange {

	public static void main(String[] args) {
		int[] deno = new int[] { 1, 2, 5 };
		System.out.println(minCoins(deno, 7));
	}

	public static int minCoins(int[] deno, int total) {
		int[] memo = new int[total + 1];
		memo[0] = 0;
		for (int i = 1; i <= total; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < deno.length; j++) {
				if (deno[j] <= i)
					min = Math.min(min, memo[i - deno[j]]);
				System.out.println(Arrays.toString(memo));
			}
			memo[i] = (min == Integer.MAX_VALUE) ? Integer.MAX_VALUE : min + 1;
		}
		return memo[memo.length - 1];
	}
}
