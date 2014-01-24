package levelOrderTraversal;
//这个是利用一个queue 来解决问题的方法，不过是要通过两个计数器来对里面的个数技术，每执行一次就将当前level 的数值-1，然后如果加上新的就在下一层的level +1
//直到这一层的个数为0，就将这一层的数值改成下一层的数值。然后下一层的记为0；
import java.util.LinkedList;
import java.util.Queue;

public class OneQueue {
	public void printLevelOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int nodesInCurrentLevel = 1;
		int nodesInNextLevel = 0;

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.println(node.val + " ");
			nodesInCurrentLevel--;
			if (root.left != null) {
				queue.add(root.left);
				nodesInNextLevel++;
			}
			if (root.right != null) {
				queue.add(root.right);
				nodesInNextLevel++;
			}
			if (nodesInCurrentLevel == 0) {
				System.out.println();
				nodesInCurrentLevel = nodesInNextLevel;
				nodesInNextLevel = 0;
			}
		}

	}
}
