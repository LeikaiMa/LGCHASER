package findKthSmallest;

public class FixedValue {
	public int largestKSum(int[] num, int k) {
		int[] count = new int[101];
		for (int n : num) {
			count[101 - n]++;
		}

		int sum = 0;
		int c = 0;
		for (int i = 1; i < 101; i++) {
			if (count[i] == 0) {
				continue;
			}
			c += count[i];
			if (c < k) {
				sum += count[i] * i;
			} else {
				sum += count[i] * (k - (c - count[i]));
				return sum;
			}
		}
		return Integer.MIN_VALUE;
	}
}
