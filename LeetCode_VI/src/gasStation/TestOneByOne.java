package gasStation;
// 最开始想的时候是从每个点出发，然后绕一圈看看是否是正数，如果直接有一步是导致了变成了负数就说明了，这个不成立，应该直接跳出来，检测下一个，
// 这样复杂度是O(n^2)，大数据跑不过。
// 这里要注意的剩下的是gas - cost
// 然后为了减少次数，思考优化的情况，类似于最长的正数的子集串，为什么会变成负的，之前这个做的负工太大，如果不绕开这个永远无法到达正工
// 所以要检查的是从这个最大的负工的后面一个开始，那么将i 优化到现在这个。 就是i +j 不用 长度取余，因为这个就会回去，而之前重复做过了。这样可以优化
public class TestOneByOne {
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || gas.length == 0) {
			return -1;
		}
		if (gas.length == 1) {
			if (gas[0] >= cost[0]) {
				return 0;
			} else {
				return -1;
			}
		}
		int[] remain = new int[gas.length];
		for (int i = 0; i < gas.length; i++) {
			remain[i] = gas[i] - cost[i];
		}

		for (int i = 0; i < remain.length; i++) {
			int left = 0;
			int j = 0;
			for (; j < remain.length; j++) {
				left += remain[(i + j) % remain.length];
				if (left < 0) {
					i = i + j;
					break;
				}
			}
			if (j == remain.length) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] gas = {1,2};
		int[] cost = {2,1};
		System.out.println(canCompleteCircuit(gas, cost));
	}
}
