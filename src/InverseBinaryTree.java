import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node{
	int val;
	Node left;
	Node right;
	public Node(int val) {
		this.val=val;
		left=null;
		right=null;
	}
}

public class InverseBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(7);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.left = new Node(6);
		root.right.right = new Node(9);

		BinaryTreeOp bt = new BinaryTreeOp();
		//bt.inverseTree_DFS(root);
		bt.inverseTree_iter(root);
	}
}

class BinaryTreeOp{
	//recursive DFS
	public Node inverseTree_DFS(Node root) {
		if(root==null)
			return null;
		final Node left = root.left;
		final Node right = root.right;

		root.left = inverseTree_DFS(right);
		root.right = inverseTree_DFS(left);

		return root;
	}
	
	//iterative DFS
	public Node inverseTree_iter(Node root) {
		if(root==null)
			return null;
		final Stack<Node> stack = new Stack<Node> ();
		stack.push(root);
		while(!stack.isEmpty()) {
			final Node node = stack.pop();
			final Node left = node.left;
			node.left = node.right;
			node.right = left;
			if(node.left!=null)
				stack.push(node.left);
			if(node.right!=null)
				stack.push(node.right);
		}
		return root;
	}
	
	//BFS
	public Node inverseTree_BFS(Node root) {
		if(root==null)
			return null;
		final Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			final Node node = queue.poll();
			final Node left = node.left;
			node.left = node.right;
			node.right = left;
			if(node.left!=null)
				queue.offer(node.left);
			if(node.right!=null)
				queue.offer(node.right);
		}
		return root;
	}

}
