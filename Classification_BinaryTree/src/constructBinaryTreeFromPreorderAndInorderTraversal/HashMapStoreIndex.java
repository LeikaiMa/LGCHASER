package constructBinaryTreeFromPreorderAndInorderTraversal;
// I-2
//这个和post一个意思，只是left 和 right 在pre 和post 里面的 位置不同
//要注意的一点是get index 的时候不是preorder 的【0】 因为没有新建array 所以要用的是pstart
import java.util.HashMap;
// 要记住是pstart 然后在后面的时候是pstart + 1
public class HashMapStoreIndex {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null) {
			return null;
		}

		if (preorder.length != inorder.length) {
			return null;
		}

		if (preorder.length == 0) {
			return null;
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}

		return buildTreeHelper(map, preorder, 0, preorder.length - 1, inorder,
				0, inorder.length - 1);
	}

	public TreeNode buildTreeHelper(HashMap<Integer, Integer> map,
			int[] preorder, int pstart, int pend, int[] inorder, int istart,
			int iend) {
		if (istart > iend) {
			return null;
		}

		int rootVal = preorder[pstart];
		TreeNode root = new TreeNode(rootVal);
		int index = map.get(rootVal);

		root.left = buildTreeHelper(map, preorder, pstart + 1, pstart + 1
				+ (index - 1 - istart), inorder, istart, index - 1);
		root.right = buildTreeHelper(map, preorder, pend - (iend - index - 1),
				pend, inorder, index + 1, iend);

		return root;
	}
}
