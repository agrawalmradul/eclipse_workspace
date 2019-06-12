package com.interviews;

public class Ebay_2 {
	//	Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
	//
	//	For example:
	//	Given the below binary tree and sum = 22,
	//
	//	              5
	//	             / \
	//	            4   8
	//	           /   / \
	//	          11  13  4
	//	         /  \      \
	//	        7    2      1
	//	        
	//	        
	//	(5, 22, false) 
	//	(4, 17, false)
	//	(11, 13, false)
	//	(2,2, true)

	private static class Node{
		int val;
		Node left;
		Node right;
		private Node(int val){
			this.val = val;
			left = null;
			right = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n0 = new Node(5);
		
		Node n1L = new Node(4);
		Node n1R = new Node(8);
		
		Node n2L = new Node(11);
		Node n2R0 = new Node(13);
		Node n2R1 = new Node(4);
		
		Node n3L0 = new Node(7);
		Node n3L1 = new Node(1);
		Node n3R0 = new Node(1);
		
		n0.left = n1L;
		n0.right = n1R;
		
		n1L.left = n2L;
		n1R.left = n2R0;
		n1R.right = n2R1;
		
		n2L.left = n3L0;
		n2L.right = n3L1;
		n2R1.right = n3R0;
		
		System.out.println(hasBranchSum(n0, 22));
		
	}

	public static boolean hasBranchSum(Node root, int sum){
		if(root != null)
			return traverseTree(root, sum);
		else 
			return false;    
	}

	private static boolean traverseTree(Node root, int sum){
		if(root!=null && sum == root.val && root.left == null && root.right == null)
			return true;
		boolean result = false;
		if(root != null){
			result = traverseTree(root.left, sum - root.val) ||
			traverseTree(root.right, sum - root.val);
		}

		return result;

	}
}
