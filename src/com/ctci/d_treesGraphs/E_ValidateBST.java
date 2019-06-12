package com.ctci.d_treesGraphs;

/**
 * Validate BST: Implement a function to check if a binary tree is a binary
 * search tree.
 */

public class E_ValidateBST {

	public static void main(String[] args) {
		int[] in = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 10 };
		TreeNode root = B_minimalTree.minimalTree(in, 0, in.length - 1);
		System.out.println(isBST(root));
	}

	public static boolean isBST(TreeNode root) {
		if (root == null)
			return true;

		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean checkBST(TreeNode root, int min, int max) {
		if (root == null)
			return true;

		if (root.data < min || root.data > max)
			return false;

		return checkBST(root.left, min, root.data) && checkBST(root.right, root.data, max);
	}
}
