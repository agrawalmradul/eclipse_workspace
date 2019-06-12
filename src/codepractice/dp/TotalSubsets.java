package codepractice.dp;

import java.util.ArrayList;

public class TotalSubsets {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
	}

	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
		allSubsets.add(new ArrayList<Integer>());
		for (int i = 0; i < set.size(); i++) {
			ArrayList<ArrayList<Integer>> inner = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> subset : allSubsets) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.addAll(subset);
				temp.add(set.get(i));
				inner.add(temp);
			}
			allSubsets.addAll(inner);
		}
		return allSubsets;
	}

}
