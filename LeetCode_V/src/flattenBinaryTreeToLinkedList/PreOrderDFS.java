package flattenBinaryTreeToLinkedList;
// 这里类似的是preorder 的方法，先处理完左边和右边的然后解决自己的。
// 因为要将left最后连到右边的开始，这时候为了不再traverse 一遍，建一个helper 函数，每次返回的时候将tail 返回回来，
// 如果只有root自己，正好返回。如果只有右边，不需要其他的操作，只要将right 处理完的tail 传回去。
// 如果只有左边，那么就先处理完左边，将左边移到右边，左边置null 返回左边的tail
// 如果两边都有，那么先解决完两边，左边tail 连上右边，左边移到右边，左边置为null 然后返回右边的tail
// 逻辑不错一般没有问题。
public class PreOrderDFS {
	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}

		flattenHelper(root);
	}

	public TreeNode flattenHelper(TreeNode root) {
		if (root.left == null && root.right == null) {
			return root;
		} else if (root.left == null) {
			return flattenHelper(root.right);
		} else if (root.right == null) {
			TreeNode leftTail = flattenHelper(root.left);
			root.right = root.left;
			root.left = null;
			return leftTail;
		} else {
			TreeNode leftTail = flattenHelper(root.left);
			TreeNode rightTail = flattenHelper(root.right);
			leftTail.right = root.right;
			root.right = root.left;
			root.left = null;
			return rightTail;
		}
	}
}
