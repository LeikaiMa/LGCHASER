package binarySearchTreeSuccessor;
//这题是找node 的下面一个值，从最开始来进行找，如果相等，那么下一个就应该是右边的最左边的那一个node
//这种情况应该是右边还有node 的存在，如果没有就没有successor 了。
//如果自己比target 那么就要看左边的rightmost 的child 是不是比自己要大，如果还是比target己要大，那么自己就变成自己的left child 继续。
//如果比target 要小或者等于，那么就说明自己就是successor。
//如果自己比target 要小，就要看自己的右边有没有，如果有就到右边去，没有就统一返回0
public class CompareRoot {
	private TreeNode getLeftMost(TreeNode head) {
		TreeNode current = head;
		while (current.left != null) {
			current = current.left;
		}

		return current;
	}

	private TreeNode getRightMost(TreeNode head) {
		TreeNode current = head;
		while (current.right != null) {
			current = current.right;
		}
		return current;
	}

	public int getSuccessor(TreeNode head, int target) {
		TreeNode current = head;
		int successor = 0;

		while (current != null) {
			if (current.val < target && current.right != null) {
				current = current.right;
			} else if (current.val > target) {
				if (current.left != null
						&& getRightMost(current.left).val > target) {
					current = current.left;
				} else {
					successor = current.val;
					current = null;
				}
			} else {
				if (current.right != null) {
					successor = getLeftMost(current.right).val;
				}
				current = null;
			}
		}

		return successor;
	}
}
