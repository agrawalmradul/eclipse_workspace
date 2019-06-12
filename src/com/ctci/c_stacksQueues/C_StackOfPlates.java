package com.ctci.c_stacksQueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too
 * high, it might topple. Therefore, in real life, we would likely start a new
 * stack when the previous stack exceeds some threshold. Implement a data
 * structure SetOfStacks that mimics this. SetO-fStacks should be composed of
 * several stacks and should create a new stack once the previous one exceeds
 * capacity. SetOfStacks. push() and SetOfStacks. pop() should behave
 * identically to a single stack (that is, pop () should return the same values
 * as it would if there were just a single stack).
 */

public class C_StackOfPlates<T> {

	public static void main(String[] args) {
		C_StackOfPlates<Integer> plates = new C_StackOfPlates<>(2);
		plates.push(1);
		plates.push(2);
		plates.push(3);
		plates.push(4);
		plates.push(5);
		plates.push(6);
		plates.push(7);
		plates.push(8);
		plates.push(9);
		plates.push(0);
		for (Stack<Integer> stack : plates.setOfStacks) {
			System.out.println(stack.toString());
		}
		plates.pop();
		plates.pop();
		plates.pop();
		plates.pop();
		plates.pop();
		System.out.println("---");
		for (Stack<Integer> stack : plates.setOfStacks) {
			System.out.println(stack.toString());
		}
	}

	List<Stack<T>> setOfStacks;
	int threshold;

	public C_StackOfPlates(int threshold) {
		setOfStacks = new ArrayList<>();
		this.threshold = threshold;
	}

	public void push(T data) {
		Stack<T> lastStack = getLastStack();
		if (lastStack != null && lastStack.size() < threshold) {
			lastStack.push(data);
		} else {
			Stack<T> temp = new Stack<>();
			temp.push(data);
			setOfStacks.add(temp);
		}
	}

	public T pop() {
		Stack<T> old = getLastStack();
		T data = old.pop();
		if (old.isEmpty()) {
			setOfStacks.remove(old);
		}
		return data;
	}

	private Stack<T> getLastStack() {
		if (setOfStacks.size() == 0)
			return null;
		return setOfStacks.get(setOfStacks.size() - 1);
	}
}
