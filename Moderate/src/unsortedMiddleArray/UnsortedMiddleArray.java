package unsortedMiddleArray;
// 想要找到中间没有排序的最短的长度。
// 首先是找到左边完全排好序的 和右边完全排好序的
// 然后中间开始找到最大和最小的值，因为便于下面的统一，把左边排好序的和右边排好序的尾和头也加进来。
// 然后左右缩短，直到左边的最后一个值<=中间的最小值。然后返回+1不包括本身，这样缩短了中间的长度。同样可以缩短右边的
// 因为在for 循环之后可能没有合适的要记住最后有多出来一个进行收尾。
// 将每个小模块变成一个method 有助于梳理思路，使整个code 更加清楚。
public class UnsortedMiddleArray {
	public void findUnsortedSequence(int[] array) {
		int end_left = findEndOfLeftSubsequence(array);
		int start_right = findStartOfRightSubsequence(array);

		int min_index = end_left + 1;
		if (min_index >= array.length) {
			return;
		}

		int max_index = start_right - 1;
		for (int i = end_left; i <= start_right; i++) {
			if (array[i] < array[min_index]) {
				min_index = i;
			}
			if (array[i] > array[max_index]) {
				max_index = i;
			}
		}

		int left_index = shrinkLeft(array, min_index, end_left);
		int right_index = shrinkRight(array, max_index, start_right);
		
		System.out.println(left_index + " " + right_index);

	}

	private int shrinkRight(int[] array, int max_index, int start) {
		int comp = array[max_index];
		for (int i = start; i < array.length; i++) {
			if (array[i] >= comp) {
				return i - 1;
			}
		}
		return array.length - 1;
	}

	private int shrinkLeft(int[] array, int min_index, int start) {
		int comp = array[min_index];
		for (int i = start - 1; i >= 0; i++) {
			if (array[i] <= comp) {
				return i - 1;
			}
		}
		return 0;
	}

	private int findStartOfRightSubsequence(int[] array) {
		for (int i = array.length - 2; i >= 0; i--) {
			if (array[i] > array[i + 1]) {
				return i + 1;
			}
		}
		return 0;
	}

	private int findEndOfLeftSubsequence(int[] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1]) {
				return i - 1;
			}
		}
		return array.length - 1;
	}
}
