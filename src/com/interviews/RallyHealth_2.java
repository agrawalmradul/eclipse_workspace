package com.interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class RallyHealth_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "Test1";
		String[] rest = test.split("[^A-Z0-9a-z]+|(?<=[a-z])(?=[0-9])|(?<=[0-9])(?=[a-z])");
		System.out.println(Arrays.toString(rest));

		String[] T = { "test1a", "test2", "test1b", "test1c", "test3" };
		String[] R = { "Wrong answer", "OK", "Runtime error", "OK", "Time limit exceeded" };
		solution(T, R);
	}

	static class GroupScore {
		char group;
		String score;

		GroupScore(String score) {
			this.score = score;
		}

		GroupScore(char group, String score) {
			this.group = group;
			this.score = score;
		}
	}

	public static int solution(String[] T, String[] R) {
		// write your code in Java SE 8

		HashMap<Integer, List<GroupScore>> map = getTestMapped(T, R);
		int totalGroups = map.size();
		int passedGroups = 0;

		for (Entry<Integer, List<GroupScore>> entry : map.entrySet()) {
			List<GroupScore> gsList = entry.getValue();
			if (isPassed(gsList))
				passedGroups++;
		}

		double result = passedGroups * 100 / totalGroups;
		System.out.println((int)result);

		return 0;
	}

	private static HashMap<Integer, List<GroupScore>> getTestMapped(String[] T, String[] R) {
		int size = T.length;
		HashMap<Integer, List<GroupScore>> map = new HashMap<>();

		for (int i = 0; i < size; i++) {
			String[] test = T[i].split("[^A-Z0-9a-z]+|(?<=[a-z])(?=[0-9])|(?<=[0-9])(?=[a-z])");
			Integer groupNum = Integer.parseInt(test[1]);
			GroupScore gs;
			if (test.length == 2) {
				gs = new GroupScore(R[i]);
				List<GroupScore> list = new ArrayList<>();
				list.add(gs);
				map.put(groupNum, list);
			} else {
				char subtest = test[2].charAt(0);
				gs = new GroupScore(subtest, R[i]);
				if (map.containsKey(groupNum)) {
					map.get(groupNum).add(gs);
				} else {
					List<GroupScore> list = new ArrayList<>();
					list.add(gs);
					map.put(groupNum, list);
				}
			}
		}
		return map;
	}

	private static boolean isPassed(List<GroupScore> gsList) {
		for (GroupScore gs : gsList) {
			String score = gs.score;
			if (!score.equals("OK")) {
				return false;
			}
		}
		return true;
	}
}
