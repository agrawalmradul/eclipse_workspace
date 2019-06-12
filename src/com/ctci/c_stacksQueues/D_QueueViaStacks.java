package com.ctci.c_stacksQueues;

import java.util.Stack;

/**
 * Queue via Stacks: Implement a MyQueue class which implements a queue using
 * two stacks.
 */

public class D_QueueViaStacks<T> {

	public static void main(String[] args) {
		D_QueueViaStacks<Integer> sfq = new D_QueueViaStacks<>();
		sfq.enqueue(1);
		sfq.enqueue(2);
		sfq.enqueue(3);
		sfq.enqueue(4);
		sfq.enqueue(5);
		// System.out.println(sfq.load.toString());
		// System.out.println(sfq.unload.toString());
		//// sfq.dequeue();
		// System.out.println(sfq.load.toString());
		// System.out.println(sfq.unload.toString());
		System.out.println(sfq.load.toString());
		System.out.println(sfq.pop());
		System.out.println(sfq.load.toString());
		System.out.println(sfq.pop());
		System.out.println(sfq.load.toString());
		System.out.println(sfq.pop());
		System.out.println(sfq.load.toString());
		System.out.println(sfq.pop());
		System.out.println(sfq.load.toString());
		System.out.println(sfq.pop());
		System.out.println(sfq.load.toString());

	}

	private Stack<T> load;
	private Stack<T> unload;

	D_QueueViaStacks() {
		load = new Stack<>();
		unload = new Stack<>();
	}

	public void enqueue(T data) {
		load.push(data);
	}

	public T dequeue() {
		reLoad();
		return unload.pop();
	}

	public T peek() {
		reLoad();
		return unload.peek();
	}

	private void reLoad() {
		if (unload.isEmpty()) {
			while (!load.isEmpty()) {
				unload.push(load.pop());
			}
		}
	}

	// using only one stack
	public T pop() {
		if (load.isEmpty())
			return null;
		T data = load.pop();
		if (load.isEmpty())
			return data;
		T result = null;
		if (load.size() == 1)
			result = load.pop();
		else
			result = pop();
		load.push(data);
		return result;
	}
}
