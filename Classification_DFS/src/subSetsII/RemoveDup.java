package subSetsII;
// V - 17
//这里也同样用了DFS 的方法，说明参考subset i 
//要注意的情况是为了去重，要将后面一个和现在这个相同的过滤掉。就用了一个while 循环，将现在和后面一个进行对比，如果相同，就递增1，
//要注意的是因为是要处理i+1 所以要让i+1 小于 length
//还有dfs 递归的时候传到下面的是i +1 而不是pos +1
import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDup {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> result = new ArrayList<Integer>();

		results.add(new ArrayList<Integer>(result));

		Arrays.sort(num);

		subsetsWithDupHelper(results, result, num, 0);

		return results;
	}

	public void subsetsWithDupHelper(ArrayList<ArrayList<Integer>> results,
			ArrayList<Integer> result, int[] num, int index) {
		for (int i = index; i < num.length; i++) {
			result.add(num[i]);
			results.add(new ArrayList<Integer>(result));

			subsetsWithDupHelper(results, result, num, i + 1);

			result.remove(result.size() - 1);

			while (i < num.length - 1 && num[i] == num[i + 1]) {
				i++;
			}
		}
	}
}
