package combinationSum;
// 这个相比较自己之前的思路要更加清晰一些。因为也是直接用void 来进行 所以之前把所有的参数都写好传进去。
// 然后是因为可以无限制的取，所以下一个时候还是从自己开始。
import java.util.ArrayList;
import java.util.Arrays;

public class Forward {
	public static ArrayList<ArrayList<Integer>> combinationSum(
			int[] candidates, int target) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if (candidates == null || candidates.length == 0) {
			return results;
		}
		Arrays.sort(candidates);
		ArrayList<Integer> re = new ArrayList<Integer>();
		combinationSumHelper(candidates, target, 0, 0, re, results);
		return results;
	}

	private static void combinationSumHelper(int[] candidates, int target,
			int start, int sum, ArrayList<Integer> re,
			ArrayList<ArrayList<Integer>> results) {
		if (sum == target) {
			ArrayList<Integer> result = new ArrayList<Integer>();
			result.addAll(re);
			results.add(result);
			return;
		} else if (sum > target) {
			return;
		} else {
			for (int i = start; i < candidates.length; i++) {
				re.add(candidates[i]);
				sum += candidates[i];
				combinationSumHelper(candidates, target, i, sum, re, results);
				re.remove(re.size() - 1);
				sum -= candidates[i];
			}
		}
		
	}
}
