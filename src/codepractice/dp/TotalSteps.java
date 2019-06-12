package codepractice.dp;

public class TotalSteps {

	public static void main(String[] args) {
		System.out.println(stairsRec(4));
		System.out.println(stairsDyn(4,new int[5]));
		System.out.println(stairsDyn(4,new int[5]));

	}

	//recursive solution
	public static int stairsRec(int n) {
		if(n==0) return 1;
		if(n<=2) return n;
		return stairsRec(n-1) + stairsRec(n-2) + stairsRec(n-3);
	}

	//dynamic programming - memoize
	public static int stairsDyn(int n, int[] arr) {

		if(n==0) return 1;
		if(n<=2)
			return n;
		if(arr[n]==0) 
			arr[n] = stairsDyn(n-1, arr) + stairsDyn(n-2, arr) + stairsDyn(n-3, arr);
		return arr[n];
	}

	//dynamic programming - bottom up
	public static int stairsBU(int n) {
		int[] arr = new int[n+1];
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 2;
		for(int i = 3; i<=n; i++) {
			arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
		}
		return arr[n];
	}
}
