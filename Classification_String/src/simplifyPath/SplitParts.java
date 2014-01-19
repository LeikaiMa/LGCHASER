package simplifyPath;
//VII
//这题主要要注意几个corner case 如果是 空的，或者是. 就跳过
//如果是 .. 看里面有没有值，如果没有值，就跳过，如果有值，像我用arraylist 就remove last 如果是用stack 就pop 出来。
//其他的都是直接插入。
//最后拼接的时候，看如果是空的，就返回/ 如果不是空的，就一个/ 一个内容。
//如果是arraylist 就正常拼接就可以了。如果是stack 就插在前面。
import java.util.ArrayList;
//这个写的时候犯了一个错误，就是将最后的合并的对象写错了，应该是result 而自己写成了parts
public class SplitParts {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "/";
        }
        
        String[] parts = path.split("/");
        ArrayList<String> result = new ArrayList<String>();
        
        for (String s : parts) {
            if (s.isEmpty() || s.equals(".")) {
                continue;
            }
            
            if (s.equals("..")) {
                if (!result.isEmpty()) {
                    result.remove(result.size() - 1);
                }
            } else {
                result.add(s);
            }
        }
        
        if (result.isEmpty()) {
            return "/";
        } else {
            StringBuffer sb = new StringBuffer();
            for (String s : result) {
                sb.append('/').append(s);
            }
            
            return sb.toString();
        }
    }
}
