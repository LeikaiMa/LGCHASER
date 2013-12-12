package nextNode;

import checkBalancedTree.TreeNode;
// 查找下一个node， 因为是BST， 所以需要利用其特性
// 如果是有right child 就是right child 的最left child
// 如果没有right child， 那么下一个node就是自己的parent，而且自己必须是parent 的left child
// 如果自己仍然是right child 说明没有其他的node，利用while 里面的特性可以发现正好出来的是null。

public class LeftMostChild {
	public TreeNode inoderSucc(TreeNode n) {
		if (n == null) {
			return null;
		}

		if (n.right != null) {
			return leftMostChild(n.right);
		} else {
			TreeNode q = n;
			TreeNode x = q.parent;

			while (x != null && x.left != q) {
				q = x;
				x = x.parent;
			}
			return x;
		}
	}

	public TreeNode leftMostChild(TreeNode n) {
		if (n == null) {
			return null;
		}

		while (n.left != null)
			;
		return n;
	}
}
