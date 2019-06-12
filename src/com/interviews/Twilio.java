package com.interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Twilio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Integer[] input = { 3, 1, 2, 2, 4 };
		// customSort(Arrays.asList(input));

		// System.out.println(missingWords("I am using HackerRank to improve
		// programming", "am HackerRank to improve"));
		// System.out.println(fourthBit(32));

		myfunction(new int[] { 1, 2, 3, 4, 1 }, 3);
	}

	public static void customSort(List<Integer> arr) {
		Map<Integer, Integer> map = new TreeMap<>();

		for (Integer in : arr) {
			map.put(in, map.getOrDefault(in, 0) + 1);
		}

		List<NumFreq> list = new ArrayList<>();

		for (Integer key : map.keySet()) {
			list.add(new NumFreq(key, map.get(key)));
		}

		Comparator<NumFreq> oComp = Comparator.comparing((NumFreq e) -> e.n).thenComparing((NumFreq e) -> e.x);
		list.sort(oComp);

		for (NumFreq in : list) {
			System.out.println(in.x);
		}
	}

	static class NumFreq {
		int x;
		int n;

		public NumFreq(int x, int n) {
			this.x = x;
			this.n = n;
		}
	}

	public static List<String> missingWords(String s, String t) {
		String[] parts = s.split(" ");
		String[] otherparts = t.split(" ");

		List<String> missing = new ArrayList<>();
		for (int i = 0, j = 0; i < parts.length; i++) {
			if (j < otherparts.length && parts[i].equals(otherparts[j])) {
				j++;
			} else {
				missing.add(parts[i]);
			}
		}

		return missing;
	}

	public static int fourthBit(int num) {

		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			sb.append(num % 2);
			num = num / 2;
			System.out.println(sb);
		}

		return sb.charAt(3) == '0' ? 0 : 1;
	}

	public static void myfunction(int[] arr, int k) {

		int size = arr.length;
		// list is used to print the pairs
		Map<Integer, List<Integer>> hashMap = new HashMap<Integer, List<Integer>>();

		int currentSum = 0;
		for (int index = 0; index < size; index++) {
			currentSum += arr[index];
			List<Integer> list = hashMap.get(currentSum % k);
			if (null == list) {
				list = new ArrayList<Integer>();

			}
			list.add(index);
			hashMap.put(currentSum % k, list);
		}

		int noOfSubArray = 0;
		for (Map.Entry<Integer, List<Integer>> entry : hashMap.entrySet()) {
			Integer key = entry.getKey();
			Integer listSize = entry.getValue().size();
			if (key == 0) {
				noOfSubArray += (listSize * (listSize + 1)) / 2;
			} else {
				noOfSubArray += (listSize * (listSize - 1)) / 2;
			}
		}

		System.out.println("No of subArray in O(k+n) time complexity " + noOfSubArray);
	}
}
