package distinctSubsequences;
// 运用DP 的方法一步一步添加，先在开头的地方加上两个空的字符，作为递归的条件，他们肯定是相等的，所以在最开始的一个填的是1， 
// 然后横着的一行，因为肯定都和空的字符不同，所以都是删除的动作，所以和前面的相同，也就是1
// 竖着的第一列，因为肯定和空的字符不同，所以是0.
// 然后每一行进行一次填充，因为整个的dp的横着的表示要进行比较的，竖着的是标准的，也就是横着的要比竖着的长。
// 所以只有两种可能一种是删除一种是保留。如果是相同的值说明是可以保留替换的，如果不同就是要标明删除的，所以就是有两种途径。
// 一种删除就是和左边的个数是相同的，一种是替换这就标明的是从左斜上依次过来的，所以他的次数和左斜上方的次数是相同的。这也是为什么开头要加空字符的原因。
// 为了最开始的时候有个base case
// 一次到最右下角的一个就是标明完全比较完了之后最后的结果。
// 一种小优化是左下角的大部分都是0 没有用到。可以省略计算。但下面没有进行类似的优化。
public class OnePassDP {
	public int numDistinct(String S, String T) {
		if (S.length() < T.length()) {
			return 0;
		}

		if (T.length() == 0 && S.length() != 0) {
			return 1;
		}

		if (T.length() == 0 && S.length() == 0) {
			return 1;
		}

		int[][] dp = new int[T.length() + 1][S.length() + 1];
		for (int i = 0; i <= S.length(); i++) {
			dp[0][i] = 1;
		}
		for (int i = 1; i <= T.length(); i++) {
			dp[i][0] = 0;
		}
		for (int i = 1; i <= T.length(); i++) {
			for (int j = 1; j <= S.length(); j++) {
				dp[i][j] = dp[i][j - 1];
				if (T.charAt(i - 1) == S.charAt(j - 1)) {
				
					dp[i][j] += dp[i - 1][j - 1];
				}
			}
		}
		return dp[T.length()][S.length()];
	}
	
	public static void main(String[] args) {
		String S = "ABCDE";
		String T = "AEC";
//		 String S = "rabbbit";
//		 String T = "rabbit";
//		 String S = "aacaacca";
//		 String T = "ca";
		System.out.println(new OnePassDP().numDistinct(S, T));
	}
}
