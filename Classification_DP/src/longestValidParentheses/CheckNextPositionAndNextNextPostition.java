package longestValidParentheses;
//VII
//这个是一个比较巧妙的dp 的方法，思路是利用了了解了有效括号的真正内涵。
//是两种情况一种是包含，还有一种是两个相邻。
//所以dp 里面记录整个的len，首先检查自己是不是(，因为所有的长度都存在(里面，看右边的是不是合理的()如果是里面就有size 如果不是就是0.
//然后用i + dp [i+1] 这个后面一个就是看有没有匹配的)所以要再加上1，但是这些都是要注意的是时刻关注不能超过array 的范围所以要先进行判断，
//如果是) 则说明现在这个是在里面有效括号长度的基础上+2
//这个是最基本的长度，是至少的长度。
//如果旁边还有()则要再增加，
//所以要判断i + dp[i+1] + 1 +1是不是有效的括号，但同样还是要判断有没有超过界限。
//这要每次得到一个值就去和存的值进行比较。取大值，最后返回这个大值。
//比较巧妙，理解了其中的特性。

//首先是看后一个是不是(如果是到她对应长度下的后一个看是不是) 如果是，就是长度+2 然后再看再往后是不是也是() 如果也是的话，就再加上长度。
//这个就是要看思路到底请不清晰，还有一个就是从大往小的应该是--
public class CheckNextPositionAndNextNextPostition {
	public int longestValidParentheses(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                continue;
            } else {
                if ((i + dp[i + 1] + 1) < s.length() && s.charAt(i + dp[i + 1] + 1) == ')') {
                    dp[i] = dp[i + 1] + 2;
                    
                    if (dp[i] + i < s.length()) {
                        dp[i] += dp[dp[i] + i];
                    }
                    
                    max = Math.max(max, dp[i]);
                }
            }
        }
        
        return max;
    }
}
