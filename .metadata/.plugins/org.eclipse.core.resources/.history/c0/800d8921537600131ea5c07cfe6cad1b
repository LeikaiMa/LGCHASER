package constructBinaryTreeFromInorderAndPostorderTraversal;
//分析post 和inorder 的关系。
//post 最后一个肯定是root， 然后inorder 是用root 将left 和right 分开。
//先用一个hashmap 将inorder 里面的值和index 一一存起来，这样以后找的时候就不需要再遍历找，可以直接用hashmap。
//不要用hashtable，里面有很多问题，比如同步，比如key 和value 不能存null
//然后传递inorder 和 postorder 两边的边界调节，叫做start end
//先找到root 然后通过root 找到在inorder 里的位置，这样可以left 和right 放进去进行递归，但是要保证start 不能大于end 这个作为base case
//然后传进去的时候是新的inorder 和 postorder的 边界，因为inorder 比较好找，就在root 的左右。
//postorder 只能定位左的start 和右的end 但是可以通过inorder 里面的长度，来确定其他两个的边界条件。
import java.util.HashMap;
// 要注意的是binary tree 不一定是对称的，所以不能用mid 来求inorder 的位置。所以这边用的map 来存东西。
// 然后post 的时候因为最后一个作为了root所以建right child 的时候就要用 pend - 1 这个容易出错。
public class HashMapStoreIndex {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null) {
			return null;
		}
		if (inorder.length == 0) {
			return null;
		}
		if (inorder.length != postorder.length) {
			return null;
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return buildTreeHelper(map, inorder, 0, inorder.length - 1, postorder,
				0, postorder.length - 1);
	}

	public TreeNode buildTreeHelper(HashMap<Integer, Integer> map,
			int[] inorder, int istart, int iend, int[] postorder, int pstart,
			int pend) {
		if (istart > iend) {
			return null;
		}

		int rootVal = postorder[pend];
		TreeNode root = new TreeNode(rootVal);
		int index = map.get(rootVal);

		root.left = buildTreeHelper(map, inorder, istart, index - 1, postorder,
				pstart, pstart + (index - 1 - istart));
		root.right = buildTreeHelper(map, inorder, index + 1, iend, postorder,
				pend - 1 - (iend - index - 1), pend - 1);

		return root;
	}
}
