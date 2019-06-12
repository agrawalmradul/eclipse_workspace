package com.ctci.b_linkedlist;

public class Node {
	int data;
	Node next;
	public Node(int data) {
		this.data = data;
	}
	
	public static void printLinkedList(Node head) {
		while (head != null) {
			System.out.print(head.data + " -> ");
			head = head.next;
		}
		System.out.print("null");
		System.out.println();
	}
	
	public static Node getMidNode(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
