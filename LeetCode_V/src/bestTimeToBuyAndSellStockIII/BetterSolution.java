package bestTimeToBuyAndSellStockIII;
// 这个思路比较清楚，因为只能够有至多两次完整的记录，而且不能相交叉，必须有先后次序，所以应该想到是将整个时间段分成两部分，因为在一天可以卖了之后再买所以两个可以在同一天。
// 总共的收益是两边的和 然后从里面取最大值。
// 如何取分别去两边不同的range最大的收益，最简单是是先0-i 然后i - (n-1)不过这样的话复杂度会达到 n^2 
// 想到第一种最简单的用的O(n)，而且是一步一步过来，这样可以将值显存进来用DP的方法，最后再遍历一遍同样是On 的方法，这样就能把总的复杂度降到O(N)
// 这里面处理第一题的问题同样用的是dp 的方法，先在最开始的时候是收益肯定是0 然后最小的肯定的是本身，然后依次往后，直接比较这次如果卖出和之前买入的最低价比收益是多少。 和前一种情况相比是不是有更高的收益
// 然后在和之前比是不是买入价会更低。
// 最后的一个肯定是之前最优的。
// 反过来同样是这样，不过保存的是最高的卖出价，不断更新的是可能的买入价，因为是往前的所以和后面比。
// 然后再比较新的是不是更高的卖出价，
// 最后第一个肯定是最优的。
// 比较最大的时候同样可以用Math.max来进行比较，比较清楚。
// http://blog.csdn.net/fightforyourdream/article/details/14503469
// 这个如果是不止两笔交易同样可以将所有的情况写进DP，这个时候就要用二维DP来进行然后根据时间点来进行划分，时间复杂度也会随着提升
public class BetterSolution {
	public static int maxProfit(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}

		int max = 0;
		int[] left = new int[prices.length];
		int[] right = new int[prices.length];

		process(prices, left, right);

		for (int i = 0; i < prices.length; i++) {
			max = Math.max(max, left[i] + right[i]);
		}

		return max;
	}

	private static void process(int[] prices, int[] left, int[] right) {
		left[0] = 0;
		int min = prices[0];

		for (int i = 1; i < left.length; i++) {
			left[i] = Math.max(left[i - 1], prices[i] - min);
			min = Math.min(prices[i], min);
		}

		right[prices.length - 1] = 0;
		int max = prices[prices.length - 1];

		for (int i = prices.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], max - prices[i]);
			max = Math.max(prices[i], max);
		}

	}

	public static void main(String[] args) {
		// int[] prices = {3,3,5,0,0,3,1,4};
		// int[] prices = {2,1,2,0,1};
		int[] prices = { 1, 2 };
		System.out.println(maxProfit(prices));
	}
}
