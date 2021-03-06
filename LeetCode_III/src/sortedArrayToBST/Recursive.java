package sortedArrayToBST;
// 中间的作为root 其他的放在两边依次进行递归。返回的值是root 然后就形成一个BST
public class Recursive {
	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null || num.length == 0) {
			return null;
		}

		if (num.length == 1) {
			return new TreeNode(num[0]);
		}

		TreeNode root = sortedArrayToBSTHelper(num, 0, num.length - 1);
		return root;
	}

	private TreeNode sortedArrayToBSTHelper(int[] num, int start, int end) {
		if (start > end) {
			return null;
		} else if (start == end) {
			return new TreeNode(num[start]);
		} else {
			int mid = start + (end - start + 1) / 2;
			TreeNode root = new TreeNode(num[mid]);
			root.left = sortedArrayToBSTHelper(num, start, mid - 1);
			root.right = sortedArrayToBSTHelper(num, mid + 1, end);
			return root;
		}

	}
}
