package bestTimeToBuyAndSellStockI;
// 这题目前每天要么买要么卖，但是要细心，开始的时候所有的都是0，比较的时候如果价钱比min 要低，暂定买这个，注意比较的时候用prices比较
// 如果比min 要大，那么先求出两个的差，如果比之前存的max 还要大，那么买的时间改成之前暂定的min 卖的变成现在这个，maxdiff 也要更新。
// 最后输出更新的maxdiff
public class Clearer {
	public static int maxProfit(int[] prices) {
		int buy =0;
		int sell = 0;
		int min = 0;
		int maxdiff = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < prices[min]) {
				min = i;
			} else {
				int diff = prices[i] - prices[min];
				if (diff > maxdiff) {
					sell = i;
					buy = min;
					maxdiff = diff;
				}
			}
		}
		return prices[sell] - prices[buy];
//		这里其实可以直接用maxdiff 来进行解决。但是为了少warning
	}
	
	public static void main(String[] args) {
		int[] prices = {2,1,4};
		System.out.println(maxProfit(prices));
	}
}
