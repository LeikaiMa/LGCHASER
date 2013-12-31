package testArray;
// 其实自己开始考虑复杂了，这里面看你到底最后要是>= 还是要 <= 的情况，因为不同于二分法查数，这个的while 的限制条件是low  < high 这样出来的 low 和high 都不会超过边界条件。
// 比如看第一种情况要的是 >= 的情况，那么就是在小于的时候mid  +1 那么最后的结果肯定是 >=  的最小的那个值。如果是大于的情况，那么就将high 赋值为mid ，这样把大于的范围缩小了。
// 如果是第二种情况，要求<= 的情况，那么就在大于的时候，将high 置为mid 如果是 <= 的时候就将low 置为 mid + 1 这样最后的时候，只要将low -1 或者是high  -1， 因为这个值是求他的最大的情况。要先超过之后 -1 就是 <= 的情况
// 一般都是考虑 low +1 而不是high -1  因为 /2 一般会变小。所以用low 比较保险。
// 这样出来的low 和high 都是在范围里面的，如果在外面要 +1 或者-1 就要考虑边界条件
// 如果是二分法，因为是 low <= high 但是里面会有相等的时候就返回的情况，所以出来的时候都是表示不成功的就是false
public class CeilAndFloorOfSortedArray {
	public static void main(String[] args) {
		int[] A = { 1, 2, 4, 4, 6, 6, 8 };
		int low = 0;
		int high = A.length - 1;
		int target = 6;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (A[mid] < target) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		if (A[low] != target) {
			
		}
		System.out.println("Floor: " + low + " value: " + A[low]);

		low = 0;
		high = A.length - 1;
		target = 5;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (A[mid] > target) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		// high 就是ceiling 因为ceiling 的是
		high = high -1;
		if (high < 0) {
			System.out.println("No Right Constrain");
		} else {
			System.out.println("Right Constraint: " + high + " value: " + A[high]);
		}
		
	}
}
