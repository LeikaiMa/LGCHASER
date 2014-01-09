package palindromePartitionII;
// II
//和求完全回文数一样，开始用二维数组建一个dp 储存所有的回文。
//然后像BFS 一样去找最短路径，可以是用QUEUE 来存，但是这里面只用到了要走的步数。
//所以想到用两个hashset 进行轮流的储存里面的下一个end 先到了最后一位就返回步数。
//这里用hashset 的目的是在于把重复的第n步所走的开头给去重，省的下面继续找。
//应该有更清楚的方法，可以复习的时候再进行参考
import java.util.HashSet;

public class HashSetToRemoveDup {
	public int minCut(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}

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

		HashSet<Integer> next = new HashSet<Integer>();
		if (dp[0][s.length() - 1]) {
			return 0;
		}

		for (int i = 0; i < s.length(); i++) {
			if (dp[0][i]) {
				next.add(i + 1);
			}
		}

		int min = 1;
		while (true) {
			HashSet<Integer> tmp = new HashSet<Integer>();
			for (int i : next) {
				if (dp[i][s.length() - 1]) {
					return min;
				}

				for (int j = i; j < s.length(); j++) {
					if (dp[i][j]) {
						tmp.add(j + 1);
					}
				}
			}

			min++;
			next = tmp;
		}
	}
}
