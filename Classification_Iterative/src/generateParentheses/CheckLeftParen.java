package generateParentheses;
//VI
//括号的不同形式，是从最开始的空的开始，开始往里面插括号，原则是插在最开始的，遇到一个左边的括号，插在左边的括号后面，
//要注意，自己第一次出错是在将开始插（）放在内层的循环里面。实际上应该是放在外城的循环里面。原来用的是递归的方法，其实可以用两个hashset 进行轮换的方法，实现iterative 的方法，执行的次数是n 的大小。
//储存的形式因为可能有重复的，所以用的是hashset 来进行储存。
import java.util.ArrayList;
import java.util.HashSet;
//要注意的是可以是从0 开始，放进是“” 的。可以参考原来写的。
public class CheckLeftParen {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        if (n == 0) {
            return result;
        }
        
        HashSet<String> level = new HashSet<String>();
        level.add("()");
        
        for (int index = 1; index < n; index++) {
            HashSet<String> tmp = new HashSet<String>();
            for (String s : level) {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '(') {
                        StringBuffer sb = new StringBuffer();
                        sb.append(s.substring(0, i + 1));
                        sb.append("()");
                        sb.append(s.substring(i + 1));
                        tmp.add(sb.toString());
                    }
                }
                tmp.add("()" + s);
            }
            
            level = tmp;
        }
        
        result.addAll(level);
        return result;
    }
}
