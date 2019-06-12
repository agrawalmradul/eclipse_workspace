

public class BinaryToString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(binaryToString(0.75));
	}


	// CTCI chapter 5 - bits maipulation - #2
	public static String binaryToString(double realNum) {
		if(realNum >= 1 || realNum <= 0)
			return "ERROR";

		StringBuilder sb = new StringBuilder("0.");

		while(realNum > 0) {
			if(sb.length() >= 32)
				return "ERROR";

			double temp = realNum *2;
			if(temp>=1) {
				sb.append("1");
				realNum = temp-1;
			}
			else {
				sb.append("0");
				realNum = temp;
			}

		}
		return sb.toString();
	}

}
