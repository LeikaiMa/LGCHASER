package letterCombinationsOfAPhoneNumber;
//VII
//典型DFS的问题，用map 将里面对应的关系存起来，然后遍历的时候一层一层的加上去，然后进入，出来之后删去。知道到尾部，将buffer 的东西塞入最后结果里面
//注意点是没有时候用输出的“” 而不是空，
//而buffer 初始状态的情况也是赋值为“”
//然后buffer要删除的是delete 后面写index 而不是arraylist 里面的remove
import java.util.ArrayList;
import java.util.HashMap;
//这里面要注意的是将stringbuffer 在固定位置的char 删掉不是用delete ，因为delete 是一个范围，而是用的是deleteCharAt
public class StoreCorrespondingDigitsToChar {
    public ArrayList<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        StringBuffer sb = new StringBuffer();
        ArrayList<String> result = new ArrayList<String>();
        
        helper(digits, 0, result, sb, map);
        
        return result;
    }
    
    private void helper(String digits, int d, ArrayList<String> result, StringBuffer sb, HashMap<Character, String> map) {
        if (d == digits.length()) {
            result.add(sb.toString());
        } else {
            char c = digits.charAt(d);
            
            if (map.containsKey(c)) {
                String s = map.get(c);
                
                for (int i = 0; i < s.length(); i++) {
                    sb.append(s.charAt(i));
                    helper(digits, d + 1, result, sb, map);
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                helper(digits, d + 1, result, sb, map);
            }
        }
     }
}
