package listEachDepth;

import java.util.ArrayList;
import java.util.LinkedList;

import checkBalancedTree.TreeNode;
// 要求将每个depth 放在一个list 上，本质上需要遍历整个list中node。
// 如果没有按照level的顺序就需要显式的标记所在的level
// 这样在递归的时候需要将这个放在函数里，因为是要将这些存到一个arraylist里面，这个arraylist 在递归的时候也要传入。
// 因为是出传入reference 就可以直接在里面进行。不要返回值
// 在这里面同样用到了递归的固定格式，在开始的时的时候判断是否为base case，这里的base case 同一般的情况一样都是是leaf 下面有没有child
// 因为在这里面开始并不知道有多少的level，所以看是没有直接生成。需要后期判断这个level 在arraylist 里面有没有生成。
// 生成就可以直接取出，没有生成就需要新建然后塞入。

public class PreOder {

	public void createLevelLinkedList(TreeNode root,
			ArrayList<LinkedList<TreeNode>> lists, int level) {
		if (root == null) {
			return;
		}

		LinkedList<TreeNode> list = null;
		if (lists.size() == level) {
			list = new LinkedList<>();
			lists.add(list);
		} else {
			list = lists.get(level);
		}

		list.add(root);
		createLevelLinkedList(root.left, lists, level + 1);
		createLevelLinkedList(root.right, lists, level + 1);
	}

	ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
		createLevelLinkedList(root, lists, 0);
		return lists;
	}
}
