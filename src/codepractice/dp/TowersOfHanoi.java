package codepractice.dp;

import java.util.Stack;

public class TowersOfHanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> source = new Stack<>();
		Stack<Integer> buffer = new Stack<>();
		Stack<Integer> destination = new Stack<>();
		
		int n = 6;
		for(int i = n-1;i>=0;i--)
			source.push(i);
		
		System.out.println(source);
		moveDisks(n, source, destination, buffer);
		System.out.println(destination);
	}
	
	public static void moveDisks(int n, Stack<Integer> source, Stack<Integer> destination, Stack<Integer> buffer) {
		if(n<=0) return;
		moveDisks(n-1, source, buffer, destination);
		destination.push(source.pop());
		moveDisks(n-1, buffer, destination, source);
	}

}
