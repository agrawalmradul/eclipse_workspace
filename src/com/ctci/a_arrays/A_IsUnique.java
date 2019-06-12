package com.ctci.a_arrays;

import java.util.HashSet;

//Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?

public class A_IsUnique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String in = "absdf";
		System.out.println(isUniqueWD(in));
		System.out.println(isUniqueWOD(in));
	}
	
	public static boolean isUniqueWD(String in) {
		HashSet<Character> hs = new HashSet<>();
		for (char ch : in.toCharArray()) {
			if(hs.contains(ch)) {
				return false;
			}
			else
				hs.add(ch);
		}
		return true;
	}
	
	public static boolean isUniqueWOD(String in) {
		for (int i = 0; i < in.length()-1; i++) {
			for(int j = i+1; j < in.length(); j++) {
				if(in.charAt(i) == in.charAt(j))
					return false;
			}
		}
		return true;
	}
}
