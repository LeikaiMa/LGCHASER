package bestTimeToBuyAndSellStockI;

public class ON {
	public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
			return 0;
		}

		int buy = 0;
		int tmp = 0;
		int sell = 1;
		int profit = prices[sell] - prices[buy];
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] - prices[tmp] >= profit) {
				sell = i;
				buy = tmp;
				profit = prices[sell] - prices[tmp];
			}
			if (prices[i] < prices[tmp]) {
				tmp = i;
			}
		}
		return (profit) < 0 ? 0 : profit;
	}
	public static void main(String[] args) {
		int[] prices = {1, 4 ,2};
		System.out.println(maxProfit(prices));
	}
}
