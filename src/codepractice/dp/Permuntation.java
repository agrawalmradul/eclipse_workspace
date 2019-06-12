package codepractice.dp;

import java.util.Arrays;

public class Permuntation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] arr = new char[] {'a','b','c'};
		permutations(arr, 0);
	}

	public static void permutations(char[] arr, int start) {
		if(start == arr.length-1) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		for(int i = start; i<arr.length; i++) {
			swap(arr, start, i);
			permutations(arr, start+1);
			swap(arr, start, i);
		}
	}

	public static void swap(char[] arr, int i, int j) {
		char t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

}
