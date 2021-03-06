package longestValidParentheses;
// 自己根据cluster merge 想出来的一种方法，原理做完之后想的还是比较简单
// 因为不同于判断是否是valid，这里如果遇到不合理的还要塞进去，也就是) 在stack 是空的时候或者前面一个是) 的时候仍然要塞进去。
// 如果是遇到( 那么将里面pop 出来，因为里面只存在()这些有效的，那么( ) 这两个index 就可以算出这两个的size， 这时候看左边有没有之前已经成型的()如果有的就可以进行合并。
// 然后把新的size 和右括号塞进去，因为一直是向右走，所以只有右括号有用。其实只要预存一个右括号就可以了，因为只要看相邻的一个就可以了。
// 因为要算size，所以( 的index 也要存进去了。
import java.util.HashMap;
import java.util.Stack;

public class UseStack {
	public static int longestValidParentheses(String s) {
		if (s == null || s.length() == 0 || s.length() == 1) {
			return 0;
		}

		HashMap<Integer, Integer> parenIndex = new HashMap<Integer, Integer>();

		Stack<Character> paren = new Stack<Character>();
		Stack<Integer> index = new Stack<Integer>();
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(') {
				paren.push(c);
				index.push(i);
			} else {
				if (paren.isEmpty() || paren.peek() == ')') {
					paren.push(c);
					index.push(i);
				} else {
					int leftIndex = index.pop();
					int size = i - leftIndex + 1;
					paren.pop();

					if (parenIndex.containsKey(leftIndex - 1)) {
						parenIndex.put(i, parenIndex.get(leftIndex - 1) + size);
						max = Math.max(max, parenIndex.get(i));
					} else {
						parenIndex.put(i, size);
						max = Math.max(max, size);
					}
				}
			}
		}

		return max;

	}

	public static void main(String[] args) {
		System.out.println(longestValidParentheses(")()())") == 4);
		System.out.println(longestValidParentheses("()(()") == 2);
		System.out.println(longestValidParentheses("()(())") == 6);
	}

}
