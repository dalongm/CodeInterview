package basis;

/**
 * 8 classical sort algorithms
 * 
 * @author dalongm
 */
public class Sort {
	public static void main(String[] args) {
		int[] array = { -2, -5, 4, 5, 3, -7 };
//		int[] array = {};
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
		insertSort2(array);
		for (int i : array) {
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
	 * half insert
	 * just reduce the compare times
	 * @param array
	 */
	public static void insertSort2(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			if(temp>=array[i-1]) {
				continue;
			}
			int left = 0, right = i - 1;
			while (left <= right) {
				int mid = (left + right) / 2;
				// right 为第一个小于等于temp的位置
				// temp 的位置为right+1
				if (array[mid] > temp) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			for(int j=i;j>right+1;j--) {
				array[j] = array[j-1];
			}
			array[right+1] = temp;
		}
	}
}
