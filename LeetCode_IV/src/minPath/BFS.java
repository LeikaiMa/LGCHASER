package minPath;

import java.util.LinkedList;
import java.util.Queue;
//  这里是BFS 的一行一行输出，要注意的是两个都是null 就直接输出。
// 而加left 或者right的时候不是if else 的关系。而是并列的关系。因为两边可能都有
public class BFS {
	public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int depth = 0;
		while (true) {
			depth++;
			Queue<TreeNode> tmp = new LinkedList<TreeNode>();
			for (TreeNode node : queue) {
				if (node.left == null && node.right == null) {
					return depth;
				}
				if (node.left != null) {
					tmp.add(node.left);
				}
				if (node.right != null) {
					tmp.add(node.right);
				}
			}
			queue = tmp;
		}
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		System.out.println(minDepth(t1));

	}
}
