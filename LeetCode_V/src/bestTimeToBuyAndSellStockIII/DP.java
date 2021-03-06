package bestTimeToBuyAndSellStockIII;
// 这个还是用的第一种的方法，是进行比较之后更新最小值，比较max 比较，然后反过来更新最大值，倒过来还是和max进行比。
// 不太符合思路，不小心会有bug 出现
public class DP {
	public static int maxProfit(int[] prices) {
		int n = prices.length;
		int[] first = new int[n];
		int[] second = new int[n];

		int buy = 0;
		int sell = 0;
		int min = 0;
		int maxdiff = 0;

		for (int i = 0; i < n; i++) {
			if (prices[i] < prices[min]) {
				min = i;
			} else {
				int diff = prices[i] - prices[min];
				if (diff > maxdiff) {
					buy = min;
					sell = i;
					maxdiff = diff;
				}
			}
			first[i] = prices[sell] - prices[buy];
		}
		buy = n - 1;
		sell = n - 1;
		int max = n - 1;
		maxdiff = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (prices[i] > prices[max]) {
				max = i;
			} else {
				int diff = prices[max] - prices[i];
				if (diff > maxdiff) {
					buy = i;
					sell = max;
					maxdiff = diff;
				}
			}
			second[i] = maxdiff;

		}

		int total = 0;
		for (int i = 0; i < n; i++) {
			int transaction = first[i] + second[i];
			if (transaction > total) {
				total = transaction;
			}
		}
		return total;
	}
	
	public static void main(String[] args) {  
//      int[] prices = {3,3,5,0,0,3,1,4};  
        int[] prices = {2,1,2,0,1};  
        System.out.println(maxProfit(prices));  
    } 
}
