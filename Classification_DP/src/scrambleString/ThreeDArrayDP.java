package scrambleString;
// III
//往往递归都可以用作DP
//这里建出三维数组，第一维指的是两个string 的长度。第二位是两个string 开始位置。
//首先可以写出基础的，当长度为1只要比较当前那一个元素是不是相同就可以知道是否是scramble
//然后从2 开始一直到length， 因为长度是从小到大，这样最好是从两个字符串的后面开始往前，判断将这些长度进行各种形式的拆分，两个substring 是不是scramble
//因为之前的值都存进数组当中，只要从里面取值就可以了。
//最后返回的是起始位置为0 长度为length 的两个字符串是不是scramble
//判断是不是scramble 也是同样的方法，不同起始点，切割相同的长度，看两个是不是相同。 因为之前是从最小的1开始，肯定前面的情况都已经考虑进去了。
//只要从数组里取就可以直接得到以前计算的结果。

//分析这道题的本质，求两个string 是不是 scramble string 
//如果两个相同就是
//如果不相等将这个两个string 进行等间距的拆分，左边如果和左边是scramble 右边和右边是scramble 就是。
//或者是相反进行拆分，左和右是scramble 右和左 是scramble则是
//这里用到一个递归。
//如果只有一个直接比较就可以知道，如果不是一个，首先进行sort 看是不是最基本的个数和元素就不对应，如果不对应直接返回false 不用继续进行递归。
//之后一个一个遍历，进行拆分，拆分的时候然后进行递归进行比较是不是scramble。
//只要一个是就可以返回是scramble
public class ThreeDArrayDP {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        
        int len = s1.length();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        
        boolean[][][] dp = new boolean[len + 1][len][len];
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (c1[i] == c2[j]) {
                    dp[1][i][j] = true;
                }
            }
        }
        
        for (int k = 2; k <= len; k++) {
            for (int i = len - k; i >= 0; i--) {
                for (int j = len - k; j >= 0; j--) {
                    for (int m = 1; m < k; m++) {
                        if ((dp[m][i][j] && dp[k - m][i + m][j + m]) || (dp[m][i][j + k - m] && dp[k - m][i + m][j])) {
                            dp[k][i][j] = true;
                            break;
                        }
                    }
                }
            }
        }
        
        return dp[len][0][0];
    }
}
