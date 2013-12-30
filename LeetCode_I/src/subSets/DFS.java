package subSets;

import java.util.ArrayList;
import java.util.Arrays;
// 这里用了DFS 代码更加简洁，首先因为是要有顺序，所以开始的要先对他进行sort 一下。
// 然后是要一个一个进行添加，而且不能有重复，所以是从现在这个开始往后来数，而不是像permutation 一样是从头开始。
// 最开始的时候要记得将空集加进去。
// dfs 开始的时候是从0开始 在后面就是pos 的后一个。
// 在里面遍历的时候先将tmp 里面加上这个元素，然后加到最后的结果的时候要进行deep copy 所以要新建，但是可以做的优化是新建的时候，直接将现在这个放进括号里面
// 然后dfs 结束之后就将最后一个删除，然后添加另一个，再进行dfs
public class DFS {
	public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if (S == null || S.length == 0) {
			return results;
		}

		ArrayList<Integer> tmp = new ArrayList<Integer>();

		Arrays.sort(S);

		results.add(tmp);
		dfs(results, tmp, S, 0);
		return results;
	}

	private static void dfs(ArrayList<ArrayList<Integer>> results,
			ArrayList<Integer> tmp, int[] S, int pos) {
		for (int i = pos; i < S.length; i++) {
			tmp.add(S[i]);
			results.add(new ArrayList<Integer>(tmp));
			dfs(results, tmp, S, i + 1);
			tmp.remove(tmp.size() - 1);
		}
	}
}
