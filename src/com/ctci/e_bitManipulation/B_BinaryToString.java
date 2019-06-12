package com.ctci.e_bitManipulation;

public class B_BinaryToString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double num = 0.3575;
		System.out.println(binaryToString(num));
	}

	public static String binaryToString(double num) {
		StringBuilder sb = new StringBuilder();
		sb.append("0.");
		while (num != 1.0) {
			double temp = num * 2;
			sb.append(temp >= 1 ? 1 : 0);
			if (temp == 1) break;
			num = temp >= 1 ? temp - 1 : temp;
			if (sb.length() > 32)
				return "Error";
		}
		return sb.toString();
	}

}
