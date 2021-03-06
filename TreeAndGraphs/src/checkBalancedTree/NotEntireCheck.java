package checkBalancedTree;
// 因为在里面求height 的时候，需要求出left 和right 的child 的height，这时候就可以求成这个子树下面是否是balanced。
// 而因为返回值是要返回height， 如果不是可以不用boolean ，可以合并到里面的值为-1.
// 这样可以为O(N) 的时间和O（H） 的空间。
public class NotEntireCheck {
	public static int checkHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftHeight = checkHeight(root.left);
		if (leftHeight == -1) {
			return -1;
		}

		int rightHeight = checkHeight(root.right);
		if (rightHeight == -1) {
			return -1;
		}

		int heightDiff = leftHeight - rightHeight;
		if (Math.abs(heightDiff) > 1) {
			return -1;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}

	public static boolean isBalanced(TreeNode root) {
		if (checkHeight(root) == -1) {
			return false;
		} else {
			return true;
		}
	}
}
