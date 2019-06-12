package com.ctci.d_treesGraphs;

public class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	TreeNode parent; //dummy variable

	public TreeNode(int data) {
		this.data = data;
	}

	public static void inOrder(TreeNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}
}
