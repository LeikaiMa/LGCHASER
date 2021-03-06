package longestConsecutiveSequence;
// 这个题目就是用O n的方法来求最长的连续串的长度。
// 想到了将每个放进一个map 里面，然后遍历的时候看左右的两个在不在map 里面。如果在map 里面，可以将两边的累计的长度加起来，然后三个的长度都进行更新，
// 这个思路方向是正确的，但是一个range 只能更新一边，信息没有办法传递到整个range 另一头。所以需要重新思考。
// 考虑到一直的都是连续的，所以两个结合起来中间的那些node 所记录的长度也就没有什么用了。如果是左边的range 只要更新最左边的，右边的 range 更新只要更新最右边的，这样以这个为两边的整个range 都可以知道了。
// 这个仅限于连续的，如果不是连续的，只更新两边的是不合适的。
// 这样就要将自己看做长度是1的range，然后插进去，如果是有自己本身就在里面就要跳过，因为里面其他东西没有更新，会出现错误。
// 然后每次merge之后返回新的range 的长度，可以更新最外面的max的长度。
// 在merge 的时候找两个range 的最边上，然后只要更新这两边的长度就可以了。就相当于新的 range 产生了。虽然这样中间的就有可能没有能更新，但对于这个题目没有必要。
import java.util.HashMap;

public class HashMapClusterMerge {
	public static int longestConsecutive(int[] num) {
		if (num == null) {
			return 0;
		}

		HashMap<Integer, Integer> visited = new HashMap<Integer, Integer>();
		int max = 1;
		for (int i : num) {
			if (visited.containsKey(i)) {
				continue;
			}
			visited.put(i, 1);
			if (visited.containsKey(i - 1)) {
				max = Math.max(merge(visited, i - 1, i), max);
			}
			if (visited.containsKey(i + 1)) {
				max = Math.max(merge(visited, i, i + 1), max);
			}
		}

		return max;
	}

	private static int merge(HashMap<Integer, Integer> visited, int left,
			int right) {
		int upper = right + visited.get(right) - 1;
		int lower = left - (visited.get(left) - 1);

		int len = visited.get(upper) + visited.get(lower);
		visited.put(lower, len);
		visited.put(upper, len);
		return len;
	}

	public static void main(String[] args) {
		int[] num = { 1, 2, 0, 1 };
		System.out.println(longestConsecutive(num));
	}
}
