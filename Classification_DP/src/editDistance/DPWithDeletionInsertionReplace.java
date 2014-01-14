package editDistance;
//V
//这题用DP 的方法来进行，因为可以通过三种形式来得到现在的值，一个是插入，对应的是i-1，j => i,j 一个删除 是 i，j-1  => i, j 
//还有一个是替换是i-1 j-1到i, j 但是这种情况还有一种情况就是两个在i j 位置上的本身就一样，这个情况就是和i-1 , j-1 相同，其他的情况都是要进行一步操作。
//base case 能够在表上填出来的是i 或者 j 为0 的时候，要由一方变成另一方，需要增加一方的个数，或者删除个数，这样就是i 或者 j
//然后判断现在这个位置两个元素是不是相同，要注意的是如果是因为dp 里面的表示长度，包括什么都没有的空字符串，所以找charAt 要-1
//如果不同就说明是通过其他的操作过来的，因为题目中要求操作数最少，就看这三个位置的操作数谁最少，因为最后都要统一+1.
//思路参考http://fisherlei.blogspot.com/2012/12/leetcode-edit-distance.html
//代码参考http://www.cnblogs.com/feiling/p/3272872.html

//相同的就是直接么有变化，由i-1 j-1 变过来的，如果不同就有三种可能删除添加和替代就是由三种不同的情况变过来的，因为要最少所以取的min
//因为这些都算做是一个有效操作，所以是要在最小值的基础上+1
public class DPWithDeletionInsertionReplace {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        
        if (len1 == 0) {
            return len2;
        }
        
        if (len2 == 0) {
            return len1;
        }
        
        int[][] dp = new int[len1 + 1][len2 + 1];
        
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    }
                }
            }
        }
        
        return dp[len1][len2];
     }
}
