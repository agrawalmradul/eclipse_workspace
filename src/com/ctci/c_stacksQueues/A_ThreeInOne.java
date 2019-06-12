package com.ctci.c_stacksQueues;

/**
 * Three in One: Describe how you could use a single array to implement three
 * stacks.
 */

public class A_ThreeInOne {

	public static void main(String[] args) {
		A_ThreeInOne test = new A_ThreeInOne(12);
		test.push(1, 0);
		test.push(9, 1);
		test.push(2, 0);
		test.push(8, 1);
		test.push(3, 0);
	}

	Element[] arr;
	int topIndex;
	int[] stIndex;

	public A_ThreeInOne(int size) {
		arr = new Element[size];
		topIndex = 0;
		stIndex = new int[] { -1, -1, -1 };
	}

	public void push(int data, int stackNo) {
		if (topIndex == arr.length)
			return;

		if (stIndex[stackNo] == -1) {
			stIndex[stackNo] = topIndex;
			arr[stIndex[stackNo]] = new Element(data, -1);
			topIndex++;
		} else {
			arr[topIndex] = new Element(data, stIndex[stackNo]);
			stIndex[stackNo] = topIndex;
			topIndex++;
		}
	}

	public void pop(int stackNo) {
		// ToDo
	}

	class Element {
		int data;
		int prevIndex;

		public Element(int data, int prevIndex) {
			this.data = data;
			this.prevIndex = prevIndex;
		}
	}
}
