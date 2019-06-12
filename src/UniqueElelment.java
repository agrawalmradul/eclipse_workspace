import java.util.Arrays;

public class UniqueElelment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] in = {0,2,3,4,5,0,3,4,0,5,6};
//		int out=in[0];
//		for(int i=1; i<in.length; i++) {
//			out ^= in[i];
//		}
//		System.out.println(out);
		
		System.out.println(Arrays.toString(moveZeros(in)));
	}
	
	class Node{
		int val;
		Node left;
		Node right;
		Node (int v){
			this.val = v;
		}
	}

	
	public static int[] moveZeros(int[] input) {
		int i = 0; 
		int j = 0;
		while(i<input.length) {
			if(input[i] == 0)
				i++;
			else
				input[j++] = input[i++];
		}
		
		while(j<input.length) {
			input[j++] =0;
		}
		return input;
	}
	
}
