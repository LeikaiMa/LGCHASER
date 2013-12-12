package listEachDepth;

import java.util.ArrayList;
import java.util.LinkedList;

import checkBalancedTree.TreeNode;
// 根据题目的本质是level 遍历，而BFS就是level 遍历整个tree
// 这样就可以直接iteration 来将这一个level 的值全部存进去。
// 本质上while 循环也就可以看做一个recursion 要等到存这一level 没有元素就可以跳出
// 用两个arraylist 进行交替运行，一个是属于parent， 一个算作current，到了下一层，current 晋级为parent current 变成存这个level的元素的arraylist。
// 这个非常常见，交换自己的role

public class BFS {
	ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
		LinkedList<TreeNode> current = new LinkedList<>();
		if (root != null) {
			current.add(root);
		}
		
		while (current.size() > 0) {
			result.add(current);
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<>();
			for (TreeNode parent : parents) {
				if (parent.left != null) {
					current.add(parent.left);
				}
				
				if (parent.right != null) {
					current.add(parent.right);
				}
			}
		}
		return result;
	}
}
