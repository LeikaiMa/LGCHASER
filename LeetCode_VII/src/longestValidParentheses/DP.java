package longestValidParentheses;
// 这个是一个比较巧妙的dp 的方法，思路是利用了了解了有效括号的真正内涵。
// 是两种情况一种是包含，还有一种是两个相邻。
// 所以dp 里面记录整个的len，首先检查自己是不是(，因为所有的长度都存在(里面，看右边的是不是合理的()如果是里面就有size 如果不是就是0.
// 然后用i + dp [i+1] 这个后面一个就是看有没有匹配的)所以要再加上1，但是这些都是要注意的是时刻关注不能超过array 的范围所以要先进行判断，
// 如果是) 则说明现在这个是在里面有效括号长度的基础上+2
// 这个是最基本的长度，是至少的长度。
// 如果旁边还有()则要再增加，
// 所以要判断i + dp[i+1] + 1 +1是不是有效的括号，但同样还是要判断有没有超过界限。
// 这要每次得到一个值就去和存的值进行比较。取大值，最后返回这个大值。
// 比较巧妙，理解了其中的特性。
public class DP {
	public static int longestValidParentheses(String s) {
		if (s == null || s.length() == 0 || s.length() == 1) {
			return 0;
		}

		int[] dp = new int[s.length()];
		int max = 0;
		int len = s.length();
		for (int i = len - 2; i >= 0; i--) {
			if (s.charAt(i) != '(') {
				continue;
			}
			int j = i + 1 + dp[i + 1];
			if (j < len && s.charAt(j) == ')') {
				dp[i] = dp[i + 1] + 2;
				if (j + 1 < len) {
					dp[i] += dp[j + 1];
				}
				max = Math.max(dp[i], max);
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(longestValidParentheses(")()())") == 4);
		System.out.println(longestValidParentheses("()(()") == 2);
		System.out.println(longestValidParentheses("()(())") == 6);
	}
}
