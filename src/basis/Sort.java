package basis;

import java.util.Arrays;
import java.util.Random;

/**
 * 8 classical sort algorithms
 * 
 * @author dalongm
 */
public class Sort {
	public static void main(String[] args) {
		int[] array = { -2, -5, 4, 5, 3, -7 };
		array = new int[1000];

		Random r = new Random();
		Arrays.parallelSetAll(array, (i)->(int)(r.nextDouble()* 10000));
		int[] array1 = array.clone();
		int[] array2 = array.clone();
		int[] array3 = array.clone();
		int[] array4 = array.clone();

		long old;
		long now;
		
		old = System.currentTimeMillis();
		insertSort(array1);
		now = System.currentTimeMillis();
		System.out.println(array.length + " elements, direct insert costs:" + (now - old));

//		old = System.currentTimeMillis();
//		insertSort2(array2);
//		now = System.currentTimeMillis();
//		System.out.println(array.length + " elements, half insert costs:" + (now - old));

		old = System.currentTimeMillis();
		shellSort(array3);
		now = System.currentTimeMillis();
		System.out.println(array.length + " elements, shell sort costs:" + (now - old));

//		old = System.currentTimeMillis();
//		bubbleSort(array4);
//		now = System.currentTimeMillis();
//		System.out.println(array.length + " elements, bubble sort costs:" + (now - old));
//		
		int[] array5 = array.clone();
		old = System.currentTimeMillis();
		quickSort(array5, 0, array5.length - 1);
		now = System.currentTimeMillis();
		System.out.println(array.length + " elements, quick sort costs:" + (now - old));
		for (int i : array5) {
			System.out.print(i + " ");
		}
	}

	/**
	 * direct insert
	 * 
	 * @param array
	 */
	public static void insertSort(int[] array) {

		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			if (temp < array[i - 1]) {
				int j = i - 1;
				for (; j >= 0; j--) {
					if (array[j] < temp) {
						array[j + 1] = temp;
						break;
					} else {
						array[j + 1] = array[j];
					}
				}
				if (j == -1) {
					array[0] = temp;
				}
			}
		}
	}

	/**
	 * half insert just reduce the compare times to O(nlog_2 n)
	 * 
	 * @param array
	 */
	public static void insertSort2(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			if (temp >= array[i - 1]) {
				continue;
			}
			int left = 0, right = i - 1;
			while (left <= right) {
				int mid = (left + right) / 2;
				// right the first less than or equal 'temp' position
				// 'temp' situate at right + 1
				if (array[mid] > temp) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			for (int j = i; j > right + 1; j--) {
				array[j] = array[j - 1];
			}
			array[right + 1] = temp;
		}
	}

	/**
	 * shell sort
	 * 
	 * @param array
	 */
	public static void shellSort(int[] array) {
		for (int dk = array.length / 2; dk >= 1; dk = dk / 2) {
			for (int i = dk; i < array.length; i++) {
				if (array[i] < array[i - dk]) {
					int temp = array[i];
					int j;
					for (j = i - dk; j >= 0; j -= dk) {
						if (array[j] > temp) {
							array[j + dk] = array[j];
						} else {
							array[j + dk] = temp;
							break;
						}
					}
					if (j < 0) {
						array[j + dk] = temp;
					}
				}
			}
		}
	}

	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			boolean isChange = false;
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					isChange = true;
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
			if (!isChange) {
				break;
			}
		}
	}

	/**
	 * @param array
	 * @param low
	 * @param high
	 */
	public static void quickSort(int[] array, int low, int high) {
		if (low < high) {
			int position = partition(array, low, high);
			quickSort(array, low, position - 1);
			quickSort(array, position + 1, high);
		}
	}

	private static int partition(int[] array, int low, int high) {
		int index = (low + high) / 2;
		int temp = array[index];
		array[index] = array[low];

		while (low < high) {
			while (low < high && array[high] >= temp) {
				high--;
			}
			array[low] = array[high];
			while (low < high && array[low] <= temp) {
				low++;
			}
			array[high] = array[low];
		}
		array[low] = temp;
		return low;
	}
}
