

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.net.Inet4Address;

public class NasaTest {

	public static void main(String[] args) {

		System.out.println("192.128.1.17" + " is " + checkIP("192.128.1.17"));
		System.out.println("2001:0db8:85a3:0000:0000:8a2e:0370:7334" + " is " + checkIP("2001:0db8:85a3:0000:0000:8a2e:0370:7334"));
		System.out.println("256.256.256.256" + " is " + checkIP("256.256.256.256"));

		//before handling bad inputs
		System.out.println(stringToInt("-25"));
		System.out.println(stringToInt("-2a5")); //wrong output 
		System.out.println(stringToInt("-91283472332")); // wrong output
		System.out.println(stringToInt(" 91283472332")); // wrong output

		//after handling bad inputs
		System.out.println(stringToInt2("-25"));
		System.out.println(stringToInt2("-2a5")); // output = -2
		System.out.println(stringToInt2("-91283472332")); //output = Integer.MIN_VALUE
		System.out.println(stringToInt2("91283472332")); //output = Integer.MAX_VALUE

		//before handling bad inputs
		System.out.println(stringToFloat("12.55"));
		System.out.println(stringToFloat("12s123.123"));
		System.out.println(stringToFloat("  -12112.4431"));
		
		//after handling bad inputs
		System.out.println(stringToFloat2("12.55"));
		System.out.println(stringToFloat2("12s123.123"));
		System.out.println(stringToFloat2("  -12112.4431"));
	}

	//**************************************************************************//
	//******************************* Question 1 *******************************//
	//**************************************************************************//

	/**
	 * Given an input string determine if the provided IP address conforms to IPv4/IPv6 or neither. IPv6 has the form 2001:0db8:85a3:0000:0000:8a2e:0370:7334
	 */
	public static String checkIP(String strIPaddress) {
		//I would use an object of InetAddress and check if it is an instance of IPv4 or IPv6
		//otherwise I would return invalid if it throws exception
		InetAddress address;
		try {
			address = InetAddress.getByName(strIPaddress);
			if (address instanceof Inet6Address) {
				return "IPv6";
			} else if (address instanceof Inet4Address) {
				return "IPv4";
			}
		} catch (UnknownHostException e) {
			return "invalid";
		}
		return "";
	}

	//**************************************************************************//
	//******************************* Question 2 *******************************//
	//**************************************************************************//

	/*	Write a method, stringToInt, that takes a string of digit characters and returns the integer
		corresponding to the input string, base 10. (Do not use any internal libraries that offer
		out-of-the-box conversion such as atoi, atof, etc.) 
	 */

	public static int stringToInt(String strInt) {
		// for this problem I am assuming that input only has digits as characters,
		// and does not have any other characters (e.g. alphabets, special characters, spaces)
		// I am assuming that input could be negative so starting character could be '-' (e.g. "-20" outputs = -20)

		int index = 0;
		int sign = 1;
		int total = 0;

		if(strInt.length() == 0) 
			return 0;

		//check for sign
		if(strInt.charAt(index) == '+' || strInt.charAt(index) == '-'){
			sign = strInt.charAt(index) == '+' ? 1 : -1;
			index++;
		}

		//other digits
		while(index < strInt.length()){
			int digit = strInt.charAt(index) - '0';
			total = (10 * total) + digit;
			index ++;
		}

		//multiplying it with sign
		total *= sign;

		return total;
	}
	/**
	 * Explain in English how you would check for and handle very large numbers.
	 * If the input is sufficiently large, we need to check for overflow or underflow
	 * To handle it, we need to use a larger data type and if overflow or underflow occurs, return the min, max value
	 * explained in part 4
	 */
	
	//**************************************************************************//
	//******************************* Question 3 *******************************//
	//**************************************************************************//

	/** Using the stringToInt method you wrote in Q2, write a function, stringToFloat to handle decimal input.
			(For example)
			Input: “12.34”
			Output: 12.34
	 */
	public static float stringToFloat(String strDouble) {
		// we can implement this using stringToInt function by calling it two times
		// splitting the input by a decimal point and sending it separately  to stringToInt
		// I will explain this using an example input "12.55"

		// initializing a float variable
		float result;

		//decimalIndex is the index of decimal point (2 here)
		int decimalIndex = strDouble.indexOf('.');

		if(decimalIndex != -1) { //if decimal point exists
			//Integer part of the input will be "12"
			String intString = strDouble.substring(0,decimalIndex);
			//Fractional part of the input will be "55"
			String fracString = strDouble.substring(decimalIndex+1);

			//result = integer + fractional/(10^length of fractional part)
			//result = 12 + 55/100 = 12.55
			result = (float) (stringToInt(intString) + stringToInt(fracString)/Math.pow(10, fracString.length()));
		}
		else { //if decimal point doesn't exist than its a normal stringToInt problem
			result = (float)stringToInt(strDouble);
		}
		return result;
	}
	/**
	 * Explain in English how you would check for and handle very large numbers.
	 * Since we are using stringToInt as a helper function, we need cannot handle overflow or underflow
	 * Especially, if the input contains something like "1.123124E20"
	 * We need to redesin the function of split it based 'E' as well
	 */

	//**************************************************************************//
	//******************************* Question 4 *******************************//
	//**************************************************************************//

	//*************************************************************************//
	//************************* HANDLING BAD INPUTS ***************************//
	//*************************************************************************//

	/**
	 * 1. (Overflow) The String input could contain a value which is greater than the maximum value an int data type could handle (e.g. 91283472332)
	 * 		Handling: I will initialize the result with long and check if the value if greater than the int max.
	 * 		If yes, I will return the max value of the integer (2147483647)
	 * 
	 * 2. (Underflow) The String input could contain a value which is smaller than the minimum value an int data type could handle (e.g. -91283472332)
	 * 		Handling: I will initialize the result with long and check if the value if smaller than the int min.
	 * 		If yes, I will return the min value of the integer (-2147483648)
	 * 
	 * 2. (Alphabets, special characters) The String input could contain a non number character
	 * 		Handling: In this case, I am returning the first initial numbers and breaking the loop as soon as I see a bad character
	 * 
	 * 3. The String input may not start with a number or a sign(+ or -)
	 * 		Handling: In this case, the loop will break and return the initialized value of 0
	 * 
	 * 4. (WhiteSpaces) The String input may contains some spaces in the staring or at the end
	 * 		Handling: I can trim the input string before use
	 */

	public static int stringToInt2(String strInt) {
		// for this problem I am assuming that input only has digits as characters,
		// and does not have any other characters (e.g. alphabets, special characters, spaces)
		// I am assuming that input could be negative so starting character could be '-' (e.g. "-20" outputs = -20)

		int index = 0;
		int sign = 1;
		//initializing as long to handle exception
		long total = 0;

		//(Handling exception #4)
		strInt = strInt.trim();

		if(strInt.length() == 0)
			return 0;

		//check for sign
		if(strInt.charAt(index) == '+' || strInt.charAt(index) == '-'){
			sign = strInt.charAt(index) == '+' ? 1 : -1;
			index++;
		}

		//other digits
		while(index < strInt.length()){
			int digit = strInt.charAt(index) - '0';
			//(Handling exception #3 and #4) all other characters (alphabets or special character)
			if(digit<0 || digit>9)
				break;
			total = (10 * total) + digit;
			index ++;
		}

		//multiplying it with sign
		total *= sign;

		// (Handling exception #1 and #2) if the input value exceed the max or min value of int data type
		if(total > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		else if(total < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		return (int)total;
	}

	/**
	 * Similarly I can use stringToInt2 which will handle the bad inputs for the first function mentioned above
	 */
	public static float stringToFloat2(String strDouble) {
		// we can implement this using stringToInt function by calling it two times
		// splitting the input by a decimal point and sending it separately  to stringToInt
		// I will explain this using an example input "12.55"

		// initializing a float variable
		float result;

		//decimalIndex is the index of decimal point (2 here)
		int decimalIndex = strDouble.indexOf('.');

		if(decimalIndex != -1) { //if decimal point exists
			//Integer part of the input will be "12"
			String intString = strDouble.substring(0,decimalIndex);
			//Fractional part of the input will be "55"
			String fracString = strDouble.substring(decimalIndex+1);

			//result = integer + fractional/(10^length of fractional part)
			//result = 12 + 55/100 = 12.55
			result = (float) (stringToInt2(intString) + stringToInt2(fracString)/Math.pow(10, fracString.length()));
		}
		else { //if decimal point doesn't exist than its a normal stringToInt problem
			result = (float)stringToInt(strDouble);
		}
		return result;
	}

}
