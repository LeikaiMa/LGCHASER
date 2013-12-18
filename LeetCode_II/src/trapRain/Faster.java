package trapRain;
// 集水问题，是要看左边和右边都有比自己高，自己算低点就可以集水。
// 从左往右记录在自己左边最高的是多少，可以作为左边界。
// 从右往左记录右边最高的是多少，可以作为右边界。
// 集水的高度是左边界和右边界的小值。然后和本身做差，这样能够得到集水的多少。
// 这样做的好处是左右一共两边就可以，O（n） 的复杂度，空间上也只要一个一维数组就可以了
// 需要注意的是两个边界条件，可以开始的时候就用最两边做为max 这样能够避免处理边界。可以减少code 的复杂度。
public class Faster {
	public static int trap(int[] A) {
		if (A.length <= 1) {
			return 0;
		}
		int total = 0;
		int max = A[0];
		int[] leftMost = new int[A.length];
		for (int i = 1; i < A.length; i++) {
			leftMost[i] = max;
			max = Math.max(A[i], max);
		}
		max = A[A.length - 1];
		for (int i = A.length - 2; i > 0; i--) {
			int min = Math.min(max, leftMost[i]);
			if (min > A[i]) {
				total += min - A[i];
			} else {
				max = Math.max(max, A[i]);
			}

		}

		return total;
	}

	public static void main(String[] args) {
		int[] input = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int trapping;
		trapping = trap(input);
		System.out.println(trapping);
	}
}
