package searchForRange;
// 因为是要满足整体的复杂度是在log n 里面，所以可以想到前后两个边界条件都是用二分法来求得，如果只是用一个二分法来进行，然后在前后找边界这样的复杂度会在最坏的情况下变成 O(n)
// 这里要进行求边界的运算，而且是左右边界就要更新一下二分法的算法，二分法如果不用recursive 的方法，是用一个while 循环进行。 lower 是0 upper 是最后一个
// 知道lower 不小于 upper 的时候
// 求左边界的时候，如果中间值小于target 说明在右半部分，然后lower 变成upper +1
// 如果是 大于等于，包括等于是因为要求最左边的target 所以这个时候就让upper 变成mid， 因为包括了相等的情况所以 不是mid - 1
// 等到相等的时候出来或者lower 就根本不存在，因为也是到了相等才出来。这是lower 就是最左边的，然后如果不是就不存在这个值。可以直接进行返回
// 求右边界的时候，因为尽量是要向左边靠，是如果中间值大于target 说明在左边，让upper 变成mid ，不变成mid - 1 是为了防止过度向左。
// 如果是小于等于，因为是在右边，所以lower 要等于mid + 1， +1 是为了尽量向右，然后最终肯定会超过一个，因为前面已经保证至少存在这个数，所以 肯定是多出一位，所以让他 -1 就能成功。
import java.util.Arrays;

public class TwoBinarySearch {
	public static int[] searchRange(int[] A, int target) {
		int[] result = new int[2];
		result[0] = -1;
		result[1] = -1;
		if (A == null || A.length == 0) {
			return result;
		}
		int lower = 0;
		int upper = A.length - 1;

		while (lower < upper) {
			int mid = lower + (upper - lower) / 2;
			if (A[mid] < target) {
				lower = mid + 1;
			} else {
				upper = mid;
			}
		}

		if (A[lower] != target) {
			return result;
		} else {
			result[0] = lower;
		}

		upper = A.length - 1;
		while (lower < upper) {
			int mid = lower + (upper - lower) / 2;
			if (A[mid] > target) {
				upper = mid;
			} else {
				lower = mid + 1;
			}
		}

		result[1] = upper - 1;
		return result;
	}

	public static void main(String[] args) {
		int[] A = { 5, 7, 7, 8, 8, 10 };
		int target = 8;
		System.out.println(Arrays.toString(searchRange(A, target)));
	}
}
