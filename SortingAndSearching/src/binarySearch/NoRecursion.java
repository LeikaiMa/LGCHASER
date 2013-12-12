package binarySearch;
// binary search 可以是while 循环，还是比较大小
// 除了binary search 应该要考虑 binary tree 还有 hash table
// array 是用的是length；
public class NoRecursion {
	public int binarySearch(int[] a, int x) {
		int low = 0;
		int high = a.length - 1;
		int mid;

		while (low <= high) {
			mid = (low + high) / 2;
			if (a[mid] < x) {
				low = mid + 1;
			} else if (a[mid] > x) {
				high = mid -1;
			} else {
				return mid;
			}
		}
		
		return -1;
	}
}
