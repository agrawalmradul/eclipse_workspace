package com.interviews;

//one with ankush
public class Ebay_1 {

	class Link {
		private int iData;
		public Link next;

		public Link(int iData) {
			this.iData = iData;
			this.next = null;
		}

		public int getKey() {
			return iData;
		}

		public void displayLink() {
			System.out.println(iData + " ");
		}
	}

	class SortedList {
		private Link first;

		public SortedList() {
			first = null;
		}

		public void insert(Link theLink) // insert link, in order
		{
			int key = theLink.getKey();
			Link previous = null; // start at first
			Link current = first;
			// until end of list,
			while (current != null && key > current.getKey()) { // or current > key,
				previous = current;
				current = current.next; // go to next item
			}
			if (previous == null) // if beginning of list,
				first = theLink; // first --> new link
			else // not at beginning,
				previous.next = theLink; // prev --> new link
			theLink.next = current; // new link --> current
		} // end insert()
			// -------------------------------------------------------------

		public void delete(int key) // delete link
		{ // (assumes non-empty list)
			Link previous = null; // start at first
			Link current = first;
			// until end of list,
			while( current != null && key != current.getKey() )
			{ // or key == current,
				previous = current;
				current = current.next; // go to next link
			}
			// disconnect link
			if(previous==null) // if beginning of list
				first = first.next; // delete first link
			else // not at beginning
				previous.next = current.next; // delete current link
		} // end delete()
			// -------------------------------------------------------------

		public Link find(int key) // find link
		{
			Link current = first; // start at first
			// until end of list,
			while (current != null && current.getKey() <= key) { // or key too small,
				if (current.getKey() == key) // is this the link?
					return current; // found it, return link
				current = current.next; // go to next item
			}
			return null; // didn’t find it
		} // end find()
			// -------------------------------------------------------------

		public void displayList()
		{
			System.out.print("List (first-->last): ");
			Link current = first; // start at beginning of list
			while(current != null) // until end of list,
			{
				current.displayLink(); // print data
				current = current.next; // move to next link
			}
			System.out.println("");
		}
	} // end class SortedList

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
