package interleavingString;
// 这题差一点就想到DP 的方法，因为是两个字符串依次填进去，所以有个次序，一个二维数组表示这个时候填的是哪个字符串的哪个位置的字母。
// 而且[n][m]可以有两种形式得到[n-1][m] 和[n][m-1]两种情况得到。这个时候要看n 这个位置和n+m这个位置的字母相不相同，而且之前能不能从[n-1][m]得到
// 同理可以看m 这个相不相等，能不能从m-1这个地方得到。这样子就有递推公式得到 dp[n-1][m] && s1(n-1) = s3(n+m-1) || dp[n][m-1] && s2(m-1)=s3(n+m-1)
// 然后开始填表，是一个n+1 m+1 的二维表。 开始填基础的情况，开始两个都是空的时候肯定是true 然后是0 行 和0 列的地方，看这个是不是能够正好s1 匹配s3 s2 匹配 s3
// 然后根据递推公式将所有的全部的都递推出来
// 最后的结果就是n 和 m 的那一格的boolean 值
// 还有一种方法是类似于DFS 的，不过再从后往前比，进行剪枝。
// http://blog.unieagle.net/2012/09/29/leetcode%E9%A2%98%E7%9B%AE%EF%BC%9Ainterleaving-string%EF%BC%8C%E4%BA%8C%E7%BB%B4%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92/
public class DP {
	public static boolean isInterleave(String s1, String s2, String s3) {
		if (s1.isEmpty()) {
			return s3.equals(s2);
		}
		if (s2.isEmpty()) {
			return s3.equals(s1);
		}
		int l1 = s1.length();
		int l2 = s2.length();
		int l3 = s3.length();
		if (l3 != l1 + l2) {
			return false;
		}

		boolean[][] dp = new boolean[l1 + 1][l2 + 1];
		dp[0][0] = true;
//		这边其实可以再减小，因为一旦一个不行了之后后面肯定不可能从前面得到。
		for (int i = 0; i < l1; i++) {
			dp[i + 1][0] = (s1.charAt(i) == s3.charAt(i));
		}

		for (int i = 0; i < l2; i++) {
			dp[0][i + 1] = (s2.charAt(i) == s3.charAt(i));
		}

		for (int i = 1; i <= l1; i++) {
			for (int j = 1; j <= l2; j++) {
				dp[i][j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j])
						|| (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1]);
			}
		}

		return dp[l1][l2];
	}
	
	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		System.out.println(isInterleave(s1, s2, "aadbbcbcac"));
		System.out.println(isInterleave(s1, s2, "aadbbbaccc"));
	}
}
