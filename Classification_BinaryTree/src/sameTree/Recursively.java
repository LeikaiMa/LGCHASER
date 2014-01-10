package sameTree;
// II
//比较两个tree 是否相同，首先要判断两个是否为null 如果都是null 就直接返回true 
//如果一个有一个没有就返回false
//再比较两个里面的value 如果不同就直接否定为false
//最后要比较left 和right ，必须要同时满足才能是true
//用&& 可以利用短路性质，加快速度
public class Recursively {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}

		if (p == null || q == null) {
			return false;
		}

		if (p.val != q.val) {
			return false;
		}

		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
