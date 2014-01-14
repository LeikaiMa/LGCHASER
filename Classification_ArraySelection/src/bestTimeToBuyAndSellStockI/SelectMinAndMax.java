package bestTimeToBuyAndSellStockI;
//V
//这题目前每天要么买要么卖，但是要细心，开始的时候所有的都是0，比较的时候如果价钱比min 要低，暂定买这个，注意比较的时候用prices比较
//如果比min 要大，那么先求出两个的差，如果比之前存的max 还要大，那么买的时间改成之前暂定的min 卖的变成现在这个，maxdiff 也要更新。
//最后输出更新的maxdiff

//因为不需要记录具体的位置，所以可以直接用中间变量来直接存储里面的值。
//主体思想就是看见比自己小的就记下来，然后看到现在的值和之前最小的值进行比较，得到最大的profit 更新max profit 因为不需要记录最大值和最小值 的index 所以可以这么做。
public class SelectMinAndMax {
	public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        
        return max;
    }
}
