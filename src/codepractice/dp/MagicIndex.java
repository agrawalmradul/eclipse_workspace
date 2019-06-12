package codepractice.dp;

public class MagicIndex {
//arr[i] = i in an sorted array
	public static void main(String[] args) {
		int[] arr = new int[] {-1,2,2,8};
		System.out.println(findMagic(arr));
	}

	//values are distinct
	public static int findMagic(int[] arr) {
		int start = 0;
		int end = arr.length-1;
		while(start<=end) {
			int mid = (start + end)/2;
			if(arr[mid] == mid)
				return mid;
			else if(arr[mid] < mid)
				start = mid +1;
			else
				end = mid-1;
		}
		return -1;
	}
	
	//values are not distinct
	//left index
	//right index
}
