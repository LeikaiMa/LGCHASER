package regularExpressionMatching;
// 这里用了递归的方法来解决这个问题，要考虑的就不是怎么储存数值，而是看base case 和直接返回的值。
// 用了DFA的方法，base case 是当p 到了最后一位，s 也应该到最后一位，如果没有到最后一位，就应该返回错。
// 如果后面不是紧跟* 就说明应该是一个一个进行匹配的，
// 这有两种情况，一种最后就剩一个，还有一个就是超过一个但是后面不是*， 因为java 中不能超过范围，所以只能先考虑是不是只有一个的情况。
// 因为有base case 处理是否到尾的情况，那就只要考虑是不是单个是错误的。
// 如果p 剩最后一个，但是S 已经没有了，说明不匹配，p过多。如果不是这种情况，那么看p是不是完全匹配的“.”，如果不是就要看p 和s 在这一位上是否相等。
// 这些情况都是找出false 的情况。 如果都合适，就p和s 都往后移动一位。递归到下一层
// 如果后面是*，那么就要考虑一个一个往后是不是相同，他可以进行匹配0个到无数个。
// 所以开始的时候用作-1 来进去，因为是要加上一种情况是将这个p 过滤掉，所以-1 的时候无条件进行，substring 是从0 开始的，但是p 是过滤掉进行，
// 之后要一个一个进行比较。 所以之后i 就变成0 一直到len - 1 如果p 是 . 或者两个能进行匹配，这时候可以进行匹配后面的，将p+2而且s substring i + 1到后面，从而进行递归进去匹配。
// 如果一个一个进行比较完了还是不行，那么就是*的就不能进行匹配了。直接返回false
public class DFA {
	public static boolean isMatch(String s, String p) {
		if (p.length() == 0) {
			return s.length() == 0;
		}

		if (p.length() == 1 || p.charAt(1) != '*') {
			if (s.length() < 1
					|| (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0))) {
				return false;
			} else {
				return isMatch(s.substring(1), p.substring(1));
			}
		} else {
			int i = -1;
			while (i < s.length()
					&& (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s
							.charAt(i))) {
				if (isMatch(s.substring(i+ 1), p.substring(2))) {
					return true;
				}
				i++;
			}

			return false;
		}

	}

	public static void main(String[] args) {
		System.out.println(isMatch("aaa", "ab*a*c*a") == true);
		System.out.println(isMatch("aa", "a") == false);
		System.out.println(isMatch("aa", "aa") == true);
		System.out.println(isMatch("aaa", "aa") == false);
		System.out.println(isMatch("aa", "a*") == true);
		System.out.println(isMatch("aa", ".*") == true);
		System.out.println(isMatch("ab", ".*") == true);
		System.out.println(isMatch("aab", "c*a*b") == true);
	}
}
