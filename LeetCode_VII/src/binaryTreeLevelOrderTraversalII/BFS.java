package binaryTreeLevelOrderTraversalII;
// 这个倒着存入的方法，投了一个巧，还是level 进行读，然后每次add 的时候是直接插在最前面，就好像倒着存进去。
// 还可以是正着存，存完之后再倒着存进去，或者用stack 然后pop 出来就是反过来的。
import java.util.ArrayList;

public class BFS {
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return results;
		}
		ArrayList<TreeNode> level = new ArrayList<TreeNode>();
		level.add(root);

		while (!level.isEmpty()) {
			ArrayList<TreeNode> tmp = new ArrayList<TreeNode>();
			ArrayList<Integer> values = new ArrayList<Integer>();
			for (TreeNode node : level) {
				values.add(node.val);
				if (node.left != null) {
					tmp.add(node.left);
				}

				if (node.right != null) {
					tmp.add(node.right);
				}
			}
			results.add(0, values);
			level = tmp;
		}
		return results;
	}
}
