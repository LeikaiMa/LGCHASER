package combination;
//IV
//这里用组合的方法使用了倒着插入的方法，通过k 不断减1 知道最后为1的时候将所有的n范围内的数新建一个arraylist
//然后将这个list递归回去。每次插入比他要大的。
//要注意的是，在base case 之前，不仅仅只有n 一个，可以是n 到 k 之间任意的个数，
//这时候里面要用for loop 然后新建arraylist 将返回的值add 进新的，然后插入新的元素，在进行返回。
import java.util.ArrayList;
//这个是直接插入要注意的是要有一个开头，一个结尾作为DFS的不断更新的依据
//开头开始就用1，结尾就用n-k+1 相等来，因为最大就在这一层只能是这个如果更大后面就没有足够的数来填满整个结果。
public class KNindexControlParameters {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		helper(results, result, k, n, 1);
		return results;
	}

	private void helper(ArrayList<ArrayList<Integer>> results,
			ArrayList<Integer> result, int k, int n, int index) {
		if (k == 0) {
			results.add(new ArrayList<Integer>(result));
		} else {
			for (int i = index; i <= n - k + 1; i++) {
				result.add(i);
				helper(results, result, k - 1, n, i + 1);
				result.remove(result.size() - 1);
			}
		}
	}
}
