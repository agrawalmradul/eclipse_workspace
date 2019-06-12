package com.ctci.b_linkedlist;

/**
 * Loop Detection: Given a circular linked list, implement an algorithm that
 * returns the node at the beginning of the loop. DEFINITION Circular linked
 * list: A (corrupt) linked list in which a node's next pointer points to an
 * earlier node, so as to make a loop in the linked list. EXAMPLE Input: A -> B
 * -> C - > D -> E -> C [the same C as earlier] Output: C
 */

public class H_LoopDetection {

	public static void main(String[] args) {
		Node preHead = new Node(1);
		Node head = new Node(2);
		Node head_2 = new Node(3);
		Node head_3 = new Node(4);
		Node head_4 = new Node(5);
		Node head_5 = new Node(6);

		preHead.next = head;
		head.next = head_2;
		head_2.next = head_3;
		head_3.next = head_4;
		head_4.next = head_5;
		head_5.next = head;
		Node result = detectLoop(preHead);
		System.out.println(result.data);
	}

	public static Node detectLoop(Node head) {
		Node slow = head;
		Node fast = head;

		while (true) {
			if (fast == null || fast.next == null)
				return null;
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				break;
		}

		while (head != slow) {
			slow = slow.next;
			head = head.next;
		}

		return head;
	}
}
