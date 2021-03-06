package maximumSubarray;
// 这题之前虽然做过，但是考虑的还是不全面，做负功应该是对前面的sum 完全否定掉才重新置0 而不是仅仅现在这个比前面小
// 首先sum 置为0，因为最小的有负数，所以max 先置为min 
// 然后sum 每次都进行累计，让max 看sum 是不是超过了，如果超过了就更新。
// 一旦sum 变为负值，就说明对后面没有作用，就应该变成0
public class ON {
	public static int maxSubArray(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}

		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum+= A[i];
			if (max < sum) {
				max = sum;
			} 
			if (sum < 0) {
				sum = 0;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, -1, -2, 2, 1, -2, 1, 4, -5, 4 };
		
		System.out.println(maxSubArray(A));
		int[] B = {-5, -1};
		System.out.println(maxSubArray(B));
	}
}
