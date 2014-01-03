package validBinarySearchTree;
// 检查一个Tree 是不是BST。开始的时候没有深刻理解，不仅仅是要比较这个值是不是左边比root 小，右边比root 大
// 而是有个范围，left child's right child 要比root 也要小，这个时候就要将整个范围也要传递进去。
// 开始的时候root 没有boundary 所以是最小值和最大值为两边的边界。
// 如果是是null 肯定就是
// 如果不是就开始判断里面的child 如果不是null ，他的值是不是再范围里面，左边要在左边界和root 之间，右边在root 和右边界之间。
// 如果不是就直接返回。线比较值，不进行dfs 有效的能够剪枝
// 然后将左和右的child 判断是不是有效的。
// 左边的右边界就变成了root 
// 右边的左边界就变成了root
// 如果都过了就返回true
public class DFS {
	public boolean isValidBST(TreeNode root) {
		return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	
	
	private boolean isValidBSTHelper(TreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}

		TreeNode leftNode = root.left;
		TreeNode rightNode = root.right;
		if (root.left != null) {
			if (root.val <= leftNode.val ||  leftNode.val<= min) {
				return false;
			}
		}

		if (root.right != null) {
			if (root.val >= rightNode.val|| rightNode.val >= max) {
				return false;
			}
		}
		
		if (!isValidBSTHelper(root.left, min ,root.val)
				|| !isValidBSTHelper(root.right, root.val, max)) {
			return false;
		}
		return true;
	}



	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(10);
		TreeNode t2 = new TreeNode(5);
		TreeNode t3 = new TreeNode(15);
		TreeNode t4 = new TreeNode(6);
		TreeNode t5 = new TreeNode(20);
		
		t1.left = t2;
		t1.right = t3;
		t3.left = t4;
		t3.right = t5;
		
		System.out.println(new DFS().isValidBST(t1));
		
		
	}
}
