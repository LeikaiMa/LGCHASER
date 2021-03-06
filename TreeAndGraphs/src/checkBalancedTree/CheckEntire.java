package checkBalancedTree;
// 判断是否为balancedTree 需要注意的是从自己本身到下面的left 或者right 都要balanced
// 所以这个时候要用到递归，可以先检查自己然后检查左右两边是否为balanced
// 而判断是否为balanced 的依据是左右两边的height 的差是否大于1
// 而getHeight 同样也算是递归，因为在base case 当中，如果到了leaf 下面的就是null 这个时候算作是0，往上一层算作是两个height 求大值 + 1
// 这样一层一层比较直观，看是否是balanced，检查两边的height差是否大于1
// 但是问题在于getheight 有时候会要重复的去call O(n^2)

public class CheckEntire {
	public static int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	
	public static boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		
		int heightDiff = getHeight(root.left) - getHeight(root.right);
		
		if (Math.abs(heightDiff) > 1) {
			return false;
		} else {
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}
}
