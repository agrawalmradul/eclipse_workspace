package codepractice.dp;

import java.util.HashMap;

public class NumberOfSetsAddsUp {

	public static void main(String[] args) {
		int[] arr = {2, 4, 6, 10};
		int total = 16;
		//System.out.println(countSets(arr,total,arr.length-1));
		
		HashMap<String, Integer> memo = new HashMap<>();
		System.out.println(countSets_DP(arr, total, arr.length-1, memo));
	}
	
	//recursion
	public static int countSets(int[] arr, int total, int i) {
		if(total==0)
			return 1;
		if(total<0 || i<0)
			return 0;
		else if(total<arr[i]) 
			return countSets(arr, total, i-1);
		else {
			return countSets(arr, total, i-1) + countSets(arr,total-arr[i], i-1);
		}
	}
	
	//dp
	public static int countSets_DP(int[] arr, int total, int i, HashMap<String, Integer> memo) {
		if(memo.containsKey(total+":"+i)) return memo.get(total+":"+i);
		int result = 0;
		if(total==0)
			result = 1;
		else if (total<0 || i<0)
			result = 0;
		else if(total<arr[i])
			result = countSets_DP(arr, total, i-1, memo);
		else
			result = countSets_DP(arr, total, i-1, memo) + countSets_DP(arr, total-arr[i], i-1, memo);
		memo.put(total+":"+i, result);
		return result;
	}

}
