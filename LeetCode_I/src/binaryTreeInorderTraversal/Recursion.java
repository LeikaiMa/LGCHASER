package binaryTreeInorderTraversal;

import java.util.ArrayList;

public class Recursion {
	public static ArrayList<Integer> InOderTraversal(TreeNode root) {
		ArrayList<Integer> t = new ArrayList<>();
		t = InOderTraversal(root, t);
		return t;
	}

	private static ArrayList<Integer> InOderTraversal(TreeNode root,
			ArrayList<Integer> t) {
		if (root != null) {
			InOderTraversal(root.left, t);
			t.add(root.val);
			InOderTraversal(root.right, t);
		}
		return t;
	}

	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		one.right = two;
		two.left = three;
		ArrayList<Integer> inOderTraversal = InOderTraversal(one);
		System.out.println(inOderTraversal.toString());
	}
}
