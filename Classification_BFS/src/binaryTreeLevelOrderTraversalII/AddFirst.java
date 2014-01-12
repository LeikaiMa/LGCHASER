package binaryTreeLevelOrderTraversalII;

import java.util.ArrayList;
//这边唯一不同的是加在arraylist 的0 的位置。
public class AddFirst {
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return results;
		}

		ArrayList<TreeNode> level = new ArrayList<TreeNode>();
		level.add(root);

		while (!level.isEmpty()) {
			ArrayList<TreeNode> tmp = new ArrayList<TreeNode>();
			ArrayList<Integer> result = new ArrayList<Integer>();

			for (TreeNode node : level) {
				result.add(node.val);

				if (node.left != null) {
					tmp.add(node.left);
				}

				if (node.right != null) {
					tmp.add(node.right);
				}
			}

			results.add(0, result);
			level = tmp;
		}

		return results;
	}
}
