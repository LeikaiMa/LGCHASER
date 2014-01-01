package validParentheses;
// 找括号匹配的方法，也就是用stack 进行存储左括号的方法，然后右括号看pop 出来的是不是对应的是左括号，但是pop 要看是否是empty 如果是empty 也是错的。
// 最后全部结束了，看stack 是不是空的。如果是就是成功，如果不是就不成功
import java.util.Stack;

public class StackWay {
	public static boolean isValid(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		if (s.length() % 2 == 1) {
			return false;
		}
		Stack<Character> paren = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '{' || c == '[' || c == '(') {
				paren.push(c);
				continue;
			}
			switch (c) {
			case '}':
				if (paren.isEmpty() || paren.pop() != '{') {
					return false;
				}
				break;
			case ']':
				if (paren.isEmpty() || paren.pop() != '[') {
					return false;
				}
				break;
			default:
				if (paren.isEmpty() || paren.pop() != '(') {
					return false;
				}
				break;
			}
		}
		if (paren.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		String paren = "()[]{}";
		System.out.println(isValid(paren) == false);
	}
}
