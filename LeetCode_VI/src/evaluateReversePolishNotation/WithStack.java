package evaluateReversePolishNotation;

import java.util.Stack;
// 这道题主要是要掌握计算的思路和方法，如果遇到数字就往里面push到stack 如果是遇到符号，那么将里面pop 出来两个，先pop 出来的是第二个， 后pop 出来的是第一个。
// 然后计算的公式是first 符号然后是 second
// 然后再把结果push 进去，
// 结束之后stack 剩下的就是最终的结果。
// 如果是polish 的是要从尾部开始做同样的操作。也是用的是stack
public class WithStack {
	public int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0) {
			return 0;
		}

		Stack<Integer> members = new Stack<Integer>();

		for (int i = 0; i < tokens.length; i++) {
			String element = tokens[i];
			int first = 0;
			int second =0;
			if (element.equals("+")) {
				second = members.pop();
				first = members.pop();
				members.push(first + second);
			} else if (element.equals("-")) {
				second = members.pop();
				first = members.pop();
				members.push(first - second);
			} else if (element.equals("*")) {
				second = members.pop();
				first = members.pop();
				members.push(first * second);
			} else if (element.equals("/")) {
				second = members.pop();
				first = members.pop();
				members.push(first / second);
			} else {
				members.push(Integer.valueOf(element));
			}
		}
		return members.peek();
	}
}
