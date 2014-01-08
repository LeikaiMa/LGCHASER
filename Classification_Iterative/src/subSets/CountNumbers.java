package subSets;
//I - 17
import java.util.ArrayList;
import java.util.Arrays;
// 就是因为是distinct 的，所以总共2^n 种情况，每个都是可以取可以不取两种，
// 这样就是从0 - 2^n -1个数，看他用二进制表示哪些位数是1，就将这个放进去，如果是0 就不放，
// 比较的时候也就是将位数从0 开始到最后一位，看这个index 用1 左移这么多位和原来相与，看是不是不为0，就说明这一位是有的
// 如果和2的次方有关系的，最好就是用<< 来进行表示
public class CountNumbers {
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		Arrays.sort(S);

		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < (1 << S.length); i++) {
			ArrayList<Integer> result = new ArrayList<Integer>();
			for (int j = 0; j < S.length; j++) {
				if ((i & (1 << j)) != 0) {
					result.add(S[j]);
				}
			}
			results.add(result);
		}

		return results;
	}
}
