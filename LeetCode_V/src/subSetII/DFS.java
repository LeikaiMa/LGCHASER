package subSetII;

import java.util.ArrayList;
import java.util.Arrays;
// 这里也同样用了DFS 的方法，说明参考subset i 
// 要注意的情况是为了去重，要将后面一个和现在这个相同的过滤掉。就用了一个while 循环，将现在和后面一个进行对比，如果相同，就递增1，
// 要注意的是因为是要处理i+1 所以要让i+1 小于 length
// 还有dfs 递归的时候传到下面的是i +1 而不是pos +1
public class DFS {
	public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return results;
		}
		ArrayList<Integer> tmp = new ArrayList<Integer>();

		Arrays.sort(num);
		results.add(tmp);

		dfs(results, tmp, num, 0);
		return results;
	}

	private static void dfs(ArrayList<ArrayList<Integer>> results,
			ArrayList<Integer> tmp, int[] num, int pos) {
		for (int i = pos; i < num.length; i++) {
			tmp.add(num[i]);
			results.add(new ArrayList<Integer>(tmp));
			dfs(results, tmp, num, i + 1);
			tmp.remove(tmp.size() - 1);
			while (i < num.length - 1 && num[i] == num[i + 1]) {
				i++;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] num = { 4, 1, 0 };
		// int[] num = { 5,5,5,5,5 };
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		results = subsetsWithDup(num);
		for (ArrayList<Integer> r : results) {
			System.out.println(r);
		}
	}
}
