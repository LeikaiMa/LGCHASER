package subSet;
// 这个利用了subset 的另外一种特性，即原来set 的元素，只有两种情况为 有和无，转换为二进制为1 和 0
// 这样里面就可以有2^n个，而且是连续的。 这样的值可以通过左移来得到。
// 每个子集代表一个数。然后将这些数转换为相应的子集，存在的就加到里面的set 当中。
// 每一位也就可以用右移 和 1 进行& 来得到。
// 最后add到subset 当中。这样不需要递归，只要进行数学思维就可以了。
import java.util.ArrayList;

public class Combinatorics {
	public ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		int max = 1 << set.size();
		
		for (int k = 0; k < max; k++) {
			ArrayList<Integer> subset = convertIntToSet(k, set);
			allsubsets.add(subset);
		}
		return allsubsets;
	}

	private ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
		ArrayList<Integer> subset = new ArrayList<Integer>();
		int index = 0;
		for (int k = x; k > 0; k >>= 1) {
			if ((k & 1) == 1) {
				subset.add(set.get(index));
			}
			index++;
		}
		return subset;
	}

}
