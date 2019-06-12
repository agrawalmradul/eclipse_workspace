package com.ctci.c_stacksQueues;

public class MyStack<T> {
	private static class StackNode<T> {
		private T data;
		private StackNode<T> next;

		public StackNode(T data) {
			this.data = data;
		}
	}

	StackNode<T> top;

	public void push(T data) {
		StackNode<T> temp = new StackNode<T>(data);
		temp.next = top;
		top = temp;
	}

	public T pop() {
		if (top == null)
			return null;
		T item = top.data;
		top = top.next;
		return item;
	}

	public T peek() {
		if (top == null)
			return null;
		return top.data;
	}

	public boolean isEmpty() {
		return top == null;
	}
}
