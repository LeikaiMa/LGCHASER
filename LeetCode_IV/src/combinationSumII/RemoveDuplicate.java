package combinationSumII;
// 这是一个典型的递归题，先将整个进行排序，这样加起来是从小大的。
// 然后进入helper 里面，包括进去时候的起始位置，目前为止加来的大小，因为是void 型，所以将要在里面用到的一些参量直接初始化后传进去。
// 因为复制的时候不是deep copy 所以要用的是addAll 这个功能。
// 里面当相等的时候，将已经存好的复制到另一个arraylist 里面，然后将新的存进最后的答案里面。
// 如果是已经超过说明不符合要求，直接过滤。
// 如果是小于说明还要用后面的值，这时候从后面的值开始依次尝试，用的是for 循环，因为每次都要保证一样，所以加进去的东西再最后的时候都要删掉，
// arraylist 要删掉东西用remove 把最后一个index 里面的东西给删了。sum同样。
// 传进去的时候因为每个不是无限取的，用过之后就要+1 进行使用
// 而且里面还不能有重复，所以最后一个是将自己本身里面的进行去重。 用一个小一个的while 循环进行去重，一个是范围，这个要写前面，还有一个和后面一个数据进行比较，如果相等挪一个位置。
// 这样既保证了自己不多取，也没有重复的值。但是如果不够的话，本身还是至少有一个的，比如1 1之类的，不会有 7 1 和7 1 两次出现。
import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicate {
	public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num,
			int target) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return results;
		}
		Arrays.sort(num);
		ArrayList<Integer> re = new ArrayList<Integer>();
		combinationSum2Helper(num, target, 0, 0, re, results);
		return results;
	}

	private static void combinationSum2Helper(int[] num, int target, int start,
			int sum, ArrayList<Integer> re,
			ArrayList<ArrayList<Integer>> results) {
		if (sum == target) {
			ArrayList<Integer> result = new ArrayList<Integer>();
			result.addAll(re);
			results.add(result);
			return;
		} else if (sum > target) {
			return;
		} else {
			for (int i = start; i < num.length; i++) {
				re.add(num[i]);
				sum += num[i];
				combinationSum2Helper(num, target, i + 1, sum, re, results);
				re.remove(re.size() - 1);
				sum -= num[i];
				while (i < num.length - 1 && num[i] == num[i + 1]) {
					i++;
				}
			}
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
