package com.interviews;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class C3 {
	public static void main(String[] args) throws IOException {
//		String nodes = "(A,B) (A,C) (B,D) (C,F) (D,E) (E,G)";
		String nodes = "(A,B) (A,C) (B,D) (B,G) (C,E) (C,H) (E,F)";
		Result obj = new Result();
		String result = obj.SExpression(nodes);
		System.out.println(result);
	}
}

class Result {

	Map<Character, Set<Character>> nodeSet;
	Set<Character> visited;

	public Result() {
		nodeSet = new TreeMap<>();
		visited = new TreeSet<>();
	}

	public String SExpression(String nodes) {
		String[] pairs = nodes.split(" ");

		Set<Character> uniqueChildren = new TreeSet<>();

		for (String pair : pairs) {
			char parent = pair.charAt(1);
			char child = pair.charAt(3);
			Set<Character> children = nodeSet.getOrDefault(parent, new TreeSet<>());

			if (children.size() >= 2) {
				return "E1"; // more than two children
			} else if (children.contains(child)) {
				return "E2";
			} else if (uniqueChildren.contains(child)) {
				return "E3";
			} else {
				uniqueChildren.add(child);
				children.add(child);
			}
			nodeSet.put(parent, children);
		}

		Set<Character> oneParent = new TreeSet<>();
		oneParent.addAll(nodeSet.keySet());

		for (Character ch : uniqueChildren) {
			if (oneParent.contains(ch))
				oneParent.remove(ch);
		}

		if (oneParent.size() > 1) {
			return "E4";
		}

		StringBuilder sb = new StringBuilder();

		getSExpDFS(oneParent.iterator().next(), sb);

		return sb.toString();
	}

	private void getSExpDFS(Character parent, StringBuilder sb) {
		sb.append("(");
		sb.append(parent);
		visited.add(parent);

		if (!nodeSet.containsKey(parent))
			return;

		for (Character ch : nodeSet.get(parent)) {
			if (!visited.contains(ch)) {
				getSExpDFS(ch, sb);
			}
			sb.append(")");
		}
	}
}
