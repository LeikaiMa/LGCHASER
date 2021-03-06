package binaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.Stack;

public class Iterative {

	public static ArrayList<Integer> InOderTraversal(TreeNode root) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		Stack<TreeNodeVisited> stack = new Stack<TreeNodeVisited>();
		if (root == null) {
			return arrayList;
		}
		if (root.right != null) {
			stack.push(new TreeNodeVisited(root.right, false));
		}

		stack.push(new TreeNodeVisited(root, true));

		if (root.left != null) {
			stack.push(new TreeNodeVisited(root.left, false));
		}

		while (!stack.isEmpty()) {
			TreeNodeVisited node = stack.pop();
			TreeNode cur = node.node;
			TreeNode right = node.node.right;
			TreeNode left = node.node.left;
			// || (right == null && left == null)
			if (node.visited) {
				arrayList.add(node.node.val);
			} else {
				if (right != null) {
					stack.push(new TreeNodeVisited(right, false));
				}
				stack.push(new TreeNodeVisited(cur, true));
				if (left != null) {
					stack.push(new TreeNodeVisited(left, false));
				}
			}
		}
		return arrayList;

	}

	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		one.right = two;
		one.left = four;
		two.left = three;
		ArrayList<Integer> inOderTraversal = InOderTraversal(one);
		System.out.println(inOderTraversal.toString());
	}
}
