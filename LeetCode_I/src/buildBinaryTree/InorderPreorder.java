package buildBinaryTree;
// 这个和post一个意思，只是left 和 right 在pre 和post 里面的 位置不同
// 要注意的一点是get index 的时候不是preorder 的【0】 因为没有新建array 所以要用的是pstart
import java.util.HashMap;

public class InorderPreorder {
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		if (inorder == null || preorder == null) {
			return null;
		}

		if (inorder.length != preorder.length) {
			return null;
		}
		if (inorder.length == 0) {
			return null;
		}

		HashMap<Integer, Integer> inorderHashMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			inorderHashMap.put(inorder[i], i);
		}

		TreeNode root = buildTree(inorderHashMap, inorder, preorder, 0,
				inorder.length - 1, 0, preorder.length - 1);
		return root;
	}

	public static TreeNode buildTree(HashMap<Integer, Integer> map,
			int[] inorder, int[] preorder, int istart, int iend, int pstart,
			int pend) {
		if (istart > iend || pstart > pend) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[pstart]);
		int index = map.get(preorder[pstart]);
		root.left = buildTree(map, inorder, preorder, istart, index - 1,
				pstart + 1, pstart + 1 + (index - 1 - istart));
		root.right = buildTree(map, inorder, preorder, index + 1, iend, pend
				- (iend - index - 1), pend);
		return root;
	}

	public static void main(String[] args) {
		int[] inorder = { 2, 1 };
		int[] preorder = { 1, 2 };
		TreeNode root = buildTree(preorder, inorder);
		printTree(root);
		System.out.println();
	}

	public static void printTree(TreeNode root) {
		if (root.left != null) {
			printTree(root.left);
		}
		System.out.print(root.val + ",");
		if (root.right != null) {
			printTree(root.right);
		}
	}

}
