package fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
//可以参考threeSum， 关键点是由4维转换为3维。 hashset 去重。
//由于target 没有确定，所以没有three Sum 更多的优化条件
public class Faster {
	public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		Arrays.sort(num);
		HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				for (int k = j + 1, l = num.length - 1; k < l;) {
					int sum = num[i] + num[j] + num[k] + num[l];
					if (sum < target) {
						k++;
					} else if (sum > target) {
						l--;
					} else {
						ArrayList<Integer> arrayList = new ArrayList<Integer>();
						arrayList.add(num[i]);
						arrayList.add(num[j]);
						arrayList.add(num[k]);
						arrayList.add(num[l]);
						if (!hashSet.contains(arrayList)) {
							hashSet.add(arrayList);
							result.add(arrayList);
						}
						k++;
						l = num.length - 1;
					}

				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> resultArrayList = new ArrayList<>();
		// int[] S =
		// {-493,-482,-482,-456,-427,-405,-392,-385,-351,-269,-259,-251,-235,-235,-202,-201,-194,-189,-187,-186,-180,-177,-175,-156,-150,-147,-140,-122,-112,-112,-105,-98,-49,-38,-35,-34,-18,20,52,53,57,76,124,126,128,132,142,147,157,180,207,227,274,296,311,334,336,337,339,349,354,363,372,378,383,413,431,471,474,481,492};
		int[] S = { 0, 0, 0, 0 };
		// int target = 6189;
		int target = 0;
		resultArrayList = fourSum(S, target);
		for (ArrayList<Integer> r : resultArrayList) {
			System.out.println(r);
		}
	}
}
