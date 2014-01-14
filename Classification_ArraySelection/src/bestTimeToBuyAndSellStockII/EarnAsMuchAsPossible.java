package bestTimeToBuyAndSellStockII;
//V
//这个方法更加接近本质，如果有后悔的功能，看到今天比昨天的要高，就回头把昨天的也买了，然后把每天的钱都赚了，肯定是最多的。
public class EarnAsMuchAsPossible {
	public int maxProfit(int[] prices) {
		int total = 0;
		for (int i = 1; i < prices.length; i++) {
			int profit = prices[i] - prices[i - 1];
			total += profit > 0 ? profit : 0;
		}

		return total;
	}
}
