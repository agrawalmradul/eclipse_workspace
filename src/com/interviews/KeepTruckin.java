package com.interviews;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class KeepTruckin {

	public static void main(String[] args) {
		// job offers
		int[] scores = { 1, 2, 3, 4, 5 };
		int[] lowerLimit = { 2, 3 };
		int[] upperLimit = { 5, 4 };
		System.out.println(Arrays.toString(jobOffers(scores, lowerLimit, upperLimit)));

		// uniquePairs
		Integer[] li = { 1, 2, 3, 6, 7, 8, 9, 1 };
		List<Integer> arr = Arrays.asList(li);
		Long k = (long) 10;
		System.out.println(uniquePairs(arr, k));

		// psuedo code
		int a = 2437;
		int b = 875;
		System.out.println(pseudoCode(a, b));

	}

	private static int[] jobOffers(int[] scores, int[] lowerLimits, int[] upperLimits) {
		int[] jobOfferCount = new int[lowerLimits.length];

		for (int q = 0; q < lowerLimits.length; q++) {
			int loLimit = lowerLimits[q];
			int upLimit = upperLimits[q];
			int count = 0;
			for (int i = 0; i < scores.length; i++) {
				if (scores[i] >= loLimit && scores[i] <= upLimit) {
					count++;
				}
			}
			jobOfferCount[q] = count;
		}
		return jobOfferCount;
	}

	private static int uniquePairs(List<Integer> a, Long k) {
		Map<Long, Long> map = new HashMap<>();
		HashSet<Long> hs = new HashSet<>();
		int count = 0;
		for (Integer num : a) {
			if (map.containsValue((long) num) && !hs.contains((long) num)) {
				count++;
				hs.add(k - num);
				hs.add((long) num);
			} else {
				map.put((long) num, k - num);
			}
		}
		return count;
	}

	private static int pseudoCode(int a, int b) {
		int x = a;
		int y = b;
		while (x != y) {
			if (x > y)
				x = x - y;
			else
				y = y - x;
		}
		return x;
	}
}
