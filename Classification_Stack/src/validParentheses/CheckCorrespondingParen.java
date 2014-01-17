package validParentheses;
//VI
//找括号匹配的方法，也就是用stack 进行存储左括号的方法，然后右括号看pop 出来的是不是对应的是左括号，但是pop 要看是否是empty 如果是empty 也是错的。
//最后全部结束了，看stack 是不是空的。如果是就是成功，如果不是就不成功
import java.util.Stack;

public class CheckCorrespondingParen {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop();
                }
            } else if (c == '}') {
                if (stack.isEmpty() || stack.peek() != '{') {
                    return false;
                } else {
                    stack.pop();
                }
            } else  if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
