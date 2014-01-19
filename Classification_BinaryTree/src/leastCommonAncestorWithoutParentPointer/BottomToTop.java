package leastCommonAncestorWithoutParentPointer;
//CC
//如果没有parent 要O(n) 的方法就要从底向上，这样只要经历一遍，
//如果是null 就返回null，然后check 自己是不是其中一个，如果是其中一个，就说明这个要么就是找到了这个，要么就是这两个的parent 因为找还是找从上往下找的
//如果不是就检查他的left 和right 
//如果两边都不是null 说明这个这个就是parent 
//如果只有一边有，就返回这一边。
//http://leetcode.com/2011/07/lowest-common-ancestor-of-a-binary-tree-part-i.html
public class BottomToTop {
	public TreeNode getLCA(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		
		if (root == p || root == q) {
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
