/**
 * 
 */

/**
 * @author mradulagrawal
 *
 */
public class SortAlgos {

	public static int[] arr;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		arr = new int[] { 7, 6, 5, 4, 3, 2, 1, 0 };
		// int[] arr = new int[]{77,99,44,55,22,88,11,00,21};

		bubbleSort();
		// selectionSort();
		// insertionSort();
		// int arr2[] = mergeSort(arr);
		// quickSort(arr,0,arr.length-1);
		for (int i = 0; i < 0; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	/**
	 * bubble sort
	 */
	public static void bubbleSort() {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * selection sort
	 */
	public static void selectionSort() {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
	}

	/**
	 * insertion sort
	 */
	public static void insertionSort() {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int min = i;
			while (min > 0 && (arr[min] < arr[min - 1])) {
				int temp = arr[min];
				arr[min] = arr[min - 1];
				arr[min - 1] = temp;
				min--;
			}
		}
	}

	/*
	 * merge sort algo
	 */
	public static int[] mergeSort(int[] arr) {
		int sizeA = arr.length;
		if (sizeA == 1)
			return arr;
		int half = sizeA / 2;
		int[] leftArr = new int[half];
		int[] rightArr = new int[sizeA - half];
		for (int i = 0; i < half; i++) {
			leftArr[i] = arr[i];
		}
		for (int j = 0; j < sizeA - half; j++) {
			rightArr[j] = arr[half + j];
		}
		leftArr = mergeSort(leftArr);
		rightArr = mergeSort(rightArr);
		return mergeArrays(leftArr, rightArr);
	}

	/**
	 * merge sort helper method;
	 */
	private static int[] mergeArrays(int[] a, int[] b) {
		int sizeA = a.length;
		int sizeB = b.length;
		int[] result = new int[sizeA + sizeB];

		int i = 0;
		int j = 0;
		int k = 0;
		while (i < sizeA && j < sizeB) {
			if (a[i] < b[j]) {
				result[k++] = a[i++];
			} else {
				result[k++] = b[j++];
			}
		}

		while (i < sizeA) {
			result[k++] = a[i++];
		}
		while (j < sizeB) {
			result[k++] = b[j++];
		}

		return result;
	}

	/*
	 * Quick sort helper method
	 */
	private static int patitionIndex(int[] A, int start, int end) {
		int partIndex = start;
		int pivot = A[end];
		for (int i = start; i < end; i++) {
			if (A[i] <= pivot) {
				int temp = A[partIndex];
				A[partIndex] = A[i];
				A[i] = temp;
				partIndex++;
			}
		}
		int temp = A[partIndex];
		A[partIndex] = A[end];
		A[end] = temp;
		return partIndex;
	}

	/*
	 * Quick Sort
	 */
	public static void quickSort(int[] A, int start, int end) {
		if (start < end) {
			int partIndex = patitionIndex(A, start, end);
			quickSort(A, start, partIndex - 1);
			quickSort(A, partIndex + 1, end);
		}
	}
}
