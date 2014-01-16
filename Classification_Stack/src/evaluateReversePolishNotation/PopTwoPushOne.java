package evaluateReversePolishNotation;
//VI
//这道题主要是要掌握计算的思路和方法，如果遇到数字就往里面push到stack 如果是遇到符号，那么将里面pop 出来两个，先pop 出来的是第二个， 后pop 出来的是第一个。
//然后计算的公式是first 符号然后是 second
//然后再把结果push 进去，
//结束之后stack 剩下的就是最终的结果。
//如果是polish 的是要从尾部开始做同样的操作。也是用的是stack
import java.util.Stack;

public class PopTwoPushOne {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        
        for (String s : tokens) {
            if (s.length() > 1 || Character.isDigit(s.charAt(0))) {
                stack.push(Integer.valueOf(s));
            } else {
                int second = stack.pop();
                int first = stack.pop();
                
                char c = s.charAt(0);
                
                switch (c) {
                    case '+' : 
                        stack.push(first + second);
                        break;
                    case '-' :
                        stack.push(first - second);
                        break;
                    case '*' :
                        stack.push(first * second);
                        break;
                    default :
                        stack.push(first / second);
                        break;
                }
                
            }
        }
        
        return stack.pop();
    }
}
