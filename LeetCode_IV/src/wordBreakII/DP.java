package wordBreakII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
// 完全用递归做太慢，考虑用DP 来进行
// 首先定义DP的每一维的物理含义。 这里用了一个二维数组，第一维表示开始index 的位置，第二维表示字符串的长度，所以二维数组的有len 长， len+1宽
// 因为DP是在前一个基础之上进行，所以外层循环用的是len 的长度，从1 到总的len
// 内层循环用的是开始的index 但是要进行保证他和上面的加起来不能超过总的len ，这样能够全部覆盖起来。
// 具体到里面来说，如果这个start 开始的len 长度的string 存在于dict 当中就说明这个是true
// 如果不存在开始进行切割，看看左右两边是不是都是可以由dict 里面的词组成。因为是从长度1开始的，所以肯定 能够保证我要判断长的时候，短的已经判断完成。
// 这样避免了重复运算。 最后看的是从0开始有len 长的字符串是不是可以由子字符串组成。 如果不行就直接返回空的。
// 如果可以再进行判断是由哪些来进行组成。
// 因为要将一个完整的组成部分输出出来所以用的是DFS
// base case 是我start到了最后一位也就是len 的长度，这时候就可以将buffer 里面存的 东西输入到arraylist 里面去，因为每次存的时候加入了 “ ”
// 这个时候就要去buffer 里面的倒数第二位的，用到了substring
// 如果不到最后一个，那么将这个字符串从左边拆一个一直拆到右边全部结束。 判断左边和右边是否是可以用dict 里面的词进行组装。用dp已经储存的虽然和下面看contain的效果一样，但是速度会更快。
// 过滤完了之后在进行判断左边是不是确实可以由单个字典词组成。
// 这里添加了一个进一步过滤，看右边词是不是可以由词典词组成，如果不能直接不进入递归中，利用之前已经算过的结果，虽然OJ的测试标明没有明显提升，但是应该是可以的。
// 如果左边确实能够由单个的字典词组成，那么将他接到buffer 里面并且后面要加空格，但是因为循环过后不能变值，所以在递归之后要将原来的增加的词在buffer 里面删除。
// 这样就能够将所有的排序都存到arraylist 里面。
// 往往dp 的方法要比直接递归要快的多，因为不需要重复进行操作某些步骤，但是主要要思考，dp 这个表也就是这些维数怎么建，代表什么意义，怎么从最基本的开始进行填表。
// 这题的思路就是在于从最短的1开始填，然后逐渐增加到len 长度。然后每个index 的都可以做头，然后具体的情况中就可以直接从这个二维数组中调用。

public class DP {
	public static ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> result = new ArrayList<String>();
		if (s == null || s.isEmpty()) {
			return result;
		}

		boolean[][] dp = new boolean[s.length()][s.length() + 1];
		for (int len = 1; len <= s.length(); len++) {
			for (int start = 0; start <= s.length() - len; start++) {
				int end = start + len;
				String subString = s.substring(start, end);
				if (dict.contains(subString)) {
					dp[start][len] = true;
				} else {
					for (int m = 1; m < len; m++) {
						if (dp[start][m] && dp[start + m][len - m]) {
							dp[start][len] = true;
							break;
						}
					}
				}
			}
		}

		if (!dp[0][s.length()]) {
			return result;
		} else {
			StringBuffer sb = new StringBuffer();
			wordBreakHelper(0, s, dict, dp, result, sb);
			return result;
		}
	}

	private static void wordBreakHelper(int start, String s, Set<String> dict,
			boolean[][] dp, ArrayList<String> result, StringBuffer sb) {
		int len = s.length();
		if (start == len) {
			result.add(sb.substring(0, sb.length() - 1));
			return;
		}

		for (int l = 1; l <= len - start; l++) {
			if (dp[start][l]) {
				String left = s.substring(start, start + l);
				if (dict.contains(left)) {
					if (l != len - start && !dp[start + l][len - start - l]) {
						continue;
					}
					int lastPos = sb.length();
					sb.append(left + " ");
					wordBreakHelper(start + l, s, dict, dp, result, sb);
					sb.delete(lastPos, sb.length());
				}
			}
		}
	}

	public static void main(String[] args) {
		String s = "catsanddog";
		Set<String> dict = new HashSet<>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		System.out.println(wordBreak(s, dict));

		// String s =
		// "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaav";
		// Set<String> dict = new HashSet<>();
		// dict.add("a");
		// dict.add("aa");
		// dict.add("aaa");
		// dict.add("aaaa");
		// dict.add("aaaaa");
		// dict.add("aaaaaa");
		// dict.add("aaaaaaa");
		// dict.add("aaaaaaaa");
		// dict.add("aaaaaaaaa");
		// dict.add("aaaaaaaaaa");

		// System.out.println(wordBreak(s, dict));
	}

}
