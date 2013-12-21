package palindromePartitionI;

import java.util.ArrayList;
// 求palindrome 所有的分割方法，用DP 和 DFS 结合的方法。
// 首先可以DP 将所有的都储存起来， 因为是要记录palindrome 的 start index 和end index 而且要判断是否是回文。
// 可以利用二维数组的特性，row 和 column 的index 然后用里面存储boolean看是否是回文。
// 回文判断的时候依然是用轴 向两边散开的方法，如果是一个的肯定是回文进行存储。然后展开是从1 开始，边界条件是不能超过两边的边界条件。
// 里面用的小trick 是在于如果内部已经有左右两边不相等的情况，就应该直接跳出循环不要继续进行计算。
// 得到DP 之后要进行DFS 也就是进行递归。
// 每次以start 开始往后面找是true 的 end ，如果是将end+1 作为start 进行递归。直到最后到达 length 时候返回一个空的 arraylist 
// 递归回来每次要在前面加进去新的substring 最后统一起来再返回。
public class DFS {
	public static ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
		if (s == null || s.isEmpty()) {
			return results;
		}
		int length = s.length();
		boolean[][] isPalindrome = new boolean[length][length];
		for (int i = 0; i < length; i++) {
			isPalindrome[i][i] = true;
			int expand = 1;
			while (i - expand >= 0 && i + expand < length) {
				if (s.charAt(i - expand) == s.charAt(i + expand)) {
					isPalindrome[i - expand][i + expand] = true;
					expand++;
				} else {
					break;
				}

			}
		}

		for (int i = 0; i < length - 1; i++) {
			if (s.charAt(i) != s.charAt(i + 1)) {
				continue;
			}
			isPalindrome[i][i + 1] = true;
			int expand = 1;
			while (i - expand >= 0 && i + 1 + expand < length) {
				if (s.charAt(i - expand) == s.charAt(i + 1 + expand)) {
					isPalindrome[i - expand][i + 1 + expand] = true;
					expand++;
				} else {
					break;
				}
			}
		}

		results = partitionHelper(s, 0, isPalindrome);
		return results;
	}

	public static ArrayList<ArrayList<String>> partitionHelper(String s,
			int start, boolean[][] isPalindrome) {
		ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
		if (start == s.length()) {
			ArrayList<String> result = new ArrayList<String>();
			results.add(result);
			return results;
		} else {

			for (int i = start; i < s.length(); i++) {
				if (isPalindrome[start][i]) {
					ArrayList<ArrayList<String>> nexts = partitionHelper(s,
							i + 1, isPalindrome);
					for (ArrayList<String> next : nexts) {
						next.add(0, s.substring(start, i + 1));
						results.add(next);
					}
				}
			}
			return results;
		}
	}

	public static void main(String[] args) {
		String s = "aabaa";
		ArrayList<ArrayList<String>> results = partition(s);
		for (ArrayList<String> result : results) {
			System.out.println(result);
		}
	}
}
