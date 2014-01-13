package pathSum;
//IV
//要找最后的是不是目标的sum，还是用DFS的方法，这样到了最后leaf 进行比较，如果不是看左右child 是不是null 不是null 递归进去。
//一旦成功就直接返回。不需要继续比较下去，这样可以节省时间，如果全部不是就返回false

//这次做的时候将原来的check 的工作到dfs 的下一层来进行，用|| 直接判断，主要考虑的是只有一个child 的情况，如果这个就不能算做是leaf 
//如果是null 直接返回false 如果是先加起来，看这个是如果是leaf 比较，是就是true 如果不是就是false 然后看左右是不是。这样dfs 下去。
public class CheckLeftAndRight {
	public boolean hasPathSum(TreeNode root, int sum) {
		return helper(root, 0, sum);
	}

	private boolean helper(TreeNode root, int s, int sum) {
		if (root == null) {
			return false;
		}

		s = s + root.val;
		if (root.left == null && root.right == null) {
			if (s == sum) {
				return true;
			} else {
				return false;
			}
		}

		return helper(root.left, s, sum) || helper(root.right, s, sum);
	}
}
