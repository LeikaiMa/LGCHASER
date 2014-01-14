package binaryTreeMaximumPathSum;
//V
//寻找sum 最大的路径，因为不一定是最开始的root ，每个node 都可以作为一个完整的root。
//这时候就有4种情况，本身单独，本身加上左边，本身加上右边，还有左中右。
//这个是针对这个node 的所有可能情况，因为与这个node 有关，所以必须包括这个node，万一其他的有负数，可以省略不起副作用
//如果是null，标明这个不起作用，返回0 ，注意不是最小值，因为是不起作用，而不是最小进行比较。
//但是返回的时候不能返回左中右这种拱形，因为从上面到下面来之能走左走右或者不走，而不能两边都走。所以只能返回side 最大的值。
//但是max可以看在这个node 的时候最大的情况，所以是四种情况取最大值
//开始的时候放置最小值。这里有个值得学习的地方是，因为要用一个类似于全局变量的东西进行比较，可以不设置全局变量，设置一个array 然后传reference 进去。
//可以通过这个reference 进行比较，和实时更改

//这边首先没有把自己考虑进去，因为有可能左右两边都是负数，都要舍去，其次开始统计的时候应该是最小值，而如果null 的情况下应该是返回的是0 而不是最小值
//返回的时候应该是side 而不是连arc 算进去。
public class LeftRightArcAndSelf {
	public int maxPathSum(TreeNode root) {
		int[] maxSum = new int[1];
		maxSum[0] = Integer.MIN_VALUE;
		helper(root, maxSum);
		return maxSum[0];
	}

	public int helper(TreeNode root, int[] maxSum) {
		if (root == null) {
			return 0;
		}

		int cur = root.val;
		int left = helper(root.left, maxSum);
		int right = helper(root.right, maxSum);

		int side = Math.max(cur, Math.max(left, right) + cur);

		int arc = left + cur + right;

		maxSum[0] = Math.max(maxSum[0], Math.max(arc, side));
		return side;
	}
}
