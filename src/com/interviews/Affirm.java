package com.interviews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

// Part 1: Implement a data-structure that supports dictionary operations, get,
// put, delete, along with a special operation get_random_val; this latter
// function should return a uniformly random value sampled from all the values
// in the dictionary. Each function should run in constant time, with the
// exception of delete, which for this part we relax to linear time.

// Part 2: Given an implementation of the aforementioned data-structure, modify
// get_random_val to sample unique values in the dictionary. For example, given
// a dictionary {'a': 5, 'b': 5, 'c': 6, 'd': 5}, 5 and 6 should both have an
// equal probability of being selected. The time complexity of each method
// should not change, with the exception of put, which under a certain case may
// run in linear time.

// array size = 16
// hello = there
// hashCode(hello) % 16
// a = 1
// b = 1 # probability: 25% -> 33%
// s = 18
// p = 56

// b = 2
// random = 3
// a_1, b_1, s_18, p_56
// a, b, s, p
// a, s, p
// 1 18 56 2

public class Affirm {

	public static void main(String[] args) {
		MyDict dict = new MyDict();

		dict.put("a", 1);
		dict.put("b", 1);
		dict.put("d", 3);
		dict.put("q", 4);

		HashMap<Integer, Integer> counter = new HashMap<>();
		for (int i = 0; i < 10000; i++) {
			int value = dict.get_random_val();
			counter.put(value, counter.getOrDefault(value, 0) + 1);
		}
		System.out.println(counter);
	}
}

class MyDict {

	HashMap<String, Integer> map;
	// List<String> keys;
	List<Integer> listValues;
	Set<Integer> setValues;

	public MyDict() {
		map = new HashMap<String, Integer>();
		setValues = new HashSet<Integer>();
		listValues = new ArrayList<>();
	}

	public Integer get(String key) {
		return map.get(key);
	}

	public void put(String key, Integer value) {
		// {'a': 1}
		// put('a', 2)
		if (!setValues.contains(value)) {
			listValues.add(value);
		}
		setValues.add(value);
		map.put(key, value);
	}

	public void delete(String key) {
		Integer value = map.get(key);
		listValues.remove(value);
		setValues.remove(value);
		map.remove(key);
	}

	// get_randon_val
	// https://www.tutorialspoint.com/java/util/random_nextint_inc_exc.htm
	public Integer get_random_val() {
		Random rand = new Random();
		int randVal = rand.nextInt(listValues.size());
		// String randKey = keys.get(randVal);
		return listValues.get(randVal);
	}
}
