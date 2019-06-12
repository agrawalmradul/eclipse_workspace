package codepractice.dp;

import java.util.HashMap;

class LRUCache {
	private int iCapacity;
	private Node head = null;
	private Node end = null;
	HashMap<Integer, Node> map;

	public LRUCache(int capacity) {
		iCapacity = capacity;
		map = new HashMap<Integer, Node>();
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node n = map.get(key);
			remove(n);
			setHead(n);
			return n.value;
		}
		return -1;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			Node old = map.get(key);
			old.value = value;
			remove(old);
			setHead(old);
		} else {
			Node newNode = new Node(key, value);
			if (map.size() >= iCapacity) {
				map.remove(end.key);
				remove(end);
				setHead(newNode);
			} else {
				setHead(newNode);
			}
			map.put(key, newNode);
		}
	}

	private void remove(Node n) {
		if (n.next != null) {
			n.next.prev = n.prev;
		} else {
			end = n.prev;
		}

		if (n.prev != null) {
			n.prev.next = n.next;
		} else {
			head = n.next;
		}
	}

	private void setHead(Node n) {
		n.next = head;
		n.prev = null;

		if (head != null) {
			head.prev = n;
		}
		head = n;

		if (end == null)
			end = head;
	}

}

class Node {
	public int key;
	public int value;
	public Node prev;
	public Node next;

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
		prev = null;
		next = null;
	}
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
