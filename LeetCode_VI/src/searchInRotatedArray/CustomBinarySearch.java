package searchInRotatedArray;
// 这个是更加general 的二分法，因为是有部分前面比后面大，这样就要进行比较。不能仅仅依靠target来进行比较了。
// 首先还是按照以前的做法是low 要 <= high 然后算mid ，如果mid 和那个target 相等了，那么就可以返回了。
// 下面就是要查去哪一边，首先要辨别哪边是排序的，直接看low 是不是小于等于 mid 如果是的话就说明这段排好序的，然后看target 是不是在这两个low 和mid 之间，如果确实是在中间，就在这里面找
// 如果不在中间，就说明要去另一块去找。
// 如果low 比mid 要大，说明右边是排好序的，看target 是不是在中间，如果在中间，那么就直接在这里找，如果不在就在左边找。
// 这个要点就是去找排好序的一边。
public class CustomBinarySearch {
	public int search(int[] A, int target) {
		if (A == null || A.length == 0) {
			return -1;
		}
		int low = 0;
		int high = A.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (A[mid] == target) {
				return mid;
			} 
			
			if (A[low] <= A[mid]) {
				if (target < A[mid] && target >= A[low]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {
				if (target <= A[high] && target >  A[mid]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}
}
