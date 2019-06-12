package com.ctci.h_recursionDP;

import java.util.ArrayList;

public class D_PowerSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> inputSet = new ArrayList<>();
		inputSet.add(1);
		inputSet.add(2);
		inputSet.add(3);
		inputSet.add(4);
		System.out.println(buildSubsets(inputSet, 0));
	}

	public static ArrayList<ArrayList<Integer>> buildSubsets(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allSubsets;
		if (set.size() == index) {
			allSubsets = new ArrayList<ArrayList<Integer>>();
			allSubsets.add(new ArrayList<Integer>());
		} else {
			allSubsets = buildSubsets(set, index + 1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> subset : allSubsets) {
				ArrayList<Integer> newSubset = new ArrayList<>();
				newSubset.addAll(subset);
				newSubset.add(item);
				moreSubsets.add(newSubset);
			}
			allSubsets.addAll(moreSubsets);
		}
		return allSubsets;
	}

}
