package com.ctci.d_treesGraphs;

/**
 * Successor: Write an algorithm to find the "next" node (i.e., in-order
 * successor) of a given node in a binary search tree. You may assume that each
 * node has a link to its parent.
 */

public class F_Successor {

	public static void main(String[] args) {
		int[] in = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		TreeNode root = B_minimalTree.minimalTree(in, 0, in.length - 1);
		successor(root);
	}

	public static TreeNode successor(TreeNode n) {
		if (n == null)
			return null;

		if (n.right != null)
			return leftMostChild(n);
		else {
			TreeNode child = n;
			TreeNode parent = n.parent;
			while (parent != null && child != parent.left) {
				child = parent;
				parent = parent.parent;
			}
			return parent;
		}
	}

	private static TreeNode leftMostChild(TreeNode n) {
		while (n.left != null) {
			n = n.left;
		}
		return n;
	}
}