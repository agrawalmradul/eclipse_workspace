

import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class LeetCodes {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(isValid("(){}[]"));
		//int robber = rob(new int[] {2,7,9,3,1,5});
		//int[] abcd = twoSum(new int[] {2,7,11,13},9);
		//		int a = binarySearch(new int[] {2},2);
		//		System.out.println(a);
		//		
		//		System.out.println(countWays(3));
		//		maxProfit(new int[] {7,1,5,3,4,6});
		//		majorityElement(new int[] {3,2,3,1,2,2,3,3,3});
		//		hammingWeight(2147483647);
		//		rotate(new int[] {1,2,3},2);
		//		
		//		multWOprod(32, 35);
		//System.out.println(remDup(new int[] {1,1,2,2,3,4}));
		//System.out.println(findLoc(new int[] {1,3,5,7},0));
		//System.out.println(Integer.bitCount(31));
		//findMedianSortedArrays(new int[] {1,2,3,6,9,10}, new int[] {0,2,4,5,8,11,13});
		//myPow(2.0,10);
		//	System.out.println(oneDist("hello", "belli"));
		//candy(new int[] {1,3,5,2,6,4,8});
		//System.out.println(countLess(new int[] {1,2,2,3},3));
		//System.out.println(intersectionArray(new int[] {1,3,4,10,11}, new int[] {1,2,4,5,9,10,11}));
		//        int[][] bombs1 = {{0, 2}, {2, 0}};
		//        mineSweeper(bombs1, 3, 3);
		//System.out.println(getDay("01","02","1992"));
		//System.out.println(getDup(new int[] {1, 3, 4, 1, 2, 6, 5, 9, 8, 5}));
//		ArrayList<Integer> test = new ArrayList<>();
//		test.add(1);
//		test.add(2);
//		test.add(3);
//		test.add(3);
//		System.out.println(balancedSums(test));
		long[] a = new long[] {3, 3, 9, 9, 5};
		System.out.println(maximumSum(a,7));
		//countBits(16);
	}
	
	
	public static void countBits(int num) {
        int[] result = new int[num+1];
        result[0] = 0;
        result[1] = 1;
        for(int i = 2;i<=num;i++) {
            int val = i&(i-1);
            if(val==0)
            	result[i] = 1;
            else {
            	result[i] = result[val] + result[i-val]; 
            }
        }
        
        System.out.println(Arrays.toString(result));
        System.out.println(num + ": " + Integer.toString(num&(num-1)));
    }
	
	public static void shortString() {
		String input = "aabcccccaaa";
		StringBuilder sb = new StringBuilder();
		sb.append(input.charAt(0));
		int count = 1;
		for(int i = 1; i<input.length();i++) {
			
			if(input.charAt(i)==input.charAt(i-1)) {
				count++;
			}
			else {
				sb.append(count);
				sb.append(input.charAt(i));
				count = 1;
			}
		}
		sb.append(count);
		System.out.println(sb);
	}
	
	
	static long maximumSum(long[] a, long m) {
        int len = a.length;
        long[][] buffer = new long[len][len];
        long maxresult = Long.MIN_VALUE;

        for(int i = 0; i<len; i++) {
        	buffer[i][i] = a[i]%m;
        }
        
        for(int r = 0; r<len; r++){
            for(int c = r+1; c<len; c++){
                buffer[r][c] = (buffer[r][c-1] + buffer[c][c])%m;
                maxresult = Math.max(maxresult,buffer[r][c]);
            }
        }
        return maxresult;
    }
	
	 static String balancedSums(List<Integer> arr) {
	        int[] cumSum = new int[arr.size()];
	        int len = cumSum.length;
	        for(int i = 0; i<len;i++)
	            cumSum[i] = i==0? arr.get(0) : cumSum[i-1]+arr.get(i);
	        
	        int totalSum = cumSum[len-1];
	        for(int j = 0; j < len-1; j++){
	             if(j==0) {
	            	 if ((totalSum-arr.get(0))==0)
	                 	return "YES";
	             }
	             else if(cumSum[j-1] == (totalSum-arr.get(j))/2)
	                return "YES";
	        }
	        return "NO";
	    }
	
	public static List<Integer> getDup(int[] arr) {
		//if length is less than 4, can't have dups with distance 3
		if(arr.length<4) return null;
		// initializing result
		List<Integer> result = new ArrayList<>();
		//a queue of size 3 to maintain 
		Queue<Integer> temp = new ArrayDeque<Integer>(3);
		//adding first three elements to queue
		for(int i = 0; i<=2; i++) {
			temp.add(arr[i]);
		}
		//starting from 4th element in the array
		//and popping from the queue
		// if they are same, add to result
		for(int i = 3; i<arr.length; i++) {
			if(temp.remove()==arr[i])
				if(!result.contains(arr[i])) result.add(arr[i]);
			temp.add(arr[i]);
		}
		return result;
	}
	
	public static String getDay(String day, String month, String year){
        LocalDate dt = LocalDate.of(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day));
        System.out.print(dt.getDayOfWeek());
	    return "hello";
    }
	
	static <K,V extends Comparable<? super V>> SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
	    SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
	        new Comparator<Map.Entry<K,V>>() {
	            @Override
	            public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
	                int res = e1.getValue().compareTo(e2.getValue());
	                //System.out.println(res);
	                return res != 0 ? res : 1;
	            }
	        }
	    );
	    sortedEntries.addAll(map.entrySet());
	    return sortedEntries;
	}

	class ValueComparator implements Comparator<String>{
		 
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
	 
		public ValueComparator(TreeMap<String, Integer> map2){
			this.map.putAll(map2);
		}
	 
		@Override
		public int compare(String s1, String s2) {
			if(map.get(s1) >= map.get(s2)){
				return -1;
			}else{
				return 1;
			}	
		}
	}



	public static List<Integer> intersectionArray(int[] arr1, int[] arr2) {
		int i = 0, j= 0;
		List<Integer> result = new ArrayList<Integer>();
		while(i<arr1.length && j<arr2.length) {
			if(arr1[i] == arr2[j]) {
				result.add(arr1[i]);
				i++;
				j++;
			} else if(arr1[i]>arr2[j])
				j++;
			else
				i++;
		}
		return result;
	}

	public static int countLess(int[] arr, int key) {
		int start = 0;
		int end = arr.length-1;
		int mid = 0;
		while(start <= end) {
			mid = (start+end)/2;
			if(arr[mid]>=key)
				end = mid -1;
			else 
				start = mid + 1;
		}
		return start;
	}


	public static int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0) {
			return 0;
		}
		int[] candies = new int[ratings.length];
		candies[0] = 1;
		//from let to right
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candies[i] = candies[i - 1] + 1;
			} else {
				// if not ascending, assign 1
				candies[i] = 1;
			}
		}
		int result = candies[ratings.length - 1];

		//from right to left
		for (int i = ratings.length - 2; i >= 0; i--) {
			int cur = 1;
			if (ratings[i] > ratings[i + 1]) {
				cur = candies[i + 1] + 1;
			}
			result += Math.max(cur, candies[i]);
			candies[i] = cur;
		}
		return result;
	}


	public int binarySearch2(int[] arr, int key) {

		int start = 0;
		int end = arr.length -1;
		int mid;
		while(start<=end) {
			mid = (start+end)/2;
			if(arr[mid] == key)
				return mid;
			else if(arr[mid]<key)
				start = mid+1;
			else
				end = mid -1;
		}
		return -1;
	}
	public static boolean oneDist(String strA, String strB) {

		int i = 0, j = 0;
		boolean exist = false;

		if(strA.length() != strB.length()) return false;
		while(i<strA.length() && j<strB.length()) {
			if(strA.charAt(i) != strB.charAt(j)) {
				if(exist) return false;
				exist = true;
			}
			i++;
			j++;
		}
		return exist;
	}

	//x^n x to the power of n
	public static double myPow(double x, int n) {
		boolean flag = n>0 ? false: true;

		if (flag) n *= -1;
		double result = 1;

		if(n==0) return 1;
		if(n==1) return x;

		int k = 2;
		result = x*x;

		while(k*2<n){
			result =result * result;
			k *= 2;
		}

		while(k!=n) {
			result *= x;
			k++;
		}

		if(flag)
			return (1/result);
		else 
			return result;
	}

	public static int findLoc(int[] arr, int key) {
		int len = arr.length;
		int start = 0;
		int end = len-1;
		while(start<=end) {
			int mid = (start+end)/2;

			if(arr[mid] == key)
				return mid;
			if(arr[mid]<key) {
				start = mid+1;
			}
			else {
				end = mid -1;
			}
		}
		return start;
	}

	public static int remDup(int[] arr) {
		//int newL = arr.length;
		int j = 0;
		for(int i = 1; i<arr.length;i++) {
			if(arr[i]==arr[i-1])
				continue;
			else {
				if(j!=i) {
					j++;
					arr[j] = arr[i];
					//j++;
				}
			}
		}
		return j+1;

	}

	public static int multWOprod(int small, int big) {
		if(small==0) return 0;
		else if(small ==1) return big;

		int s = small>>1;
		int prod = multWOprod(s, big);

		if(small%2 == 0)
			return prod + prod;
		else
			return prod + prod + big;
	}

	public static void rotate(int[] nums, int k) {
		int len = nums.length;
		int shift =0;
		if(k==len) return;
		else if(k>len)
			k -= len;
		else{
			while (shift<k){
				int temp = nums[len-1];
				for(int i = len-1; i>=1; i--){
					nums[i] = nums[i-1];
				}
				nums[0] = temp;
				shift++;
			}
		}

	}

	public static int hammingWeight(int n) {
		int count = 0;
		while(n!=0){
			count+=(n&1);
			n = n>>>1;
		}    
		return count;
	}

	public static int majorityElement(int[] num) {

		int major=num[0], count = 1;
		for(int i=1; i<num.length;i++){
			if(count==0){
				count++;
				major=num[i];
			}else if(major==num[i]){
				count++;
			}else count--;

		}
		return major;
	}

	public static int maxProfit(int[] prices) {
		int max = 0;

		for(int i =0; i<prices.length-1;i++){
			if(prices[i+1]>prices[i])
				max += prices[i+1]-prices[i];
		}
		return max;
	}



	public static void removePunc() {
		String abc = "How's your Day.";
		abc = abc.replaceAll("[^a-zA-Z]", " ").toLowerCase();
		System.out.println(abc);
		String[] newA = abc.split("\\s+");
		for(String bca:newA)
			System.out.println(bca);

		Map<String, Integer> wordOccurrences = new HashMap<String, Integer>();
		// for every word in file
		for (String word : abc.split("\\s+")) {
			if (wordOccurrences.containsKey(word)) {
				int count = wordOccurrences.get(word).intValue();
				wordOccurrences.put(word, count + 1);
			} else {
				wordOccurrences.put(word, 1);
			}
		}

		System.out.println(wordOccurrences);
	}


	public static boolean isValid(String s) {
		Stack<Integer> objStack = new Stack<Integer>();
		if (s.equals("")) return false;
		if ((s.charAt(0) == ']') || (s.charAt(0) == '}') || (s.charAt(0) == ')')){
			return false;
		}
		for(int i = 0; i<s.length(); i++){
			char tempCh = s.charAt(i);
			if((tempCh == '[') || (tempCh == '{') || (tempCh == '(')){
				objStack.push((int)tempCh);
			} else if ((tempCh == ']') || (tempCh == '}') || (tempCh == ')')){
				int temp2 = objStack.pop();
				System.out.println(temp2);
				if(((int)temp2 == (int)tempCh-1) || ((int)temp2 == (int)tempCh-2)) continue;
				else return false;
			}
		}
		return (objStack.isEmpty());
	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int i;
		for(i = 0; i< nums.length; i++){
			if(map.containsKey(nums[i])){
				continue;
			} else if(map.containsKey(target - nums[i])){
				return new int[]{map.get(target - nums[i]),i+1};
			} else {
				map.put(nums[i], i+1);
			}
		}
		return new int[]{0,0};
	}


	public static int rob(int[] num) {
		int[][] dp = new int[num.length + 1][2];
		for (int i = 1; i <= num.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
			dp[i][1] = num[i - 1] + dp[i - 1][0];
		}
		return Math.max(dp[num.length][0], dp[num.length][1]);
	}

	public static int binarySearch(int[] arr, int find) {
		int start = 0;
		int end = arr.length-1;
		int mid;

		while (start<=end) {
			mid = (end+start)/2;
			if(find == arr[mid]) {
				return mid;
			}
			else if(find>arr[mid]) {
				start = mid+1;
			} else {
				end = mid -1;
			}
		}
		return -1;
	}

	public static long dpFib(int n) {
		return fi(n, new long[(n+1)]);
	}

	public static long fi(int i, long[] memo) {
		if(i == 0 || i==1) return i;

		if(memo[i]==0) {
			memo[i] = fi(i-1, memo);
			memo[i]+= fi(i-2, memo);
		}
		return memo[i];

	}

	public static int countWays(int n) {
		if(n<0) return 0;
		else if (n==0) return 1;
		else {
			return countWays(n-1)+countWays(n-2)+countWays(n-3);
		}
	}

}
