/**
 * 
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author mradulagrawal
 *
 */
public class sortLogFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> temp = new ArrayList<String>();
//		temp.add("a1 9 2 3 1");
//		temp.add("g1 act car");
//		temp.add("zo4 4 7");
//		temp.add("ab1 off key dog");
//		temp.add("a8 act zoo");
		
//		temp.add("mi2 jog mid pet");
//		temp.add("wz3 34 54 398");
//		temp.add("a1 alps cow bar");
//		temp.add("x4 45 21 7");
		
		temp.add("t2 13 121 98");
		temp.add("r1 box ape bit");
		temp.add("b4 xi");
		temp.add("br8 eat nim did");
		temp.add("w1 has uni gry");
		temp.add("f3 52 54 31");


		List<String> output = sortFile(5, temp);
		System.out.println(output);

	}
	
	public static List<String> sortFile(int logFileSize, List<String> logLines){
		List<String> result = new ArrayList<String>();
		List<String> numericLog = new ArrayList<String>();
		List<String> lexLog = new ArrayList<String>();
		
		for(String line : logLines) {
			String firstBit = line.substring(line.indexOf(" ")+1, line.indexOf(" ", line.indexOf(" ")+1));
			if(isNumeric(firstBit)) {
				numericLog.add(line);
			} else {
				line = swapLastWord(line);
				lexLog.add(line);
			}
		}
		
		Collections.sort(lexLog);
		for(String line : lexLog) {
			line = swapFirstWord(line);
			result.add(line);
		}
		
		for(String line : numericLog) {
			result.add(line);
		}
		
		return result;
	}
	
	private static String swapLastWord(String strLine) {
		int index = strLine.indexOf(" ");
		String newString = strLine.substring(index+1) + " " + strLine.substring(0, index);
		return newString;
	}
	
	private static String swapFirstWord(String strLine) {
		int index = strLine.lastIndexOf(" ");
		String newString = strLine.substring(index+1) + " " + strLine.substring(0, index);
		return newString;
	}
	
	
	private static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    Integer.parseInt(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}

}
