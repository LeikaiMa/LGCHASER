package uniqueBSTII;

import java.util.ArrayList;
// BST 的基本属性是left child 都要比node 上的data 小（或者等于）right child 要比node 的data 大
// 然后要找所有的，就要每一个都可以作为node 左右两边分别作为对应的left 和 right child 可以用里面的值进行相同的操作。
// 这时候用的是递归，
// base case 有两种，如果是start 比end 要大，这时候返回的应该是null 可以在arraylist 里面写null 也是可以占一位。
// 如果是起点和终点相同，返回里面的为这个值的treenode
// 如果起点比终点要小，说明可以继续拆分。left 和right 可以进行递归。 
// 得到的值用两个loop 可以得到 left * right 总个数的机会。然后加到新建的node 的左右child 里面。
// 最后一起递归回去。
public class UniqueBST {
	public ArrayList<TreeNode> generateTrees(int n) {

		return generateTreesHelper(1, n);
	}

	private ArrayList<TreeNode> generateTreesHelper(int start, int end) {
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		if (start > end) {
			result.add(null);
		} else if (start == end) {
			result.add(new TreeNode(start));
		} else {
			for (int i = start; i <= end; i++) {

				ArrayList<TreeNode> lefts = generateTreesHelper(start, i - 1);
				ArrayList<TreeNode> rights = generateTreesHelper(i + 1, end);
				for (TreeNode left : lefts) {
					for (TreeNode right : rights) {
						TreeNode node = new TreeNode(i);
						node.left = left;
						node.right = right;
						result.add(node);
					}
				}
			}
		}
		return result;
	}

}
