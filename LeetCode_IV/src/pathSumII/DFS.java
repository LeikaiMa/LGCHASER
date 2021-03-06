package pathSumII;

import java.util.ArrayList;
// 这个同样是用的DFS 来进行解决，不过因为要写路径，所以要返回具体的路径，每次都插在最前面。
// 最后的node 的时候，如果是就加进去，如果不是就返回一个空的
// 在上一层如果不是空的就将自己加进去这个arraylist，因为从后向前就只有一个，不会有重复，所以就不需要deep copy 出来。
// 最后返回helper 函数里面返回的结果。
public class DFS {
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return paths;
		}
		int cur = 0;
		paths = pathSumHelper(root, cur, sum);
		return paths;
	}

	private ArrayList<ArrayList<Integer>> pathSumHelper(TreeNode root, int cur,
			int sum) {
		ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
		cur += root.val;
		if (root.left == null && root.right == null) {
			if (cur == sum) {
				ArrayList<Integer> path = new ArrayList<Integer>();
				path.add(root.val);
				paths.add(path);
			}
			return paths;
		}

		if (root.left != null) {
			ArrayList<ArrayList<Integer>> subPaths = new ArrayList<ArrayList<Integer>>();
			subPaths = pathSumHelper(root.left, cur, sum);
			if (subPaths.size() > 0) {
				for (ArrayList<Integer> subPath : subPaths) {
					subPath.add(0, root.val);
					paths.add(subPath);
				}
			}
		}

		if (root.right != null) {
			ArrayList<ArrayList<Integer>> subPaths = new ArrayList<ArrayList<Integer>>();
			subPaths = pathSumHelper(root.right, cur, sum);
			if (subPaths.size() > 0) {
				for (ArrayList<Integer> subPath : subPaths) {
					subPath.add(0, root.val);
					paths.add(subPath);
				}
			}
		}
		return paths;
	}
}
