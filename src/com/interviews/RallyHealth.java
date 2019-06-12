package com.interviews;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class RallyHealth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(6, "1A 2F 1C 11D 11G 21J"));
		System.out.println(solution(6, ""));
	}

	public static int solution(int N, String S) {
		// write your code in Java SE 8
		
		
		if(S.length() == 0)
			return N*2;
		
		HashMap<Integer, Set<Character>> map;
		map = buildRowColMap(S);
		int emptyRows = N - map.size();
		return allocFamilies(map) + emptyRows * 2;
	}
	
	private static HashMap<Integer, Set<Character>> buildRowColMap(String S){
		String[] result = S.split(" ");
		HashMap<Integer, Set<Character>> map = new HashMap<>();

		for (String seat : result) {
			String[] seatRowCol = seat.split("[^A-Z0-9]+|(?<=[A-Z])(?=[0-9])|(?<=[0-9])(?=[A-Z])");
			Integer row = Integer.parseInt(seatRowCol[0]);
			Character col = seatRowCol[1].charAt(0);
			if (map.containsKey(row)) {
				map.get(row).add(col);
			} else {
				Set<Character> colList = new HashSet<>();
				colList.add(col);
				map.put(row, colList);
			}
		}
		return map;
	}

	private static int allocFamilies(HashMap<Integer, Set<Character>> map) {

		int count = 0;
		String left = "BCDE";
		String right = "FGHJ";
		String center = "DEFG";

		for (Entry<Integer, Set<Character>> entry : map.entrySet()) {
			Set<Character> listCol = entry.getValue();
			boolean isLeft = isAvailable(left, listCol);
			boolean isCenter = isAvailable(center, listCol);
			;
			boolean isRight = isAvailable(right, listCol);

			if (isLeft && isRight)
				count += 2;
			else if (isLeft || isRight)
				count++;
			else if (isCenter)
				count++;
		}

		return count;
	}

	private static boolean isAvailable(String seats, Set<Character> row) {
		for (Character ch : row) {
			if (seats.indexOf(ch) != -1)
				return false;
		}
		return true;
	}

}
