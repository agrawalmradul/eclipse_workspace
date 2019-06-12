package com.ctci.b_linkedlist;

/**
 * Partition: Write code to partition a linked list around a value x, such that
 * all nodes less than x come before all nodes greater than or equal to x. If x
 * is contained within the list, the values of x only need to be after the
 * elements less than x (see below). The partition element x can appear anywhere
 * in the "right partition"; it does not need to appear between the left and
 * right partitions. EXAMPLE Input: Output: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1
 * [partition= 5] 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 */

public class D_Partition {

	public static void main(String[] args) {
		Node preHead = new Node(8);
		Node head = new Node(2);
		Node head_2 = new Node(3);
		Node head_3 = new Node(7);
		Node head_4 = new Node(6);
		Node head_5 = new Node(4);

		preHead.next = head;
		head.next = head_2;
		head_2.next = head_3;
		head_3.next = head_4;
		head_4.next = head_5;
		head_5.next = new Node(3);
		Node.printLinkedList(preHead);
		Node result = partition(preHead, 4);
		Node.printLinkedList(result);
	}

	public static Node partition(Node head, int k) {
		if (head == null)
			return null;

		Node head1 = null;
		Node tail1 = head1;

		Node head2 = null;
		Node tail2 = null;

		while (head != null) {
			if (head.data < k) {
				if (head1 == null) {
					head1 = new Node(head.data);
					tail1 = head1;
				} else {
					tail1.next = new Node(head.data);
					tail1 = tail1.next;
				}
			} else {
				if (head2 == null) {
					head2 = new Node(head.data);
					tail2 = head2;
				} else {
					tail2.next = new Node(head.data);
					tail2 = tail2.next;
				}
			}
			head = head.next;
		}
		tail1.next = head2;
		return head1;
	}

}
