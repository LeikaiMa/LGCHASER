package largestSum;
// 只有正数才会越来越大，如果加上负数就会减小，如果负数减小的效果超过了正数，宁可将前面记录的部分删掉，重新开始。
// 遍历整个，sum 开始为0， 每次增加增加相应的a[i] 如果增加超过原来的最大值就更新，如果变换到了副作用就删除。
public class ContiguousSequence {
	public static int getMaxSum(int[] a) {
		int maxsum = 0;
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			if (maxsum < sum) {
				maxsum = sum;
			} else if (sum < 0) {
				sum = 0;
			}
		}
		return maxsum;
	}
}
