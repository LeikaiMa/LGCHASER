package uniqueBinarySearchTreesII;
//III
//BST 的基本属性是left child 都要比node 上的data 小（或者等于）right child 要比node 的data 大
//然后要找所有的，就要每一个都可以作为node 左右两边分别作为对应的left 和 right child 可以用里面的值进行相同的操作。
//这时候用的是递归，
//base case 有两种，如果是start 比end 要大，这时候返回的应该是null 可以在arraylist 里面写null 也是可以占一位。
//如果是起点和终点相同，返回里面的为这个值的treenode
//如果起点比终点要小，说明可以继续拆分。left 和right 可以进行递归。 
//得到的值用两个loop 可以得到 left * right 总个数的机会。然后加到新建的node 的左右child 里面。
//最后一起递归回去。
import java.util.ArrayList;
//本质上是将整个链子按照每个元素从这个元素断开，然后左边按照这个方法形成左边的BST，右边也按照这个方法形成BST
//base case 是如果>  就是null 如果是== 就是这个作为node 
//然后返回的情况是按照left 的任何一种方法和right 的任何一种方法进行组合，将这个结果存好往上传，这样用两重循环就是所有left 和所有的right 任取一种组成的情况。
public class SplitIntoTwoParts {
	public ArrayList<TreeNode> generateTrees(int n) {
		return helper(1, n);
	}

	private ArrayList<TreeNode> helper(int start, int end) {
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();

		if (start > end) {
			result.add(null);
		} else if (start == end) {
			result.add(new TreeNode(start));
		} else {
			for (int i = start; i <= end; i++) {
				ArrayList<TreeNode> lefts = helper(start, i - 1);
				ArrayList<TreeNode> rights = helper(i + 1, end);

				for (TreeNode left : lefts) {
					for (TreeNode right : rights) {
						TreeNode root = new TreeNode(i);
						root.left = left;
						root.right = right;
						result.add(root);
					}
				}
			}
		}

		return result;
	}
}
