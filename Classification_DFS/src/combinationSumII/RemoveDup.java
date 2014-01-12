package combinationSumII;
//IV
//这是一个典型的递归题，先将整个进行排序，这样加起来是从小大的。
//然后进入helper 里面，包括进去时候的起始位置，目前为止加来的大小，因为是void 型，所以将要在里面用到的一些参量直接初始化后传进去。
//因为复制的时候不是deep copy 所以要用的是addAll 这个功能。
//里面当相等的时候，将已经存好的复制到另一个arraylist 里面，然后将新的存进最后的答案里面。
//如果是已经超过说明不符合要求，直接过滤。
//如果是小于说明还要用后面的值，这时候从后面的值开始依次尝试，用的是for 循环，因为每次都要保证一样，所以加进去的东西再最后的时候都要删掉，
//arraylist 要删掉东西用remove 把最后一个index 里面的东西给删了。sum同样。
//传进去的时候因为每个不是无限取的，用过之后就要+1 进行使用
//而且里面还不能有重复，所以最后一个是将自己本身里面的进行去重。 用一个小一个的while 循环进行去重，一个是范围，这个要写前面，还有一个和后面一个数据进行比较，如果相等挪一个位置。
//这样既保证了自己不多取，也没有重复的值。但是如果不够的话，本身还是至少有一个的，比如1 1之类的，不会有 7 1 和7 1 两次出现。
import java.util.ArrayList;
import java.util.Arrays;
// 主要就是里面向前删掉重复的，递归的时候用的后面一个不是本身，递归不需要去重。
public class RemoveDup {
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		int sum = 0;
		helper(results, result, num, 0, sum, target);
		return results;
	}

	public void helper(ArrayList<ArrayList<Integer>> results,
			ArrayList<Integer> result, int[] num, int index, int sum, int target) {
		for (int i = index; i < num.length; i++) {
			sum += num[i];
			if (sum < target) {
				result.add(num[i]);
				helper(results, result, num, i + 1, sum, target);
			} else if (sum == target) {
				result.add(num[i]);
				results.add(new ArrayList<Integer>(result));
			} else {
				break;
			}
			result.remove(result.size() - 1);
			sum -= num[i];
			while (i < num.length - 1 && num[i] == num[i + 1]) {
				i++;
			}
		}
	}
}
