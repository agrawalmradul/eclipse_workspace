package com.ctci.c_stacksQueues;

public class MyQueue<T> {

	private static class QueueNode<T> {
		private T data;
		private QueueNode<T> next;

		public QueueNode(T data) {
			this.data = data;
		}
	}

	QueueNode<T> front;
	QueueNode<T> rear;

	public void enqueue(T data) {
		QueueNode<T> temp = new QueueNode<T>(data);
		if (rear != null)
			rear.next = temp;
		temp.next = rear;
		rear = temp;
	}

	public T dequeue() {
		if (front == null)
			return null;
		T data = front.data;
		front = front.next;
		if (front == null)
			rear = null;
		return data;
	}

	public T peek() {
		if (front == null)
			return null;
		return front.data;
	}

	public boolean isEmpty() {
		return front == null;
	}
}
