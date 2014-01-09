package binaryTreePreorderTraversal;
// II
//这里同样的使用stack 来进行存储，但是这个比post 要简单的是，遇到了就直接存进结果里面。不用保存状态。
import java.util.ArrayList;
import java.util.Stack;

public class StackToStoreIterative {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			result.add(node.val);

			if (node.right != null) {
				stack.push(node.right);
			}

			if (node.left != null) {
				stack.push(node.left);
			}
		}

		return result;
	}
}
