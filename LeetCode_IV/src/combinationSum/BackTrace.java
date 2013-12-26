package combinationSum;

import java.util.ArrayList;
import java.util.Arrays;

public class BackTrace {
	public static ArrayList<ArrayList<Integer>> combinationSum(
			int[] candidates, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (candidates == null || candidates.length == 0) {
			return result;
		}

		Arrays.sort(candidates);
		result = combinationSumHelper(candidates, candidates.length - 1, target);
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
					ArrayList<ArrayList<Integer>> subResult = combinationSumHelper(
							candidates, i, target - candidates[i]);
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
		int[] candidates = {1,2,3,6,7};
		int target = 7;
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		result = combinationSum(candidates, target);
		for (ArrayList<Integer> r: result) {
			System.out.println(r);
		}
	}
}
