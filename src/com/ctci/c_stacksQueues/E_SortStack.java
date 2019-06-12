package com.ctci.c_stacksQueues;

import java.util.Stack;

/**
 * Sort Stack: Write a program to sort a stack such that the smallest items are
 * on the top. You can use an additional temporary stack, but you may not copy
 * the elements into any other data structure (such as an array). The stack
 * supports the following operations: push, pop, peek, and is Empty.
 */

public class E_SortStack {

	public static void main(String[] args) {
		E_SortStack sort = new E_SortStack();
		Stack<Integer> plates = new Stack<>();
		plates.push(1);
		plates.push(2);
		plates.push(3);
		plates.push(4);
		plates.push(5);
		plates.push(6);
		plates.push(7);
		plates.push(8);
		plates.push(9);
		plates.push(4);
		System.out.println(plates);
		sort.sortStack(plates);

		System.out.println(plates);
	}

	Stack<Integer> temp;

	public E_SortStack() {
		temp = new Stack<>();
	}

	public void sortStack(Stack<Integer> stk) {
		while (!stk.isEmpty()) {
			Integer data = stk.pop();
			while (!temp.isEmpty() && data < temp.peek()) {
				stk.push(temp.pop());
			}
			temp.push(data);
		}

		while (!temp.isEmpty()) {
			stk.push(temp.pop());
		}
	}
}
