package climbStairs;
// 小女孩走楼梯问题还是要用DP的方法，要将每次走的记录下来，以后可以用。不然做了很多重复的工作。
import java.util.HashMap;

public class Recursive {
	public int climbStairs(int n) {
		if (n == 0 || n == 1 || n == 2) {
			return n;
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int result = climbStairsHelper(n, map);
		return result;
	}

	private int climbStairsHelper(int n, HashMap<Integer, Integer> map) {
		if (map.containsKey(n)) {
			return map.get(n);
		}
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			int result = climbStairsHelper(n - 1, map)
					+ climbStairsHelper(n - 2, map);
			map.put(n, result);
			return result;

		}

	}

}
