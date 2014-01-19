package sumRootToLeafNumbers;
//VIII
//这个是简单的tree 的DFS的问题，因为是用int 所以不要加了之后再减去，因为每次都生成的是新的。
//从root 开始，每读一个就在原来基础上*10 + 现在这个值。
//然后全部存在一个arraylist 里面，最后统一相加，
//但是这个要注意的是区别于之前的Tree 的dfs, 这个不能是在node 为null 的时候添加一个，这样的话就在在叶子上重复写了两遍。
//所以应该是在看左边和右边都没有的情况下就添加返回，然后如果有一个有的话就去那一个。两个有的话就两个都去。
//小细节在没有DEBUG工具的情况下要小心。
import java.util.ArrayList;
//不能是null进去之后这样可能变成两倍
public class CheckLeafBeforeGoInto {
	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}

		ArrayList<Integer> results = new ArrayList<Integer>();
		int number = 0;
		sumNumbersHelper(root, results, number);
		int sum = 0;
		for (int r : results) {
			sum += r;
		}
		return sum;
	}

	private static void sumNumbersHelper(TreeNode root,
			ArrayList<Integer> results, int number) {

		number = number * 10 + root.val;
		if (root.left == null && root.right == null) {
			results.add(number);
			return;
		}
		if (root.left != null) {
			sumNumbersHelper(root.left, results, number);
		}
		if (root.right != null) {
			sumNumbersHelper(root.right, results, number);
		}
	}
}
