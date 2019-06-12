package com.interviews;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.PriorityQueue;

public class LoanSnap {

	public static void main(String[] args) {

		// creating an input having 6 Element objects
		List<Element> input = new ArrayList<>();
		input.add(new Element(0, "op"));
		input.add(new Element(1, "iii"));
		input.add(new Element(2, "t"));
		input.add(new Element(0, "hello"));
		input.add(new Element(1, "world"));
		input.add(new Element(3, "everyone"));

		// calling the function
		String strFinalOut = generateString(input, 6);

		// printing the result
		System.out.println(strFinalOut);
	}

	/**
	 * This method does what is required from the problem statement
	 * 
	 * @param elements
	 *            is a list of Element object
	 * @param iNumElements
	 *            size of the list (based on the assumption)
	 * @return a String contains expected output
	 */
	public static String generateString(List<Element> elements, int iNumElements) {
		// creating StringBuilder object for the output
		// not using String, because it will create new array every time
		// we add to the string
		StringBuilder strOutput = null;

		// Using a priority queue that will add the strings in
		// Ascending order
		PriorityQueue<Element> pQueueAsc = null;

		try {
			// Creating a comparator object to compare the _x (rank of an Element object)
			Comparator<Element> oComp = Comparator.comparing((Element e) -> e._x);

			// Exception handling for following cases
			// 1. When list size is not equal to iNumElements
			// 2. When list size is not even
			if (iNumElements != elements.size())
				throw new InputMismatchException("Size of elements list is not equal to iNumElements!");
			else if (iNumElements % 2 != 0)
				throw new InputMismatchException("Odd number of elements in the list. Only even is accepted!");
			else
				// calling a private method to enqueue the data in the ascending priority queue
				pQueueAsc = enqueueListData(elements, iNumElements, oComp);

			// Initializing the String builder for the output
			strOutput = new StringBuilder();

			// getting _s (String) values from the priority queues
			// and appending to the output
			while (!pQueueAsc.isEmpty()) {
				strOutput.append(pQueueAsc.poll()._s);
				strOutput.append(" ");
			}

			// returning the string output
			return strOutput.toString();
		} catch (InputMismatchException e) {
			System.err.println("InputMismatchException: " + e);
			return "";
		} finally {
			// clearing the variables for garbage collection
			strOutput = null;
			pQueueAsc = null;
		}
	}

	private static PriorityQueue<Element> enqueueListData(List<Element> elements, int iNumElements,
			Comparator<Element> comp) {

		PriorityQueue<Element> pQueueAsc = new PriorityQueue<Element>(comp);

		// Traversing through the input elements
		// replacing the string to "*" for first half of the elements
		// and queuing the elements to the priority queue
		for (int listItem = 0; listItem < iNumElements; listItem++) {
			Element currEl = elements.get(listItem);
			String currEl_s = currEl._s;
			int currEl_x = currEl._x;

			if (currEl_x < 0 || currEl_x > 10)
				throw new InputMismatchException("Input list size is out of the accepted range, which is [0,10].");
			else if (currEl_s.isEmpty() || currEl_s.length() < 1 || currEl_s.length() > 100)
				throw new InputMismatchException(
						"Size of '_s' String is more than the supported range, which is [1,100].");
			else {
				if (listItem < iNumElements / 2) {
					currEl._s = "*";
				}
				pQueueAsc.offer(currEl);
			}
		}
		return pQueueAsc;
	}

	// Creating a class for an element with two fields
	// _x and _s
	private static class Element {
		private int _x;
		private String _s;

		private Element(int _x, String _s) {
			this._x = _x;
			this._s = _s;
		}
	}
}
