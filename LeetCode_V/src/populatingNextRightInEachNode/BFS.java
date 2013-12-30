package populatingNextRightInEachNode;
// 这个是一个比较简单的题目，就是用的是level travesal 的方法，然后在每次找child 的之前，将自己 和自己的右边的一个连起来。
// 因为是默认right 是null 所以是size -1 个要连，注意好这点就可以了
import java.util.ArrayList;

public class BFS {
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}

		ArrayList<TreeLinkNode> nodes = new ArrayList<TreeLinkNode>();
		nodes.add(root);

		while (!nodes.isEmpty()) {
			ArrayList<TreeLinkNode> tmp = new ArrayList<TreeLinkNode>();
			for (int i = 0; i < nodes.size() - 1; i++) {
				nodes.get(i).next = nodes.get(i + 1);
			}

			for (TreeLinkNode node : nodes) {
				if (node.left != null) {
					tmp.add(node.left);
				}
				if (node.right != null) {
					tmp.add(node.right);
				}
			}
			nodes = tmp;
		}
	}
}
