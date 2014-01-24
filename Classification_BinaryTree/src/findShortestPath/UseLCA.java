package findShortestPath;

import java.util.ArrayList;
//这个是首先找到最近的ancestor 然后从这个ancestor 去返回一个左边的arraylist 和右边的arraylist 
//然后再把两个arraylist 连接到一起。
//注意返回的时候如果是左边进行递归，先把左边的都加起来，然后将自己加到后面，然后再返回。
//如果是右边，先把自己加上去，然后再加上右边的数值，最后将所有的返回回去。

//看LCA的情况是如果自己本身就是null， 就将其返回，如果看自己是不是和其中一个相同就返回自己，如果不是就去找左右两边的root 如果在左右两边都找到了，就返回这个说明这个是root 
//如果只有一边，那么就返回这一边不是null 的。
public class UseLCA {
	public ArrayList<TreeNode> findShortestPath(TreeNode head, int x, int y) {
		ArrayList<TreeNode> result = new ArrayList<>();
		head = getLCA(head, x, y);
		ArrayList<TreeNode> left = findPath(head, x);
		ArrayList<TreeNode> right = findPath(head, y);

		if (x < y) {
			left.remove(left.size() - 1);
			result.addAll(left);
			result.addAll(right);
		} else {
			right.remove(right.size() - 1);
			result.addAll(right);
			result.addAll(left);
		}

		return result;
	}

	private ArrayList<TreeNode> findPath(TreeNode head, int x) {
		ArrayList<TreeNode> result = new ArrayList<>();
		if (head.val == x) {
			result.add(head);
			return result;
		} else if (head.val > x) {
			ArrayList<TreeNode> left = findPath(head.left, x);
			result.addAll(left);
			result.add(head);
		} else {
			result.add(head);
			ArrayList<TreeNode> right = findPath(head.right, x);
			result.addAll(right);
		}
		return result;
	}

	public TreeNode getLCA(TreeNode root, int p, int q) {
		if (root == null) {
			return null;
		}

		if (root.val == p || root.val == q) {
			return root;
		}

		TreeNode left = getLCA(root.left, p, q);
		TreeNode right = getLCA(root.right, p, q);

		if (left != null && right != null) {
			return root;
		}

		return left != null ? left : right;
	}
}
