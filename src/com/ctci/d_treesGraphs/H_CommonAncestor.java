package com.ctci.d_treesGraphs;

/**
 * First Common Ancestor: Design an algorithm and write code to find the first
 * common ancestor of two nodes in a binary tree. Avoid storing additional nodes
 * in a data structure. NOTE: This is not necessarily a binary search tree.
 */

public class H_CommonAncestor {

	public static void main(String[] args) {
		int[] in = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		TreeNode root = B_minimalTree.minimalTree(in, 0, in.length - 1);
		
		TreeNode ancestor = commonAncestor(root, root.left.right, root.left);
		System.out.println(ancestor.data);
	}

	public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q)
			return root;
		TreeNode left = commonAncestor(root.left, p, q);
		TreeNode right = commonAncestor(root.right, p, q);
		return (left != null && right != null) ? root : (left == null) ? right : left;
	}
}
