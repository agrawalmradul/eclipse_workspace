

import java.util.Stack;

public class SortStack {

	public static void main(String args[]) {
		Stack<Integer> input = new Stack<Integer>();
		input.push(0);
		input.push(4);
		input.push(1);
		input.push(3);
		input.push(5);
		input.push(2);
		sort2(input);
	}

	public static void sort(Stack<Integer> s) {
		Stack<Integer> temp = new Stack<Integer>();
		int a = s.pop();
		temp.push(a);
		while(!s.isEmpty()) {

			if(s.peek() > temp.peek()) {
				temp.push(s.pop());
			} 
			else {
				int b = s.pop();
				while(!temp.isEmpty()) {
					if (b < temp.peek())
						s.push(temp.pop());
					else
						break;
				}
				temp.push(b);
			}
		}

		while(!temp.isEmpty()) {
			s.push(temp.pop());
		}
	}


	public static void sort2(Stack<Integer> s) {
		Stack<Integer> temp = new Stack<Integer>();
		//int a = s.pop();
		//temp.push(a);

		while(!s.isEmpty()) {
			int a = s.pop();
			while(!temp.isEmpty() && temp.peek()>a) {
				s.push(temp.pop());
			}
			temp.push(a);
		}

		while(!temp.isEmpty()) {
			s.push(temp.pop());
		}
	}
}
