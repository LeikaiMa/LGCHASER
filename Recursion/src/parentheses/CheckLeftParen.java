package parentheses;

import java.util.HashSet;
import java.util.Set;

// 看到all 之类的很大一种可能性就是递归。
// 这种题目一般可以是通过数学归纳法来求出来。
// 通过观察可以看到后一个加括号可以在前一种情况下增加。如果碰到一个左括号，可以在左括号后面加一个完整的括号。
// 还有一种情况是直接加在整个前面。
// 这里的base case 是如果是条件为0的情况，是一个“”
// 要插入东西仍然是用substring 将字符串进行截断，然后用加法直接插入。
// 因为里面可能会有重复的，所以用set 来进行去重。

public class CheckLeftParen {
	public static Set<String> generateParens(int remaining) {
		Set<String> set = new HashSet<String>();
		if (remaining == 0) {
			set.add("");
		} else {
			Set<String> prev = generateParens(remaining - 1);
			for (String str : prev) {
				for (int i = 0 ; i < str.length(); i++) {
					if (str.charAt(i) == '(') {
						String s = insertInside(str, i);
						set.add(s);
					}
				}
				
				if (!set.contains("()" +str)) {
					 set.add("()" + str);
				}
			}
		}
		return set;
	}

	private static String insertInside(String str, int leftIndex) {
		String left = str.substring(0, leftIndex + 1);
		String right = str.substring(leftIndex + 1, str.length());
		return left + "()" + right;
	}
}
