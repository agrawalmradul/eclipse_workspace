package com.interviews.Stubhub;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SubstringPalindrone {

	/*
	 * Complete the 'countPalindromes' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts STRING s
	 * as parameter.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "tacocat";
		SubstringPalindrone obj = new SubstringPalindrone();
		System.out.println(obj.countPalindromes(input));
	}

	public int countPalindromes(String s) {

		ArrayList<Character> charArr = new ArrayList<>();
		for (Character ch : s.toCharArray()) {
			charArr.add(ch);
		}

		ArrayList<ArrayList<Character>> words = getSubsets_2(charArr);
		int count = -1;
		for (List<Character> word : words) {
			String temp = word.stream().map(String::valueOf).collect(Collectors.joining());

			if ((s.indexOf(temp) != -1) && (temp.length() == 1 || isPalindrome(temp))) {
				count++; System.out.println(temp);}
		}
		return count;
	}

	public ArrayList<ArrayList<Character>> getSubsets_2(ArrayList<Character> set) {
		ArrayList<ArrayList<Character>> allSubsets = new ArrayList<ArrayList<Character>>();
		allSubsets.add(new ArrayList<Character>());
		for (int i = 0; i < set.size(); i++) {
			ArrayList<ArrayList<Character>> inner = new ArrayList<ArrayList<Character>>();
			for (ArrayList<Character> subset : allSubsets) {
				ArrayList<Character> temp = new ArrayList<Character>();
				temp.addAll(subset);
				temp.add(set.get(i));
				inner.add(temp);
			}
			allSubsets.addAll(inner);
		}
		return allSubsets;
	}

	private boolean isPalindrome(String str) {
		int len = str.length();
		for (int i = 0; i < len / 2; i++) {
			if (str.charAt(i) != str.charAt(len - i - 1)) {
				return false;
			}
		}
		return true;
	}
}
