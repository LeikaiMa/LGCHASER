package combinationSumII;

import java.util.ArrayList;
import java.util.Arrays;

public class BackTrace {
	public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num,
			int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return result;
		}
		// HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		Arrays.sort(num);
		result = combinationSumHelper(num, num.length - 1, target);
		return result;
	}

	private static ArrayList<ArrayList<Integer>> combinationSumHelper(
			int[] candidates, int index, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		while (index >= 0 && candidates[index] > target) {
			index--;
		}
		if (index < 0) {
			return result;
		} else {
			for (int i = index; i >= 0; i--) {
				if (target - candidates[i] == 0) {
					ArrayList<Integer> r = new ArrayList<Integer>();
					r.add(candidates[i]);
					result.add(r);
				} else {
					int slow = i - 1;
					int fast = i - 2;
					while (fast >= 0) {
						if (candidates[i] != candidates[slow]
								&& candidates[slow] == candidates[fast]) {
							slow--;
							fast--;
						} else {
							break;
						}
					}
					ArrayList<ArrayList<Integer>> subResult = combinationSumHelper(
							candidates, slow, target - candidates[i]);
					for (ArrayList<Integer> subR : subResult) {
						subR.add(candidates[i]);
						result.add(subR);
					}
				}
			}
			return result;
		}
	}

	public static void main(String[] args) {
		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		result = combinationSum2(candidates, target);
		for (ArrayList<Integer> r : result) {
			System.out.println(r);
		}
	}
}
