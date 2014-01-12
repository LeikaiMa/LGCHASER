package binaryTreeLevelOrderTraversal;
//IV
//这个是一个比较简单的BFS的应用，但是因为因为输出的只是里面的val 所以要新建一个arraylist 里面存具体的val 然后再塞进arraylist 里面、
//然而在里面还是要用node 来进行存储，因为要看下一个有没有left 或者是right node
//然后可以是用的arraylist 而不用QUEUE 因为是一层一层来进行。
import java.util.ArrayList;
//这里出错是在node.val 老是写成level.node
public class LevelByLevel {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
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

			results.add(result);
			level = tmp;
		}

		return results;
	}
}
