package btIsBST;

import checkBalancedTree.TreeNode;
// 检查一个BT是不是BST，一种直接的方法是不管他到底是不是，直接按照他的条件先存到一个数组当中
// 然后直接检查这个数组，看这个数组是不是从开始到最后是按照从小到大来进行排列。这里面用到in order的traverse 的方法
// 这里面用到两种不同的在函数中改变全局变量的方法。一种是在外面放static 的参数，这个参数用来改变index，这样存数据的时候就可以依次存储。
// 还有一个就是传reference。
public class InOrder {
	public static int index = 0;

	public static void copyBST(TreeNode root, int[] array) {
		if (root == null) {
			return;
		}

		copyBST(root.left, array);
		array[index] = root.data;
		index++;
		copyBST(root.right, array);
	}

	public static boolean checkBST(TreeNode root) {
		int[] array = new int[root.size];
		copyBST(root, array);
		for (int i = 1; i < array.length; i++) {
			if (array[i] <= array[i - 1]) {
				return false;
			}
		}
		return true;
	}

}
