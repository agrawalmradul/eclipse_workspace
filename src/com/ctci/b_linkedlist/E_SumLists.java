package com.ctci.b_linkedlist;

/**
 * Sum Lists: You have two numbers represented by a linked list, where each node
 * contains a single digit. The digits are stored in reverse order, such that
 * the 1 's digit is at the head of the list. Write a function that adds the two
 * numbers and returns the sum as a linked list. EXAMPLE Input: (7-> 1 -> 6) +
 * (5 -> 9 -> 2).That is,617 + 295. Output: 2 -> 1 -> 9. That is, 912. FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * EXAMPLE lnput:(6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295. Output: 9 - >
 * 1 -> 2. That is, 912.
 */

public class E_SumLists {

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
		head_4.next = head_5;

		head_5.next = new Node(7);
		Node.printLinkedList(preHead);
		Node.printLinkedList(head_4);
		Node result = sumLists(preHead, head_4);
		Node.printLinkedList(result);
	}

	public static Node sumLists(Node h1, Node h2) {
		if (h1 == null || h2 == null)
			return (h1 == null) ? h2 : h1;

		Node result = new Node(0);
		Node curr = result;
		int carry = 0;
		while (h1 != null || h2 != null) {
			int val1 = (h1 == null) ? 0 : h1.data;
			int val2 = (h2 == null) ? 0 : h2.data;
			int sum = val1 + val2 + carry;
			curr.next = new Node(sum % 10);
			carry = (sum > 9) ? 1 : 0;
			h1 = (h1 == null) ? null : h1.next;
			h2 = (h2 == null) ? null : h2.next;
			curr = curr.next;
		}

		if (carry > 0)
			curr.next = new Node(carry);
		return result.next;
	}
}
