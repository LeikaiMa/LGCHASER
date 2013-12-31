package preorderTraversal;
// 要注意的就是如果是null 要返回的是一个空的arraylist 而不是null
import java.util.ArrayList;

public class Recursive {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		preorderTraversal(root, result);
		return result;
	}

	private static void preorderTraversal(TreeNode root,
			ArrayList<Integer> result) {
		if (root == null) {
			return;
		}
		result.add(root.val);
		preorderTraversal(root.left, result);
		preorderTraversal(root.right, result);
	}
}
