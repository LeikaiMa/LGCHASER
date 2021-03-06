package bestTimeToBuyAndSellStockII;
// 这里自己的思路是只要是买入价比卖出价要低，说明前面就有钱赚，就可以把前面的给卖掉。
// 如果比之前的还要高，就换成高的
public class ON {
	public static  int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int buy = 0;
		int sell = 0;
		int totalProfit = 0;

		for (int i = 0; i < prices.length; i++) {
			if (prices[i] <= prices[sell]) {
				totalProfit += prices[sell] - prices[buy];
				buy = i;
				sell = i;
			}
			if (prices[i] > prices[sell]) {
				sell = i;
			}
		}

		totalProfit += prices[sell] - prices[buy];
		return totalProfit;
	}
	
	public static void main(String[] args) {
		int[] prices = {6,1,3,2,4,7};
		System.out.println(maxProfit(prices));
	}

}
