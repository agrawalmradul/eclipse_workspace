package com.interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

// Module name format: <module-prefix>-<module-number>
// Sort module names, so we see module prefix and numbers in order

// Example Input: "header-01", "app-2", "side-bar-08", "app-12", "header-06"
// Expected Output: "app-2", "app-12", "header-01", "header-06", "side-bar-08"

// "app-1", "app-01"

public class Glassdoor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> modules = Arrays
				.asList(new String[] { "header-01", "app-2", "side-bar-08", "app-12", "header-06", "header-08" });

		List<String> sortedModules = sortModules(modules);

		for (String re : sortedModules) {
			System.out.println(re);
		}
	}

	static class StringComparator implements Comparator<String> {
		@Override
		public int compare(String s1, String s2) {
			String s1_str = s1.substring(0, s1.lastIndexOf("-"));
			String s2_str = s2.substring(0, s2.lastIndexOf("-"));
			Integer s1_int = Integer.parseInt(s1.substring(s1.lastIndexOf("-") + 1));
			Integer s2_int = Integer.parseInt(s2.substring(s2.lastIndexOf("-") + 1));

			if (s1_str.equals(s2_str)) {
				if (s1_int == s2_int)
					return 0;
				else if (s1_int > s2_int)
					return 1;
				else
					return -1;
			} else
				return s1_str.compareTo(s2_str);
		}
	}

	public static List<String> sortModules(List<String> input) {

		Comparator<String> comp = Comparator.comparing((String s1) -> s1.substring(0, s1.lastIndexOf("-")))
				.thenComparing((String s1) -> Integer.parseInt(s1.substring(s1.lastIndexOf("-") + 1)));

		Collections.sort(input, comp);
		return input;
	}

	public List<Integer> arrayIntersection(int[] a1, int[] a2) {
		List<Integer> result = new ArrayList<>();

		HashSet<Integer> a1Set = new HashSet<>();
		for (int in1 : a1)
			a1Set.add(in1);

		for (int in2 : a2) {
			if (a1Set.contains(in2))
				result.add(in2);
		}

		return result;
	}
}