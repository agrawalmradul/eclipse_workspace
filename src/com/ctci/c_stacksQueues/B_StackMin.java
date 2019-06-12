package com.ctci.c_stacksQueues;

import java.util.Stack;

/**
 * Stack Min: How would you design a stack which, in addition to push and pop,
 * has a function min which returns the minimum element? Push, pop and min
 * should all operate in 0(1) time.
 */

public class B_StackMin {

	public static void main(String[] args) {
		B_StackMin newStack = new B_StackMin();
		newStack.push(5);
		newStack.push(9);
		newStack.push(7);
		newStack.push(11);
		newStack.push(1);
		newStack.push(12);
		newStack.push(-1);

		System.out.println(newStack.org.toString());
		System.out.println(newStack.min.toString());
		System.out.println("-----");
		newStack.pop();
		System.out.println(newStack.org.toString());
		System.out.println(newStack.min.toString());
		System.out.println("-----");
		newStack.pop();
		System.out.println(newStack.org.toString());
		System.out.println(newStack.min.toString());
		System.out.println("-----");
		newStack.pop();
		System.out.println(newStack.org.toString());
		System.out.println(newStack.min.toString());
		System.out.println("-----");

	}

	Stack<Integer> org;
	Stack<Integer> min;

	public B_StackMin() {
		org = new Stack<>();
		min = new Stack<>();
	}

	public void push(Integer data) {
		if (min.isEmpty() || min.peek() > data)
			min.push(data);
		org.push(data);
	}

	public Integer pop() {
		if (org.isEmpty())
			return null;

		Integer popped = org.pop();
		if (popped == min.peek())
			min.pop();
		return popped;
	}

	public Integer min() {
		return min.isEmpty() ? null : min.peek();
	}

	public Integer peek() {
		return org.isEmpty() ? null : org.peek();
	}

	public boolean isEmpty() {
		return org.isEmpty();
	}
}
