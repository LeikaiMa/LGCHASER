package wordBreakII;
//IV
//完全用递归做太慢，考虑用DP 来进行
//首先定义DP的每一维的物理含义。 这里用了一个二维数组，第一维表示开始index 的位置，第二维表示字符串的长度，所以二维数组的有len 长， len+1宽
//因为DP是在前一个基础之上进行，所以外层循环用的是len 的长度，从1 到总的len
//内层循环用的是开始的index 但是要进行保证他和上面的加起来不能超过总的len ，这样能够全部覆盖起来。
//具体到里面来说，如果这个start 开始的len 长度的string 存在于dict 当中就说明这个是true
//如果不存在开始进行切割，看看左右两边是不是都是可以由dict 里面的词组成。因为是从长度1开始的，所以肯定 能够保证我要判断长的时候，短的已经判断完成。
//这样避免了重复运算。 最后看的是从0开始有len 长的字符串是不是可以由子字符串组成。 如果不行就直接返回空的。
//如果可以再进行判断是由哪些来进行组成。
//因为要将一个完整的组成部分输出出来所以用的是DFS
//base case 是我start到了最后一位也就是len 的长度，这时候就可以将buffer 里面存的 东西输入到arraylist 里面去，因为每次存的时候加入了 “ ”
//这个时候就要去buffer 里面的倒数第二位的，用到了substring
//如果不到最后一个，那么将这个字符串从左边拆一个一直拆到右边全部结束。 判断左边和右边是否是可以用dict 里面的词进行组装。用dp已经储存的虽然和下面看contain的效果一样，但是速度会更快。
//过滤完了之后在进行判断左边是不是确实可以由单个字典词组成。
//这里添加了一个进一步过滤，看右边词是不是可以由词典词组成，如果不能直接不进入递归中，利用之前已经算过的结果，虽然OJ的测试标明没有明显提升，但是应该是可以的。
//如果左边确实能够由单个的字典词组成，那么将他接到buffer 里面并且后面要加空格，但是因为循环过后不能变值，所以在递归之后要将原来的增加的词在buffer 里面删除。
//这样就能够将所有的排序都存到arraylist 里面。
//往往dp 的方法要比直接递归要快的多，因为不需要重复进行操作某些步骤，但是主要要思考，dp 这个表也就是这些维数怎么建，代表什么意义，怎么从最基本的开始进行填表。
//这题的思路就是在于从最短的1开始填，然后逐渐增加到len 长度。然后每个index 的都可以做头，然后具体的情况中就可以直接从这个二维数组中调用。

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
// 这题自己第二次做也没有完全想清楚，应该是从1开始到length 的每个长度，从index 为0 到最后的一位每一种情况先完全保存下来，
// 这里出的问题，是在index 遍历的时候应该是<= s.length() - len 开始没有考虑到可能会超出范围，后来又没有看到应该有等号的，至少有一种情况会存在，就是第一个0
// 然后先去看这个是不是就在dict 里面，因为这个dp 只是为了保存这一段有没有可能是单词组成的，所以如果自己不是单词，就应该从头到尾一点一点拆分，看前后两个部分是不是两个单词。只要一种情况是就说明是可以的。
// 得到了整个dp 就可以直接判断以0 开始，length 为长度是不是可以。同样从这里也可以看出整个dp 的前后两维代表的是这个含义。
// 如果是可以的，就说明可以将result 这个结果里塞candidate
// 如果是不可以的，就要直接返回了。
// 在里面找的时候同样也是从0 开始，因为是要找全部的，所以用的是DFS的方法，将从这个开始的所有情况先判断，自己左边是不是dict 里面的，因为之前dp 可以直接过滤一下，不用求substring 如果是再看substring 是不是
// 如果还是就先append 到里面，然后到下一层，直到index 到达了length
// 同样的情况也在于最后的时候也要删掉之前的，因为不是arraylist 进来的，用的是string buffer 一个要注意的delete 完全和substring 的形式是一样的，用的也是length() 而不是size()
public class StoreStartAndLength {
    public static ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> result = new ArrayList<String>();
        
        boolean[][] dp = new boolean[s.length()][s.length() + 1];
        
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                int start = i;
                int end = i + len;
                
                if (dict.contains(s.substring(start, end))) {
                    dp[i][len] = true;
                } else {
                    for (int k = 1; k < len; k++) {
                        if (dp[i][k] && dp[i + k][len - k]) {
                            dp[i][len] = true;
                            break;
                        }
                    }
                }
            }
        }
        
        if (dp[0][s.length()]) {
            StringBuffer sb = new StringBuffer();
            helper(result, dp, s, 0, sb, dict);
        } 
        
        return result;
    }
    
    private static void helper(ArrayList<String> result, boolean[][] dp, String s, int start, StringBuffer sb, Set<String> dict) {
        if (start == dp.length) {
            result.add(sb.substring(0, sb.length() - 1));
        } else {
            for (int i = 1; i <= dp.length - start; i++) {
                if (dp[start][i]) {
                    String left = s.substring(start, start + i);
                    if (dict.contains(left)) {
                        if (i != dp.length - start && !dp[start + i][dp.length - start - i]) {
                            continue;
                        }
                        
                        int lastIndex = sb.length();
                        sb.append(left + " ");
                        helper(result, dp, s, start + i, sb, dict);
                        sb.delete(lastIndex, sb.length());
                    }
                }
            }
        }
    }
    
    
    public static void main(String[] args) {
//    	String s = "a";
//		Set<String> dict = new HashSet<>();
//		dict.add("a");
//		System.out.println(wordBreak(s, dict));
		String s = "catsanddog";
		Set<String> dict = new HashSet<>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		System.out.println(wordBreak(s, dict));

		// String s =
		// "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaav";
		// Set<String> dict = new HashSet<>();
		// dict.add("a");
		// dict.add("aa");
		// dict.add("aaa");
		// dict.add("aaaa");
		// dict.add("aaaaa");
		// dict.add("aaaaaa");
		// dict.add("aaaaaaa");
		// dict.add("aaaaaaaa");
		// dict.add("aaaaaaaaa");
		// dict.add("aaaaaaaaaa");

		// System.out.println(wordBreak(s, dict));
	}

}
