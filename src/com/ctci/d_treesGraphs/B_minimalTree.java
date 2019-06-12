package com.ctci.d_treesGraphs;

/**
 * Minimal Tree: Given a sorted (increasing order) array with unique integer
 * elements, write an algorithm to create a binary search tree with minimal
 * height.
 */

public class B_minimalTree {

	public static void main(String[] args) {
		int[] in = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		TreeNode result = minimalTree(in, 0, in.length - 1);
		TreeNode.inOrder(result);
	}

	public static TreeNode minimalTree(int[] in, int start, int end) {
		while (start <= end) {
			int rootIndex = (end + start) / 2;
			TreeNode root = new TreeNode(in[rootIndex]);
			root.left = minimalTree(in, start, rootIndex - 1);
			root.right = minimalTree(in, rootIndex + 1, end);
			return root;
		}
		return null;
	}
}
