package fourSum;

import java.util.ArrayList;
import java.util.Collections;
// 用求全部set 的方法虽然可以求出最终的结果。但是时间复杂度太高。
public class FourSum {
	public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> targetResult = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> input = new ArrayList<Integer>();
		for (int i : num) {
			input.add(i);
		}
		Collections.sort(input, Collections.reverseOrder());
		subSet(result, input, 0);
		
		for (ArrayList<Integer> r: result) {
			int sum = 0;
			for (int i: r) {
				sum+=i;
			}
			if (sum == target && r.size() == 4) {
				targetResult.add(r);
			}
		}
		return targetResult;
	}

	public static void subSet(ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> input, int index) {
		if (index == input.size()) {
			ArrayList<Integer> arrayList = new ArrayList<Integer>();
			result.add(arrayList);
		} else {
			ArrayList<ArrayList<Integer>> moreSets = new ArrayList<ArrayList<Integer>>();
			subSet(result, input, index + 1);
			for (ArrayList<Integer> subSets : result) {
				if (subSets.size() > 3) {
					continue;
				}
				ArrayList<Integer> tmpsets = new ArrayList<Integer>();
				tmpsets.addAll(subSets);
				tmpsets.add(input.get(index));
				moreSets.add(tmpsets);
			}
			result.addAll(moreSets);
		}
	}
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> resultArrayList= new ArrayList<>();
		int[] S = {-493,-482,-482,-456,-427,-405,-392,-385,-351,-269,-259,-251,-235,-235,-202,-201,-194,-189,-187,-186,-180,-177,-175,-156,-150,-147,-140,-122,-112,-112,-105,-98,-49,-38,-35,-34,-18,20,52,53,57,76,124,126,128,132,142,147,157,180,207,227,274,296,311,334,336,337,339,349,354,363,372,378,383,413,431,471,474,481,492};
		
		int target = 6189;
		resultArrayList = fourSum(S, target);
		for (ArrayList<Integer> r: resultArrayList) {
			System.out.println(r);
		}
	}

}
