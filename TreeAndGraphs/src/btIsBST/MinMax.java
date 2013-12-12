package btIsBST;

import checkBalancedTree.TreeNode;
// 仔细分析BST 的性质，不仅仅是left child 要比 本身要小，而是本身左边所有的都要比自己小。
// 这样可以传递一个范围，看这个值是否在这个范围内，而这个范围在递归的时候可以根据本身进行定义。
// 这时候的次序就需要进行更换，先检查自己是不是符合，然后看两边分别符不符合。
// 做递归的时候需要注意的亮点是，看base case 还有就是null 有没有合适的处理。
public class MinMax {
	public boolean checkBST(TreeNode n) {
		return checkBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public boolean checkBST(TreeNode n, int min, int max) {
		if (n == null) {
			return true;
		}
		
		if (n.data <= min || n.data > max) {
			return false;
		}
		
		if (!checkBST(n.left, min, n.data) || !checkBST(n.right, n.data, max)) {
			return false;
		}
		
		return true;
	}
}
