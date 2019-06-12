package codepractice.dp;

public class RecursiveMultiply {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(multiply(7,7));
		System.out.println(7<<1);
	}
	
	public static int multiply(int a, int b) {
		int smaller = a<b?a:b;
		int larger = a<b?b:a;
		return multHelp(smaller, larger);
	}
	
	public static int multHelp(int small, int big) {
		if(small==0) return 0;
		else if(small==1) return big;
		
		int s = small>>1;
		int halfProd = multHelp(s,big);
		
		if(small%2==0)
			return halfProd<<1;
		else
			return big + (halfProd<<1);
	}

}
