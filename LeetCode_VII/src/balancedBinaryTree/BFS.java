package balancedBinaryTree;
// 这题想了比较长的时间，因为开始想错了，这里的balanced 意思指的是左右两个sub tree的depth 不超过1，这样可以直接从基本定义开始入手
// 首先如果是null 肯定就是balanced 然后得到左右两个depth的长度，如果长度差大于1，那么就返回false
// 然后看左右是不是都是balanced 如果是都是balanced 就返回true 如果不是，就返回false
// 这里用了递归。
// 然后算左边和右边的depth 的时候也是用的递归，如果是null 就返回0 ，如果不是就是left child 和 right child 的depth 的大值 +1
// 要注意的是求左右的subtree 的depth 的差的时候，要注意求绝对值。因为不知道左边还是右边短。
// 如果定义的是所有的leaf 的深度差不超过1.可以参考cracking code 4.1 或者我下面自己写的，我写的是判断child 是不是parent 的2倍，如果不是，就说明这个child 应该是最后一层
// 如果child 来了之后还有child 就说明是false
// 如果正常出来就是true
public class BFS {
	public static boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}

		if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) {
			return false;
		}
		return isBalanced(root.left) && isBalanced(root.right);

	}

	private static int maxDepth(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
	}

	public static void main(String[] args) {
		// TreeNode t1 = new TreeNode(1);
		// TreeNode t2 = new TreeNode(2);
		// TreeNode t3 = new TreeNode(2);
		// TreeNode t4 = new TreeNode(3);
		// TreeNode t5 = new TreeNode(3);
		// TreeNode t6 = new TreeNode(3);
		// TreeNode t7 = new TreeNode(3);
		// TreeNode t8 = new TreeNode(4);
		// TreeNode t9 = new TreeNode(4);
		// TreeNode t10 = new TreeNode(4);
		// TreeNode t11 = new TreeNode(4);
		// TreeNode t12 = new TreeNode(4);
		// TreeNode t13 = new TreeNode(4);
		// TreeNode t14 = new TreeNode(5);
		// TreeNode t15= new TreeNode(5);
		// t1.left = t2;
		// t1.right = t3;
		// t2.left = t4;
		// t2.right = t5;
		// t3.left = t6;
		// t3.right = t7;
		// t4.left = t8;
		// t4.right = t9;
		// t5.left = t10;
		// t5.right = t11;
		// t6.left = t12;
		// t6.right = t13;
		// t8.left = t14;
		// t8.right = t15;

		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t2.right = t3;
		t1.right = t2;

		System.out.println(isBalanced(t1));
	}
}

// if (root == null) {
// return true;
// }
//
// ArrayList<TreeNode> level = new ArrayList<TreeNode>();
// level.add(root);
// boolean noChild = false;
// while (!level.isEmpty()) {
// ArrayList<TreeNode> tmp = new ArrayList<TreeNode>();
// for (TreeNode node : level) {
// TreeNode left = node.left;
// TreeNode right = node.right;
// if (noChild && (left != null || right != null)) {
// return false;
// }
// if (left != null) {
// tmp.add(left);
// }
// if (right != null) {
// tmp.add(right);
// }
// }
//
// if (tmp.size() < level.size() * 2) {
// noChild = true;
// }
// level = tmp;
//
// }
// return true;
