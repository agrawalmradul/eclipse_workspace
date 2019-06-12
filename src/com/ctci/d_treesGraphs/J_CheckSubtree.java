package com.ctci.d_treesGraphs;

/**
 * Check Subtree: Tl and T2 are two very large binary trees, with Tl much bigger
 * than T2. Create an algorithm to determine if T2 is a subtree of Tl. A tree T2
 * is a subtree of Tl if there exists a node n in Tl such that the subtree of n
 * is identical to T2. That is, if you cut off the tree at node n, the two trees
 * would be identical.
 */

public class J_CheckSubtree {

	public static void main(String[] args) {
		int[] in = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		TreeNode root = B_minimalTree.minimalTree(in, 0, in.length - 1);
		System.out.println(isSubtree(root, root.right));
	}

	public static boolean isSubtree(TreeNode t1, TreeNode t2) {
		if (t2 == null)
			return true;
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		getString(t1, sb1);
		getString(t2, sb2);
		System.out.println(sb1);
		System.out.println(sb2);
		return sb1.indexOf(sb2.toString()) != -1;
	}

	public static void getString(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append("X");
			return;
		}

		sb.append(root.data);
		getString(root.left, sb);
		getString(root.right, sb);
	}

	public static boolean isSubtree_2(TreeNode t1, TreeNode t2) {
		if (t2 == null)
			return true;

		if (t1.data == t2.data)
			return matchTrees(t1, t2);
		else
			return isSubtree(t1.left, t2) || isSubtree(t1.right, t2);
	}

	public static boolean matchTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null)
			return true;
		else if (t1 == null || t2 == null)
			return false;
		else if (t1.data != t2.data)
			return false;
		else
			return matchTrees(t1.left, t2.left) || matchTrees(t1.right, t2.right);
	}
}
