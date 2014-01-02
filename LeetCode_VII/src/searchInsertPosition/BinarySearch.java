package searchInsertPosition;
// 这个是比较典型的二分法的题目，如果是有index 就求返回index，就是mid 相等的情况。
// 主要是要求第一个比他大的，用同样的方法，如果target 比mid 要，low 就比mid +1 如果比他大就 high -1
// 最后low 肯定是比target 要大最小的。
// 但是要注意的是如果是 <=  的情况，就要low 和high 都要每次改变，不然可能会出现死循环。
// 因为可能会导致相等。
// 如果是 < 就可以一边不动。
public class BinarySearch {
	public static int searchInsert(int[] A, int target) {
		if (A == null || A.length == 0) {
			return 0;
		}

		int low = 0;
		int high = A.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (A[mid] == target) {
				return mid;
			}

			if (target > A[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return low;
	}

	public static void main(String[] args) {
		int[] A = { 1, 3, 5, 6 };
		System.out.println(searchInsert(A, 5) == 2);
		System.out.println(searchInsert(A, 2) == 1);
		System.out.println(searchInsert(A, 7) == 4);
		System.out.println(searchInsert(A, 4) == 2);
		System.out.println(searchInsert(A, 0) == 0);
	}
}
