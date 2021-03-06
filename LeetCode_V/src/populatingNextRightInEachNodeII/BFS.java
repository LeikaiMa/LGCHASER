package populatingNextRightInEachNodeII;
// 方法同1
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
