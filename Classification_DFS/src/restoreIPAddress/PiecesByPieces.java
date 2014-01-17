package restoreIPAddress;
//VI
//典型的DFS问题。总共每个片段有3种可能， 1， 2， 3 的长度。一共有depth 是5 因为开始的时候是1，如果开始是0 就是4
//base case 是如果到了5，说明前面已经累计了4个片段，其实可以不用这个，因为arraylist 里面的size 已经是有了几个片段，
//如果这个时候已经有4个片段了，但是还没有到结束那么就说明这种情况不成功。
//如果是正好到了最后，就将这个放进最后的结果里，去除多余的点是用substring 的方法。
//如果是在1-4层里面的时候，要注意的一点是，后面够不够1 2 3 种情况，如果已经不够，这种情况就跳过，就不继续dfs
//还有就是0 只能是一位表示，不能用两个0 或者三个0表示，这时候就要看substring 的第一位是不是0 而且位数如果大于1 就也是直接跳过，
//其他情况将substring 存进arraylist 然后继续下一层，因为是循环，DFS出来就将这个移除，加上新的
import java.util.ArrayList;
//这里数片段就直接用arraylist 存的个数，不需要用其他的参量
//主要是要注意0的情况，不能有00 这种。
public class PiecesByPieces {
	public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> results = new ArrayList<String>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (s == null || s.length() < 4) {
            return results;
        }
        helper(s, 0, results, result);
        
        return results;
    }
    
    public void helper(String s, int start, ArrayList<String> results, ArrayList<Integer> result) {
        if (result.size() == 4 && start == s.length()) {
            StringBuffer sb = new StringBuffer();
            for (int ip : result) {
                sb.append(ip);
                sb.append('.');
            }
            
            results.add(sb.substring(0, sb.length() - 1));
        } else if (result.size() < 4) {
            for (int i = 1; i <= 3; i++) {
                if (start + i <= s.length()) {
                    String tmp = s.substring(start, start + i);
                    if (i != 1 && tmp.charAt(0) == '0') {
                        continue;
                    }
                    
                    int ip = Integer.valueOf(tmp);
                    if (ip >= 0 && ip <= 255) {
                        result.add(ip);
                        helper(s, start + i, results, result);
                        result.remove(result.size() - 1);
                    }
                }
            }
        }
     }
}
