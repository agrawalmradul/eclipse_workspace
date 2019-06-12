

import java.util.Arrays;

/**
 * 1. front car can choose to go to any station, if all station has at least D fuel, it chooses the lowest of x,y,z
 * 2. If all available dispenser has less than D liters, it will wait for remaining dispenser to clear
 * 3. if all dispenser has less than D, return -1 
 * 4. return total waiting time
 * 5. each liter takes one second to fill
 */

//x = 7, y = 11, z = 3
// a = [2,8,4,3,2] = 5,3,3 > 1,3,0
//timer = [0,0,0]
// fuel = [7,11,3]
//so far = [0,0,2,2,8]
public class FuelDispenser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[] {2,8,4,3,2};
		int x = 7, y = 11, z = 3;
		//System.out.println(getMin(new int[] {6,8,0}));
		System.out.println(solution(A,x,y,z));

	}

	public static int solution(int[] A, int X, int Y, int Z) {
		// write your code in Java SE 8
		
		if(A == null || A.length == 0) return -1; 

		int[] waitTime = new int[A.length];
		Arrays.fill(waitTime, -1);

		int[] fuels = new int[] {X, Y, Z};

		// 0 - x, 1 - y, 2 - z
		int[] timer = new int[3];
		int start=0;
		for(int i = 0; i < A.length; i++) {
			start = getMin(timer);
			int counter=0;
			int[] tempTimer = Arrays.copyOf(timer, timer.length);
			while(fuels[start]<A[i]) {
				tempTimer[start] = Integer.MAX_VALUE;
				start = getMin(tempTimer);
				counter++;
				if(counter == 4) return -1;
			}

			fuels[start] -= A[i];
			if(i==0) 
				waitTime[i] = timer[start];
			else
				waitTime[i] = Math.max(waitTime[i-1],timer[start]);
			timer[start] += A[i];
		}
		return waitTime[A.length-1];
	}

	public static int getMin(int[] timer) {
		int min = 0;

		for(int i = 1; i< timer.length; i++) {
			if(timer[i]<timer[min]) min = i;
		}
		return min;
	}

//	public static int getMin(int[] timer, int greaterThan) {
//		int min = Integer.MAX_VALUE;
//		int minIndex = 0;
//		for (int i = 0; i<timer.length; i++) {
//			if(timer[i]>greaterThan && timer[i] < min) {
//				min = timer[i];
//				minIndex = i;
//			}
//		}
//		return minIndex;
//	}

}