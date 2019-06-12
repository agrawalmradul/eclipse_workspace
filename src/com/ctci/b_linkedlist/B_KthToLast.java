package com.ctci.b_linkedlist;

/**
 * Return Kth to Last: Implement an algorithm to find the kth to last element of
 * a singly linked list.
 */

public class B_KthToLast {

	public static void main(String[] args) {
		Node head = new Node(1);
		Node head_2 = new Node(5);
		Node head_3 = new Node(3);
		Node head_4 = new Node(2);
		Node head_5 = new Node(4);
		Node preHead = new Node(1);
		preHead.next = head;
		head.next = head_2;
		head_2.next = head_3;
		head_3.next = head_4;
		head_4.next = head_5;
		head_5.next = new Node(6);
		Node.printLinkedList(preHead);
		Node result = kth2Last(preHead, 4);
		System.out.println(result.data);
	}

	public static Node kth2Last(Node head, int k) {
		if (head == null || k == 0)
			return null;

		Node start = head;
		Node end = head;
		while (k > 0) {
			if (end == null)
				return null;
			end = end.next;
			k--;
		}

		while (end != null) {
			start = start.next;
			end = end.next;
		}
		return start;
	}
}
