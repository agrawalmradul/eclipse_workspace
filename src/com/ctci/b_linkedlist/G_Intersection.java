package com.ctci.b_linkedlist;

/**
 * Intersection: Given two (singly) linked lists, determine if the two lists
 * intersect. Return the intersecting node. Note that the intersection is
 * defined based on reference, not value. That is, if the kth node of the first
 * linked list is the exact same node (by reference) as the jth node of the
 * second linked list, then they are intersecting.
 */

public class G_Intersection {

	public static void main(String[] args) {
		Node preHead = new Node(7);
		Node head = new Node(6);
		Node head_2 = new Node(5);
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
		Node.printLinkedList(head_5);
		Node intersect = intersection(preHead, head_5);
		System.out.println(intersect.data);
	}

	static class Result {
		int length;
		Node lastNode;

		Result(Node head) {
			int count = 0;
			while (head != null) {
				count++;
				head = head.next;
			}
			this.length = count;
			this.lastNode = head;
		}
	}

	public static Node intersection(Node head1, Node head2) {
		if (head1 == null || head2 == null)
			return null;

		Result r1 = new Result(head1);
		Result r2 = new Result(head2);

		System.out.println(r1.length);
		System.out.println(r2.length);

		if (r1.lastNode != r2.lastNode)
			return null;

		int len1 = r1.length;
		int len2 = r2.length;
		int diff = Math.abs(len1 - len2);

		Node shorter = len1 < len2 ? head1 : head2;
		Node longer = len1 < len2 ? head2 : head1;
		Node.printLinkedList(shorter);
		Node.printLinkedList(longer);

		while (diff != 0) {
			longer = longer.next;
			diff--;
		}

		Node.printLinkedList(shorter);
		Node.printLinkedList(longer);

		while (shorter != longer) {
			shorter = shorter.next;
			longer = longer.next;
		}
		return shorter;
	}
}
