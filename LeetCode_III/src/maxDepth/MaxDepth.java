package maxDepth;

import java.util.LinkedList;
import java.util.Queue;
// 找最深的depth 就是要用类似于BFS的方法，用一个QUEUE 来统一存一层的node
// 然后存下一层的，进行交换，直到空。
// 返回的循环次数就是depth
public class MaxDepth {
	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		q1.add(root);
		int depth = 0;
		
		while (!q1.isEmpty()) {
			depth++;
			Queue<TreeNode> tmp = new LinkedList<TreeNode>();
			for (TreeNode node : q1) {
				if (node.left != null) {
					tmp.add(node.left);
				}
				if (node.right != null) {
					tmp.add(node.right);
				}
			}
			q1 = tmp;
		}
		
		return depth;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		System.out.println(maxDepth(root));
	}
}
