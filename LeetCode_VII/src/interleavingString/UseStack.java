package interleavingString;

import java.util.Stack;
// 这个类似用的是DFS 的方法，用stack 储存每次的情况，如果到头之后不行，就将里面的可能情况pop 出来，
// 然后这个两边也类似于left 和right child 一样，可以考虑是不是从两边哪一边进行取值。
// 但这个有些会进行重复计算，所以耗时。看到这个还得用DP的方法。
public class UseStack {
	public static boolean isInterleave(String s1, String s2, String s3) {
		if (s1.isEmpty()) {
			return s3.equals(s2);
		}
		if (s2.isEmpty()) {
			return s3.equals(s1);
		}
		int l1 = s1.length();
		int l2 = s2.length();
		int l3 = s3.length();
		if (l3 != l1 + l2) {
			return false;
		}

		char c1 = s1.charAt(0);
		char c2 = s2.charAt(0);
		char c3 = s3.charAt(0);

		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		Stack<Integer> stack3 = new Stack<Integer>();

		if (c1 == c3) {
			stack1.push(1);
			stack2.push(0);
			stack3.push(1);
		}

		if (c2 == c3) {
			stack1.push(0);
			stack2.push(1);
			stack3.push(1);
		}

		while (!stack3.isEmpty()) {
			int i1 = stack1.pop();
			int i2 = stack2.pop();
			int i3 = stack3.pop();
			if (i1 == l1 && i2 == l2 && i3 == l3) {
				return true;
			}

			if (i1 < l1 && s1.charAt(i1) == s3.charAt(i3)) {
				stack1.push(i1 + 1);
				stack2.push(i2);
				stack3.push(i3 + 1);
			}

			if (i2 < l2 && s2.charAt(i2) == s3.charAt(i3)) {
				stack1.push(i1);
				stack2.push(i2 + 1);
				stack3.push(i3 + 1);
			}

		}

		return false;
	}

	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		System.out.println(isInterleave(s1, s2, "aadbbcbcac"));
		System.out.println(isInterleave(s1, s2, "aadbbbaccc"));
	}

}
