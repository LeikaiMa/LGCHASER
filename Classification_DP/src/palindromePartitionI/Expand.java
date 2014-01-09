package palindromePartitionI;
// II
//求palindrome 所有的分割方法，用DP 和 DFS 结合的方法。
//首先可以DP 将所有的都储存起来， 因为是要记录palindrome 的 start index 和end index 而且要判断是否是回文。
//可以利用二维数组的特性，row 和 column 的index 然后用里面存储boolean看是否是回文。
//回文判断的时候依然是用轴 向两边散开的方法，如果是一个的肯定是回文进行存储。然后展开是从1 开始，边界条件是不能超过两边的边界条件。
//里面用的小trick 是在于如果内部已经有左右两边不相等的情况，就应该直接跳出循环不要继续进行计算。
//得到DP 之后要进行DFS 也就是进行递归。
//每次以start 开始往后面找是true 的 end ，如果是将end+1 作为start 进行递归。直到最后到达 length 时候返回一个空的 arraylist 
//递归回来每次要在前面加进去新的substring 最后统一起来再返回。
import java.util.ArrayList;

// 这里要注意的是substring 都是小写，然后往里面传值的时候要记得传S进去。
public class Expand {
	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
		if (s == null || s.isEmpty()) {
			return results;
		}

		ArrayList<String> result = new ArrayList<String>();
		boolean[][] dp = new boolean[s.length()][s.length()];

		for (int i = 0; i < s.length(); i++) {
			for (int span = 0; span <= Math.min(i, s.length() - 1 - i); span++) {
				int l = i - span;
				int h = i + span;
				if (s.charAt(l) == s.charAt(h)) {
					dp[l][h] = true;
				} else {
					break;
				}
			}
		}

		for (int i = 0; i < s.length(); i++) {
			for (int span = 0; span <= Math.min(i, s.length() - 1 - i - 1); span++) {
				int l = i - span;
				int h = i + 1 + span;
				if (s.charAt(l) == s.charAt(h)) {
					dp[l][h] = true;
				} else {
					break;
				}
			}
		}

		helper(results, result, dp, 0, s);

		return results;
	}

	public void helper(ArrayList<ArrayList<String>> results,
			ArrayList<String> result, boolean[][] dp, int i, String s) {
		if (i == dp.length) {
			results.add(new ArrayList<String>(result));
		} else {
			for (int j = i; j < dp.length; j++) {
				if (dp[i][j]) {
					result.add(s.substring(i, j + 1));
					helper(results, result, dp, j + 1, s);
					result.remove(result.size() - 1);
				}
			}
		}
	}
}
