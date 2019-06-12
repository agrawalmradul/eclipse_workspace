package codepractice.dp;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(fibRec(5));
		int n = 5;
		int[] arr = new int[n+1];
		System.out.println(fibDyn(n,arr));
		System.out.println(fibBU(n));

	}
	
	//recursive solution
	public static int fibRec(int n) {
		if(n<=2) return 1;
		return fibRec(n-1) + fibRec(n-2);
	}
	
	//dynamic programming - memoize
	public static int fibDyn(int n, int[] arr) {
		if(arr[n]!=0) return arr[n];
		int result;
		if(n<=2)
			result = 1;
		else
			result = fibDyn(n-1, arr) + fibDyn(n-2, arr);
		arr[n] = result;
		return result;
	}

	//dynamic programming - bottom up
	public static int fibBU(int n) {
		int[] arr = new int[n+1];
		for(int i = 1; i<=n; i++) {
			if(i<=2)
				arr[i] = 1;
			else
				arr[i] = arr[i-1] + arr[i-2];
		}
		return arr[n];
	}
}
