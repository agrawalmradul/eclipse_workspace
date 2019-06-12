package com.ctci.b_linkedlist;

/**
 * Palindrome: Implement a function to check if a linked list is a palindrome.
 */

public class F_Palindrome {

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
		System.out.println(isPalindrom(preHead));
		// Node.printLinkedList(preHead);
	}

	public static boolean isPalindrom(Node head) {
		if (head == null)
			return false;
		Node rev = revLinkedList(head);
		while (rev != null) {
			if (rev.data != head.data)
				return false;
			rev = rev.next;
			head = head.next;
		}
		return true;
	}

	private static Node revLinkedList(Node head) {
		Node rev = null;
		Node curr = head;
		while (curr != null) {
			Node temp = new Node(curr.data);
			temp.next = rev;
			rev = temp;
			curr = curr.next;
		}
		return rev;
	}
}
