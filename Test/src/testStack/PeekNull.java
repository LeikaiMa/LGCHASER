package testStack;

import java.util.Stack;
// 说明在stack 为空的时候是不允许peek的
public class PeekNull {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		System.out.println(stack.peek());
	}
}
