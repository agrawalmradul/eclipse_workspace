package com.ctci.b_linkedlist;

import java.util.HashSet;

/**
 * Remove Dups! Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP How would you solve this problem if a temporary buffer is not
 * allowed?
 */

public class A_RemoveDups {

	public static void main(String[] args) {
		Node head = new Node(1);
		Node head_2 = new Node(2);
		Node head_3 = new Node(3);
		Node head_4 = new Node(2);
		Node head_5 = new Node(4);
		Node preHead = new Node(1);
		preHead.next = head;
		head.next = head_2;
		head_2.next = head_3;
		head_3.next = head_4;
		head_4.next = head_5;
		head_5.next = new Node(4);
		Node.printLinkedList(preHead);
		remDups2(preHead);
		Node.printLinkedList(preHead);
	}

	public static Node remDups(Node head) {
		if (head.next == null || head == null)
			return head;

		Node currNode = head;
		Node prevNode = head;
		HashSet<Integer> hs = new HashSet<>();
		while (currNode != null) {
			if (hs.contains(currNode.data))
				prevNode.next = currNode.next;
			else {
				hs.add(currNode.data);
				prevNode = currNode;
			}
			currNode = currNode.next;
		}
		return head;
	}

	// no buffer
	public static Node remDups2(Node head) {
		if (head.next == null || head == null)
			return head;

		Node curr = head;

		while (curr != null) {
			Node runner = curr;
			while (runner.next != null) {
				if (curr.data == runner.next.data)
					runner.next = runner.next.next;
				else
					runner = runner.next;
			}
			curr = curr.next;
		}
		return head;
	}
}
