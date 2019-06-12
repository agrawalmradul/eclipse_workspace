import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphNode node1 = new GraphNode(1);
		GraphNode node2 = new GraphNode(2);
		GraphNode node3 = new GraphNode(3);
		GraphNode node4 = new GraphNode(4);
		GraphNode node5 = new GraphNode(5);
		GraphNode node6 = new GraphNode(6);
		GraphNode node7 = new GraphNode(7);
		GraphNode node8 = new GraphNode(8);
		GraphNode node9 = new GraphNode(9);
		GraphNode node10 = new GraphNode(10);


		node1.neighbors.add(node3);
		node1.neighbors.add(node5);

		node2.neighbors.add(node4);
		node2.neighbors.add(node6);
		node2.neighbors.add(node10);


		node3.neighbors.add(node1);
		node3.neighbors.add(node5);

		node4.neighbors.add(node2);

		node5.neighbors.add(node1);
		node5.neighbors.add(node3);
		node5.neighbors.add(node8);
		node5.neighbors.add(node9);
		node5.neighbors.add(node7);


		node6.neighbors.add(node2);

		node7.neighbors.add(node5);

		node8.neighbors.add(node5);
		node8.neighbors.add(node9);

		node9.neighbors.add(node8);
		node9.neighbors.add(node5);

		node10.neighbors.add(node2);

		List<GraphNode> input = new ArrayList<>();
		input.add(node1);
		input.add(node2);
		input.add(node3);
		input.add(node4);
		input.add(node5);
		input.add(node6);
		input.add(node7);
		input.add(node8);
		input.add(node9);
		input.add(node10);

//		dfs(input);

		System.out.println(bfs(input, node1, node9 ));

	}

	public static void dfs(List<GraphNode> nodes) {
		HashSet<GraphNode> isVisited = new HashSet<>();
		for(GraphNode node:nodes) {
			if(!isVisited.contains(node)) {
				printDfs(node, isVisited);
				System.out.println(" ");
			}
		}
	}

	public static void printDfs(GraphNode node, HashSet<GraphNode> isVisited) {
		System.out.print(node.label + " ");
		isVisited.add(node);
		for(GraphNode neighbor : node.neighbors) {
			if(!isVisited.contains(neighbor))
				printDfs(neighbor, isVisited);
		}
	}

	public static int bfs(List<GraphNode> nodes, GraphNode start, GraphNode end) {
		HashSet<GraphNode> isVisited = new HashSet<>();
		Queue<GraphNode> queue = new LinkedList<>();
		queue.add(start);
		isVisited.add(start);
		while(!queue.isEmpty()) {
			GraphNode curr = queue.remove();
			if(curr == end)
				return 1;
			for(GraphNode neighbor : curr.neighbors) {
				if(!isVisited.contains(neighbor)) {
					queue.add(neighbor);
					isVisited.add(neighbor);
				}

			}
		}
		return -1;
	}
}

class GraphNode{
	List<GraphNode> neighbors;
	int label;
	GraphNode(int label){
		neighbors = new ArrayList<GraphNode>();
		this.label = label;
	}
}


