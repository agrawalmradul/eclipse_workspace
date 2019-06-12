package com.interviews;

public class BlackRock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String out = encode("hello");

		System.out.println(out);
		// StringBuilder b = new StringBuilder(out);

		System.out.println(decode(out));
	}

	private static String encode(String text) {
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			System.out.println(c + i);
			int a = c + i;
			c += a;
			System.out.println(c + 0);
			b.append(c);
		}
		return b.reverse().toString();
	}

	private static String decode(String text) {
		StringBuilder b = new StringBuilder();
//		StringBuilder in = new StringBuilder(text);
//		text = in.reverse().toString();
		int n = text.length();
		
		for (int i = text.length() - 1; i >= 0 ; i--) {
			char c = text.charAt(i);
			System.out.println(c - i + n-1);
			c = (char) ((c - i + n-1)/2);
			b.append(c);
		}
		return b.toString();
	}

}
