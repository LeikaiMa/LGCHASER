package findKthSmallest;

import java.util.Random;

public class LargestKElementsSum {
	public int largestKSum(int[] num, int k) {
		if (num.length < k) {
			return Integer.MIN_VALUE;
		}

		return largestKSum(num, 0, num.length - 1, k - 1);
	}

	// This method is to check the index of pivot is already at k - 1
	// if it is less than k - 1, do the same thing in the first half.
	// If it is greater than k - 1, do it in the second half.
	private int largestKSum(int[] num, int first, int last, int k) {
		if (first <= last) {
			int pivot = partition(num, first, last);
			if (pivot == k) {
				int sum = 0;
				for (int i = 0; i < k; i++) {
					sum += num[i];
				}
				return sum;
			} else if (pivot > k) {
				return largestKSum(num, first, pivot - 1, k);
			} else {
				return largestKSum(num, pivot + 1, last, k);
			}

		}
		return Integer.MIN_VALUE;
	}

	// This method is to partition the array into three parts and return the
	// index of pivot.
	private int partition(int[] num, int first, int last) {
		int pivot = first + new Random().nextInt(last - first + 1);
		pivot = findPivot(num, first, last, 5);
		swap(num, last, pivot);

		for (int i = first; i < last; i++) {
			if (num[i] > num[last]) {
				swap(num, i, first);
				first++;
			}
		}

		swap(num, first, last);
		return first;
	}

	// This method is get the better pivot. But the return value is just the
	// pivot and it is already in the first one of the array
	private int findPivot(int[] num, int start, int end, int c) {
		int n = end - start + 1;

		while (n > 1) {
			int position = start;

			for (int s = start; s < n; s += c) {
				int e = start + c;
				e = Math.min(end, n);

				for (int i = s; i < e - 1; i++) {
					for (int j = i + 1; j < e; j++) {
						if (num[j] > num[i]) {
							int tmp = num[i];
							num[i] = num[j];
							num[j] = tmp;
						}
					}
				}

				int mid = s + (e - s) / 2;
				num[position++] = num[mid];
			}

			n = position - start;
		}

		return num[start];
	}

	// simple swap method
	private void swap(int[] num, int first, int last) {
		int tmp = num[first];
		num[first] = num[last];
		num[last] = tmp;
	}
}
