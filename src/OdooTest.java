

import java.util.ArrayList;
import java.util.Random;

public class OdooTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//openSource(99);
		//System.out.println(rand5());
		System.out.println(rand7());
		ArrayList<String> list = new ArrayList<>();
		list.add("12");
		list.add("abs");
		list.add("45");
		list.add("aaa");
		list.add("oia");
		//System.out.println(sumStrings(list));
		//System.out.println(sumStringRec(list, list.size()));
		//		String abc = "odooa adfava asd #rules";
		//		abc = abc.replaceAll("/^.*?\\bodoo\\b.*?\\b/#rules\\b.*?$/m", "");
		//		System.out.println(abc);

	}


	//*********************************************************************************//
	//*********************************************************************************//
	/**
	 * Test 1: Any language
		Write a program that outputs sequentially the integers from 1 to 99 but on some conditions prints a string instead:
		- when the integer is a multiple of 3 print “Open” instead of the number,
		- when it is a multiple of 7 print “Source” instead of the number,
		- when it is a multiple of both 3 and 7 print “OpenSource” instead of the number.
	 */
	public static void openSource(int n) {
		int i = 1, j = 1, k = 1;
		while(i<=n) {
			if(j == 3 && k == 7) {
				System.out.println("OpenSource");
				j = 1;
				k = 1;
			}
			else if(j==3) {
				System.out.println("Open");
				j = 1;
				k++;
			}
			else if(k==7) {
				System.out.println("Source");
				k = 1;
				j++;
			}
			else {
				System.out.println(i);
				j++;
				k++;
			}
			i++;
		}
	}
//$('.row')[5].setAttribute("id","rev")
//	$('.row')[5].setAttribute("id","rev");
//	var temp = $('#rev').children()[0];
//	$('#rev').children()[0].remove();
//	ul = $('#rev'); // your parent ul element
//	ul.children().each(function(i,li){ul.prepend(li)})
//	$('#rev').prepend(temp)
	//*********************************************************************************//
	//*********************************************************************************//
	/**
	 * Test 2: Any language
		Expand a random range from 0-5 to 0-7. Given a function rand5() that returns a
		random float in the range [0,5] with a uniform distribution, write a function
		that returns a random float in the range [0,7] using only rand5() and keeping a uniform distribution.
	 */
	private static float rand5() {
		Random rand = new Random();
		float result = rand.nextFloat();
		//System.out.println(result*5);
		return result*5;
	}
	private static float rand35() {
		return 5*rand5() + 2*rand5() +rand5();
	}

	public static float rand7() {
		float r = Float.MAX_VALUE;
		
		  while (r > 7)
			  //System.out.println(r);
			  r = rand35()/5;
		  return r;
	}

	//*********************************************************************************//
	//*********************************************************************************//
	/**
	 * Test 3: Any language
		Write a function that takes a list of strings and returns the sum of the list 
		items that represents an integer (skipping the other items)
	 */
	public static int sumStrings(ArrayList<String> list) {
		int result = 0;
		for(String item : list) {
			try {
				result += Integer.parseInt(item);
			} catch (NumberFormatException e) {
				continue;
			}
		}
		return result;
	}

	//*********************************************************************************//
	//*********************************************************************************//
	/**
	 * Test 4: Any language
		Write a recursive version of the previous function
		(or an iterative version if you already did a recursive version).
	 */
	public static int sumStringRec(ArrayList<String> list, int size) {
		if(size == 0) return 0;
		try {
			return Integer.parseInt(list.get(size-1)) + sumStringRec(list, size-1);
		} catch (NumberFormatException e) {
			return sumStringRec(list, size-1);
		}
	}
}
