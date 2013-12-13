package binaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.Stack;
// 对于要iteration而不用recursion的方法，一种很常见的就是用STACK 或者是QUEUE 来预先存储。类似于BFS之类的，然后用while 进行循环处理。
// 无论是怎么样的排序按照排序的规则往里面存，然后取出来的规则就可以区分到底用的是stack 还是用的是Queue。
// 然后用标记到底如何的方法，目前有两种，一种是建一个wrapper 的class ，然后存除了本身之外的第二个参量。
// 或者用的是本题采用的方法，两个统一步骤的数据结构，这样也可以达到同样的效果。

public class TwoStackIterative {

	public static ArrayList<Integer> InOderTraversal(TreeNode root) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<Boolean> stack2 = new Stack<Boolean>();
		if (root == null) {
			return arrayList;
		}
		insertStack(root, stack1, stack2);

		while (!stack1.isEmpty()) {
			TreeNode node = stack1.pop();
			Boolean visited = stack2.pop();
			if (visited) {
				arrayList.add(node.val);
			} else {
				insertStack(node, stack1, stack2);
			}
		}
		return arrayList;

	}
	
	
	public static void insertStack(TreeNode root, Stack<TreeNode> stack1, Stack<Boolean> stack2) {
		if (root.right != null) {
			stack1.push(root.right);
			stack2.push(false);
		}
		
		stack1.push(root);
		stack2.push(true);

		if (root.left != null) {
			stack1.push(root.left);
			stack2.push(false);
		}
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
