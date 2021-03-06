package binaryTreeZigzagLevelOrderTraversal;
// 这题不仅仅是提取的顺序变了还要考虑下次存的时候，是先存left 还是先存right，这个时候可以用一个boolean 每次维护更新，选择是从左向右还是从右向左。
// stack 可以用来改变顺序，
// 但是我在这题用了collection 直接将arraylist reverse 过来
import java.util.ArrayList;
import java.util.Collections;

public class UseStack {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return results;
		}

		ArrayList<TreeNode> level = new ArrayList<TreeNode>();
		level.add(root);
		boolean reverse = false;
		while (!level.isEmpty()) {
			ArrayList<TreeNode> tmp = new ArrayList<TreeNode>();
			ArrayList<Integer> content = new ArrayList<Integer>();
			for (TreeNode node : level) {
				content.add(node.val);
				if (node.left != null) {
					tmp.add(node.left);
				}

				if (node.right != null) {
					tmp.add(node.right);
				}
			}

			if (reverse) {
				Collections.reverse(content);
			}
			reverse = !reverse;
			results.add(content);
			level = tmp;

		}
		return results;
	}
}
