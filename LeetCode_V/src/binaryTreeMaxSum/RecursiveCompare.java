package binaryTreeMaxSum;
// 寻找sum 最大的路径，因为不一定是最开始的root ，每个node 都可以作为一个完整的root。
// 这时候就有4种情况，本身单独，本身加上左边，本身加上右边，还有左中右。
// 这个是针对这个node 的所有可能情况，因为与这个node 有关，所以必须包括这个node，万一其他的有负数，可以省略不起副作用
// 如果是null，标明这个不起作用，返回0 ，注意不是最小值，因为是不起作用，而不是最小进行比较。
// 但是返回的时候不能返回左中右这种拱形，因为从上面到下面来之能走左走右或者不走，而不能两边都走。所以只能返回side 最大的值。
// 但是max可以看在这个node 的时候最大的情况，所以是四种情况取最大值
// 开始的时候放置最小值。这里有个值得学习的地方是，因为要用一个类似于全局变量的东西进行比较，可以不设置全局变量，设置一个array 然后传reference 进去。
// 可以通过这个reference 进行比较，和实时更改
public class RecursiveCompare {
	public static int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int[] maxSum = new int[1];
		maxSum[0] = Integer.MIN_VALUE;
		maxPathSumHelper(root, maxSum);
		return maxSum[0];
	}

	private static int maxPathSumHelper(TreeNode root, int[] maxSum) {
		if (root == null) {
			return 0;
		}

		int cur = root.val;
		int left = maxPathSumHelper(root.left, maxSum);
		int right = maxPathSumHelper(root.right, maxSum);
		int arc = cur + left + right;
		int side = Math.max(cur, Math.max(left, right) + cur);
		int max = Math.max(arc, side);
		maxSum[0] = Math.max(maxSum[0], max);
		return side;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(-3);
		System.out.println(maxPathSum(root));
	}

}
