package preorderTraversal;

import java.util.ArrayList;
import java.util.Stack;
// 这里同样的使用stack 来进行存储，但是这个比post 要简单的是，遇到了就直接存进结果里面。不用保存状态。
public class Iterative {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			if (cur.right != null) {
				stack.push(cur.right);
			}
			if (cur.left != null) {
				stack.push(cur.left);
			}
			result.add(cur.val);
		}
		return result;
	}
}
