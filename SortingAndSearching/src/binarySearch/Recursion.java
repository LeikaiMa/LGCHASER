package binarySearch;

public class Recursion {
	public int binarySearchRecursive(int[] a, int x, int low, int high) {
		if (low > high) {
			return -1;
		}

		int mid = (low + high) / 2;

		if (a[mid] < x) {
			return binarySearchRecursive(a, x, mid + 1, high);
		} else if (a[mid] > x) {
			return binarySearchRecursive(a, x, low, mid - 1);
		} else {
			return mid;
		}
		
	}
}
