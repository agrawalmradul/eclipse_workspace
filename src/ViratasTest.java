import java.util.LinkedList;
import java.util.Queue;

public class ViratasTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public static void treeBFS(Node root) {
		if(root==null) return;
		Queue<Node> queue = new LinkedList<>();
		int sum = 0;
		
		queue.add(root);
		int count = 1;
		
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.remove();
//			System.out.println(temp.data);
//			sum += temp.data;
			while(!queue.isEmpty()) {
				Node innerQ = queue.remove();
//				sum += innerQ.data;
			}
			
			if(temp.left!=null) {
				queue.add(temp.left);
			}
			if(temp.right!=null) {
				queue.add(temp.right);
			}
			
		}
	}
}
