package createBST;

import checkBalancedTree.TreeNode;
// 将一个有序的数组排成BST，可以看成是将mid放成root，比他小的，放在left child 里面，比他大的，放在right child
// 因为里面也是一个有序的数组，本质上和之前没有区别，所以可以用同样的方法进行安装BST
// 因为要recursion 所以要有个base case 所以 base case 是end如果比 start 要小。这样就算是到了leaf 之下，这时候就是null。
public class CreateMinimalBST {
	TreeNode createMinimalBST(int[] arr, int start, int end) {
		if (end < start) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode n = new TreeNode(arr[mid]);
		n.left = createMinimalBST(arr, start, mid - 1);
		n.right = createMinimalBST(arr, mid + 1, end);
		return n;
	}

	TreeNode createMinimalBST(int array[]) {
		return createMinimalBST(array, 0, array.length - 1);
	}
}
