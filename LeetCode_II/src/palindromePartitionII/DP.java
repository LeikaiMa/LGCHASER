package palindromePartitionII;
// 和求完全回文数一样，开始用二维数组建一个dp 储存所有的回文。
// 然后像BFS 一样去找最短路径，可以是用QUEUE 来存，但是这里面只用到了要走的步数。
// 所以想到用两个hashset 进行轮流的储存里面的下一个end 先到了最后一位就返回步数。
// 这里用hashset 的目的是在于把重复的第n步所走的开头给去重，省的下面继续找。
// 应该有更清楚的方法，可以复习的时候再进行参考
import java.util.HashSet;

public class DP {
	public static int minCut(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
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

		HashSet<Integer> hashSet = new HashSet<Integer>();
		for (int i = 0; i < length; i++) {
			if (isPalindrome[0][i]) {
				if (i == length - 1) {
					return 0;
				}
				hashSet.add(i);
			}
		}
		int min = 0;
		while (true) {
			min++;
			HashSet<Integer> hashSet2 = new HashSet<Integer>();
			for (int i : hashSet) {
				for (int j = i + 1; j < length; j++) {
					if (isPalindrome[i+1][j]) {
						if (j == length - 1) {
							return min;
						}
						hashSet2.add(j);
					}
				}
			}
			hashSet = hashSet2;
		}
	}

	public static void main(String[] args) {
		String s = "abacbbcaa";
		System.out.println(minCut(s));
	}

}
