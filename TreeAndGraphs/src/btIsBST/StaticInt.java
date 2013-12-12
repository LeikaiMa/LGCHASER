package btIsBST;

import checkBalancedTree.TreeNode;
// 观察到我们之前存的数组当中，只需要比较前一个和当前这一个，而不需要用整个数组，这样可以直接存一个值，然后不断的变化，就不需要用数组
// 同样是static 的形式，而检查的方式也是左中右的检查，如果发现现在的值要比static 存的值要小，就说明这个不是BST

public class StaticInt {
	public static int last_printed = Integer.MIN_VALUE;
	public static boolean checkBST(TreeNode n) {
		if (n == null) {
			return true;
		}
		
		if (!checkBST(n.left)) {
			return false;
		}
		
		if (n.data <= last_printed) {
			return false;
		}
		last_printed = n.data;
		
		if (!checkBST(n.right)) {
			return false;
		}
		
		return true;
	}
}
