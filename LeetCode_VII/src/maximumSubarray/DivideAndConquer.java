package maximumSubarray;
// 如果用分治的方法就要考虑是不是二分法，
// 二分法就是看里面三种情况，那种最大，一种是完全左边的，一种是完全右边的，还有一种横跨的。
// 左边和右边也可以再进行递归。base case 是没有这个sequence，就是左边大于右边这个时候返回的是integer 的最小值。
// 找中间的情况是看从中间往左边，最大的是多少，从中间往右边，最大的是多少。 然后加上中间的。
// 不过要注意的是统计的时候起始为0 而不是最小，因为这边最坏的情况是左边什么都不取，这个时候就是为0 同理右边一样。
// 最后将左中右进行相加，和之前左边 右边递归回来的取最大值返回。
public class DivideAndConquer {
	public static int maxSubArray(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		return maxSubArrayHelper(A, 0, A.length - 1, max);
	}

	private static int maxSubArrayHelper(int[] A, int start, int end, int max) {
		if (start > end) {
			return Integer.MIN_VALUE;
		}

		int mid = start + (end - start) / 2;
		int maxLeft = maxSubArrayHelper(A, start, mid - 1, max);
		int maxRight = maxSubArrayHelper(A, mid + 1, end, max);

		max = Math.max(max, Math.max(maxLeft, maxRight));

		int sum = 0, maxl = 0, maxr = 0;

		for (int i = mid - 1; i >= start; i--) {
			sum += A[i];
			maxl = Math.max(maxl, sum);
		}
		sum = 0;
		for (int i = mid + 1; i <= end; i++) {
			sum += A[i];
			maxr = Math.max(maxr, sum);
		}

		max = Math.max(max, maxl + A[mid] + maxr);
		return max;
	}
	
	public static void main(String[] args) {
		int[] A = { 1, 2, -1, -2, 2, 1, -2, 1, 4, -5, 4 };
		
		System.out.println(maxSubArray(A));
		int[] B = {-5, -1};
		System.out.println(maxSubArray(B));
	}
}
