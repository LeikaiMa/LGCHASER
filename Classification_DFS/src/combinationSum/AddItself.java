package combinationSum;
//IV
//这个相比较自己之前的思路要更加清晰一些。因为也是直接用void 来进行 所以之前把所有的参数都写好传进去。
//然后是因为可以无限制的取，所以下一个时候还是从自己开始。
import java.util.ArrayList;
import java.util.Arrays;
//这个也可以将比较放在下一次递归里面。代码可以参考之前自己写的
public class AddItself {
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
			int target) {
		Arrays.sort(candidates);
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		int sum = 0;
		helper(results, result, candidates, 0, sum, target);
		return results;
	}

	public void helper(ArrayList<ArrayList<Integer>> results,
			ArrayList<Integer> result, int[] num, int index, int sum, int target) {
		for (int i = index; i < num.length; i++) {
			sum += num[i];
			if (sum < target) {
				result.add(num[i]);
				helper(results, result, num, i, sum, target);
			} else if (sum == target) {
				result.add(num[i]);
				results.add(new ArrayList<Integer>(result));
			} else {
				break;
			}
			result.remove(result.size() - 1);
			sum -= num[i];
		}
	}
}
