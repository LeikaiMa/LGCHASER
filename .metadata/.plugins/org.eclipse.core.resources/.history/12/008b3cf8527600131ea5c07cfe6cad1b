package binaryTreeInorderTraversal;
// 要注意的是生成新的变量。而不能不生成就用。
// 这个是先root 变成cur
// 然后直接一直往左走，每走一步push 到stack 里面，直到没有的时候， 将里面的值pop 出来，放进答案里面去，然后cur 变成right 然后继续循环。
// 加上boolean 判断，这样可以让开头不用先将root push 进去，否则判断empty 的时候，就不好判断了，这样默认第一次金循环。
// 第一次执行完以后将 判断是不是empty 如果是empty 的话就变成true 然后跳出循环。
// 有助于里面cur 直接比较而不用比较cur.left
import java.util.ArrayList;
import java.util.Stack;

public class OneStack {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> results = new ArrayList<Integer>();
		boolean done = false;
		TreeNode cur = root;
		Stack<TreeNode> nodes = new Stack<TreeNode>();
		while (!done) {
			if (cur != null) {
				nodes.push(cur);
				cur = cur.left;
			} else {
				if (nodes.isEmpty()) {
					done = true;
				} else {
					TreeNode node = nodes.pop();
					results.add(node.val);
					cur = node.right;
				}
			}
		}
		return results;
	}
}
