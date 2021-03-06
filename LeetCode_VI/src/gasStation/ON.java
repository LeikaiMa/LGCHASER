package gasStation;
// 然后更加优化，只需要遍历一遍，因为能不能转一圈是有没有解的最关键一步，所有的方法都要在最后看是否一圈为正
// 而前面如果是负数的序列肯定是不能成立的，而且只有一个解，说明是能够为正数的第一个数。
// 这样采取的措施就是每次都进行累加，一个是累加子串，一个是统计整个串，如果子串一旦小于0，那么起始点就不可能是在这个子串的范围里面。肯定是子串的后面一个。
// 重置的时候将起点设置在后一个，将总数设置为0.
// 最后的时候如果总的和大于0 就说明有可能右起点，起点就是之前设置的起点，否则就是-1
// http://fisherlei.blogspot.com/2013/11/leetcode-gas-station-solution.html
public class ON {
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || gas.length == 0) {
			return -1;
		}
		int total = 0;
		int sum = 0;
		int start = 0;
		for (int i = 0; i < gas.length; i++) {
			sum += gas[i] - cost[i];
			total += gas[i] - cost[i];
			if (sum < 0) {
				start = i + 1;
				sum = 0;
			}
		}
		return total >= 0 ? start : -1;
	}
}
