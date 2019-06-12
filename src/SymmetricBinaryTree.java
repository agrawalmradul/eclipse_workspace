public class SymmetricBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isMirror(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		if (root1.val != root2.val)
			return false;
		return isMirror(root1.right, root2.left) && isMirror(root1.left, root2.right);
	}

	class Node {
		int val;
		Node left;
		Node right;

		public Node(int data) {
			this.val = data;
			left = null;
			right = null;
		}
	}
}