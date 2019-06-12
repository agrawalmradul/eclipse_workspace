package com.interviews;

import java.util.HashMap;
import java.util.Map;

public class BlueShift {

	// HashMap as input
	// empty => null, empty HashMap
	// input = {"a" => 1, "b" => null, "c" => {"d" => {}, "e" => 2}}
	// output = {"a" => 1, "c" => {"e" => 2}}

	public static void main(String[] args) {
		// char[] input = {'T', 'T', 'T', 'T', 'T', 'T', 'T'};
		// char[] input = {'H', 'T', 'T', 'T'};

		// System.out.println(conHeads(input));

		Map<Character, Object> in2 = new HashMap<>();
		in2.put('a', 1);
		in2.put('b', 2);
		in2.put('c', null);
		in2.put('d', 4);

		clearHashMap(in2);
		System.out.println(in2);
		// Map<Character, Character> instanceObj = new HashMap<>();

	}

	public static int conHeads(char[] toss){
		int maxCount = 0;
		int temp = 0;
		for(char ch : toss){
			if(ch == 'H')
				temp++;
			else {
				temp = 0;
			}
			maxCount = Math.max(maxCount, temp);
		}
		return maxCount;
	}

	public static void clearHashMap(Map<Character, Object> in2){

		Map<Object, Object> instanceObj = new HashMap<>();

		for(Map.Entry<Character, Object> e : in2.entrySet()){
			Class cl = e.getValue().getClass();

			if(e.getValue() == null)
				in2.remove(e.getKey());
			else if(cl.isInstance(instanceObj))
				clearHashMap(e.getValue());
		}

	}
}