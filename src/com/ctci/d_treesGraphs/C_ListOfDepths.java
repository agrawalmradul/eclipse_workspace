package com.ctci.d_treesGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * List of Depths: Given a binary tree, design an algorithm which creates a
 * linked list of all the nodes at each depth (e.g., if you have a tree with
 * depth D, you'll have D linked lists).
 */

public class C_ListOfDepths {

	public static void main(String[] args) {
		int[] in = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		TreeNode root = B_minimalTree.minimalTree(in, 0, in.length - 1);

		List<LinkedList<Integer>> lists = listOfDepth(root);
		for (List<Integer> list : lists) {
			System.out.println(list.toString());
		}
	}

	public static List<LinkedList<Integer>> listOfDepth(TreeNode root) {
		List<LinkedList<Integer>> lists = new ArrayList<>();
		getDepth(root, lists, 0);
		return lists;
	}

	private static void getDepth(TreeNode root, List<LinkedList<Integer>> lists, int level) {
		if (root == null)
			return;
		LinkedList<Integer> list;
		if (lists.size() == level) {
			list = new LinkedList<>();
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		list.add(root.data);
		getDepth(root.left, lists, level + 1);
		getDepth(root.right, lists, level + 1);
	}
}
