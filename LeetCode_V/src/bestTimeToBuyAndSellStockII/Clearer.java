package bestTimeToBuyAndSellStockII;
// 这个方法更加接近本质，如果有后悔的功能，看到今天比昨天的要高，就回头把昨天的也买了，然后把每天的钱都赚了，肯定是最多的。
public class Clearer {
	public static int maxProfit(int[] prices) {
		int total = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] - prices[i-1] > 0) {
				total += prices[i] - prices[i-1];
			}
		}
		return total;
	}
	
	public static void main(String[] args) {
		int[] prices = {6,1,3,2,4,7};
		System.out.println(maxProfit(prices));
	}
}
