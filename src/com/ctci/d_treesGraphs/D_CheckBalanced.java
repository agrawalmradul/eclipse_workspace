package com.ctci.d_treesGraphs;

/**
 * Check Balanced: Implement a function to check if a binary tree is balanced.
 * For the purposes of this question, a balanced tree is defined to be a tree
 * such that the heights of the two subtrees of any node never differ by more
 * than one.
 */

public class D_CheckBalanced {

	public static void main(String[] args) {
		int[] in = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		TreeNode root = B_minimalTree.minimalTree(in, 0, in.length - 1);
		System.out.println(isBalanced(root));
	}

	public static boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;

		int diff = Math.abs(getHeight(root.left) - getHeight(root.right));
		if (diff > 1)
			return false;
		else
			return isBalanced(root.left) && isBalanced(root.right);
	}

	public static boolean isBalanced_new(TreeNode root) {
		if (root == null)
			return true;

		return checkHeight(root) != Integer.MIN_VALUE;
	}

	private static int checkHeight(TreeNode root) {
		if (root == null)
			return -1;

		int leftHeight = checkHeight(root.left);
		if (leftHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		int rightHeight = checkHeight(root.right);
		if (rightHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		int height = Math.abs(rightHeight - leftHeight);
		if (height > 1)
			return Integer.MIN_VALUE;
		else
			return Math.max(leftHeight, rightHeight) + 1;
	}

	private static int getHeight(TreeNode root) {
		if (root == null)
			return -1;

		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}

}
