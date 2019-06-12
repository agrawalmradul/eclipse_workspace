package codepractice.dp;

import java.util.Arrays;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String str1 = "x";
		String str2 = "asaf";
		
		// recursion
		//System.out.println(longestCS(str1, str2, str1.length(), str2.length()));
		
		//memoize
		int[][] memo = new int[str1.length()+1][str2.length()+1];
		for(int i =0; i<memo.length;i++)
			Arrays.fill(memo[i], -1);
		//System.out.println(longestCS_DP(str1, str2, str1.length(), str2.length(), memo));
		
		//bottomup
		System.out.println(longestCS_BU(str1, str2));
	}
	
	//recursion
	public static int longestCS(String str1, String str2, int p1, int p2) {
		if(p1 == 0 || p2 == 0)
			return 0;
		if(str1.charAt(p1-1)==str2.charAt(p2-1))
			return longestCS(str1,str2,p1-1,p2-1) + 1;
		else
			return Math.max(longestCS(str1,str2,p1,p2-1), longestCS(str1,str2,p1-1,p2));
	}

	//memoize
	public static int longestCS_DP(String str1, String str2, int p1, int p2, int[][] memo) {
		if(memo[p1][p2]!=-1)
			return memo[p1][p2];
		int result = 0;
		if(p1 == 0 || p2 == 0)
			result = 0;
		else if(str1.charAt(p1-1)==str2.charAt(p2-1))
			result = longestCS_DP(str1,str2,p1-1,p2-1, memo) + 1;
		else
			result = Math.max(longestCS_DP(str1,str2,p1,p2-1,memo), longestCS_DP(str1,str2,p1-1,p2,memo));
		memo[p1][p2] = result;
		return result;
	}
	
	//Bottom-up
	public static int longestCS_BU(String str1, String str2) {
		int[][] memo = new int[str1.length()+1][str2.length()+1];
		
		for(int r = 0; r<memo.length;r++) {
			for(int c = 0; c<memo[0].length; c++) {
				if(r==0 || c==0) 
					memo[r][c] = 0;
				else if(str1.charAt(r-1)==str2.charAt(c-1)) {
					memo[r][c] = memo[r-1][c-1] + 1;
				}
				else {
					memo[r][c] = Math.max(memo[r-1][c], memo[r][c-1]);
				}
			}
		}
		return memo[str1.length()][str2.length()];
	}
}
