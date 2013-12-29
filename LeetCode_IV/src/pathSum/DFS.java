package pathSum;
// 要找最后的是不是目标的sum，还是用DFS的方法，这样到了最后leaf 进行比较，如果不是看左右child 是不是null 不是null 递归进去。
// 一旦成功就直接返回。不需要继续比较下去，这样可以节省时间，如果全部不是就返回false
public class DFS {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}

		int curSum = 0;
		return hasPathSumHelper(root, curSum, sum);
	}

	private boolean hasPathSumHelper(TreeNode root, int curSum, int sum) {
		curSum += root.val;
		if (root.left == null && root.right == null) {
			return curSum == sum;
		}

		if (root.left != null && hasPathSumHelper(root.left, curSum, sum)) {
			return true;
		}

		if (root.right != null && hasPathSumHelper(root.right, curSum, sum)) {
			return true;
		}
		
		return false;
	}
}
