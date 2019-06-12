package com.ctci.b_linkedlist;

/**
 * Delete Middle Node: Implement an algorithm to delete a node in the middle
 * (i.e., any node but the first and last node, not necessarily the exact
 * middle) of a singly linked list, given only access to that node. EXAMPLE
 * lnput:the node c from the linked list a->b->c->d->e->f Result: nothing is
 * returned, but the new linked list looks like a->b->d->e- >f
 */

public class C_DelMidnode {

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
		head_5.next = new Node(7);
		Node.printLinkedList(preHead);
		delMidNode(head_3);
		Node.printLinkedList(preHead);
	}

	public static void delMidNode(Node mid) {
		if (mid == null || mid.next == null)
			return;
		mid.data = mid.next.data;
		mid.next = mid.next.next;
	}
}
