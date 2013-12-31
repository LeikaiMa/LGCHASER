package binaryTreePostorderTraversal;
// 一般这种用的不用递归就用的stack 或者是queue作为存储的情况，因为这里要找后面的情况，所以要多加一个stack 进行保存这个状态是否是visited
import java.util.ArrayList;
import java.util.Stack;

public class Iterative {
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<Boolean> visited = new Stack<Boolean>();
		if (root == null) {
			return result;
		}

		stack.push(root);
		visited.push(false);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			if (!visited.pop()) {
				TreeNode left = cur.left;
				TreeNode right = cur.right;
				stack.push(cur);
				visited.push(true);
				if (right != null) {
					stack.push(right);
					visited.push(false);
				}
				if (left != null) {
					stack.push(left);
					visited.push(false);
				}
			} else {
				result.add(cur.val);
			}
		}
		return result;
	}
}
