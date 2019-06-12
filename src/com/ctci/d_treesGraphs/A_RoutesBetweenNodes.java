package com.ctci.d_treesGraphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Route Between Nodes: Given a directed graph, design an algorithm to find out
 * whether there is a route between two nodes.
 */

public class A_RoutesBetweenNodes {

	public static void main(String[] args) {

	}

	public static boolean hasRouter(Graph g, GraphNode a, GraphNode b) {
		if (a == b)
			return true;

		Queue<GraphNode> q = new LinkedList<>();

		for (GraphNode u : g.getNodes()) {
			u.isVisited = false;
		}

		GraphNode u;

		while (!q.isEmpty()) {
			u = q.poll();
			if (u != null) {
				for (GraphNode v : u.getAdjacent()) {
					if (!v.isVisited) {
						if (v == b) {
							return true;
						} else {
							q.add(v);
						}
					}
				}
			}
			u.isVisited = true;
		}
		return false;
	}
}

class GraphNode {
	boolean isVisited;
	List<GraphNode> adjacent;

	public List<GraphNode> getAdjacent() {
		return adjacent;
	}
}

class Graph {
	List<GraphNode> nodes;

	public List<GraphNode> getNodes() {
		return nodes;
	}
}