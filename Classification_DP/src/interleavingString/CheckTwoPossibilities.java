package interleavingString;
//VII
//这题差一点就想到DP 的方法，因为是两个字符串依次填进去，所以有个次序，一个二维数组表示这个时候填的是哪个字符串的哪个位置的字母。
//而且[n][m]可以有两种形式得到[n-1][m] 和[n][m-1]两种情况得到。这个时候要看n 这个位置和n+m这个位置的字母相不相同，而且之前能不能从[n-1][m]得到
//同理可以看m 这个相不相等，能不能从m-1这个地方得到。这样子就有递推公式得到 dp[n-1][m] && s1(n-1) = s3(n+m-1) || dp[n][m-1] && s2(m-1)=s3(n+m-1)
//然后开始填表，是一个n+1 m+1 的二维表。 开始填基础的情况，开始两个都是空的时候肯定是true 然后是0 行 和0 列的地方，看这个是不是能够正好s1 匹配s3 s2 匹配 s3
//然后根据递推公式将所有的全部的都递推出来
//最后的结果就是n 和 m 的那一格的boolean 值
//还有一种方法是类似于DFS 的，不过再从后往前比，进行剪枝。
//http://blog.unieagle.net/2012/09/29/leetcode%E9%A2%98%E7%9B%AE%EF%BC%9Ainterleaving-string%EF%BC%8C%E4%BA%8C%E7%BB%B4%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92/
public class CheckTwoPossibilities {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null) {
            return false;
        }
        
        if ((s1.length() + s2.length()) != s3.length()) {
            return false;
        } 
        
        int len1 = s1.length();
        int len2 = s2.length();
        
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        
        for (int i = 1; i <= len1; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[i][0] = true;
            } else {
                break;
            }
        }
        
        for (int j = 1; j <= len2; j++) {
            if (s2.charAt(j - 1) == s3.charAt(j - 1)) {
                dp[0][j] = true;
            } else {
                break;
            }
        }
        
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if ((dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1))) {
                    dp[i][j] = true;
                }
            }
        }
        
        return dp[len1][len2];
    }
}
