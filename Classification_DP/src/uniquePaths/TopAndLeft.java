package uniquePaths;
//III
//因为只有向右和向上走，所有走的方法都是基于上之前的走法。所以可以用DP
//先将第一行和第一列的都变成1，因为直走只有一种方法。
//然后每一格都是左边和下边的和，
//算完只需要去顶角的次数。
public class TopAndLeft {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        
        return dp[m - 1][n - 1];
     }
}
