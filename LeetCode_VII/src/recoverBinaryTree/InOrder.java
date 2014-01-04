package recoverBinaryTree;
// 恢复BST中的两个被交换的node 的值，用O(n) 的空间话还是可以做的，将所有的值从里面取出来，在外面sort 一遍，然后将里面的值按照inorder 的顺序存到BST的每一个node 里面。
// 但是这种方法会很慢，而且很多都是正确的在重复插入值。
// 所以思考怎么用O(1) 的空间大小来进行存储，需要重新思考，关键是只要找到这两个错误的位置进行交换就可以了。
// 思考BST的本质，这一点想到了，就是in order的 时候就是输出的就是一个按照顺序排的array，
// 下面就要思考如何找出这两个出错的位置。因为交换了，就是前面一个小值放到后面去了一个大值放到前面来了。
// 这样被放在前面的大值就比前面的一个数大，或者是头的情况就没有，或者是比后面的值大。所以因为前面的值有可能没有就不太适合比较，就找这个值比后面大的情况。
// 再看被放在后面的一个小值，和前面比是小的，和后面比是大的，所以考虑比较的对象，因为和前面一个保持相同就比较和前面比，小的就是被调到后面的小值。
// 总结上面思考的，就是整个array 里面有1个或者两个 前面比后面大的情况，1个的就是说明正好相邻的互换位置。
// 那么调到前面的大值就是第一个遇到的 前者比后者大的大值，因为不知道到底是有1个还是两个，所以第二个就是遇到前者比后者大的都要进行存储，正好最后存的是最后一个。也就是我们要招的值。
// 然后我们要进行比较，一种是和后者比较，一种是和前者比较，因为list 不好预知未来，但是前面的可以先存起来，所以开始的时候就设置一个prev 在我这里存在一个array 的第三个位置。前两个存的是要交换的元素。
// 每次到了一个node 就将这个node 存进这个第三个位置。因为是in order 的情况，所以这个一直是prev 的情况。
// 然后每次和前面一个比较。但是要注意是第一个元素是没有开始的，所以要等prev 不是空的是时候才比较。
// 然后遇到前者比后者大的，将后者存到第二个里面。 将前者存在第一个里面。 因为只存第一次的，所以找只有第一次才有的特征就是，这个是第一个还是空的，null 其他的时候都有值，就不用存了。
// 最后将第一个值和第二个值里面值进行交换。
// 要注意的是存在数组里面是treenode 这样回去也可以取值。不要只存值！
// 这个是比较好的题，要注重理解数据结构的本质。
public class InOrder {
	public void recoverTree(TreeNode root) {
		if (root == null) {
			return;
		}
		
		TreeNode[] swappedNode = new TreeNode[3];
		
		recoverTreeHelper(root, swappedNode);
		int val1 = swappedNode[0].val;
		int val2 = swappedNode[1].val;
		swappedNode[0].val = val2;
		swappedNode[1].val = val1;
	}

	private void recoverTreeHelper(TreeNode root, TreeNode[] swappedNode) {
		if (root == null) {
			return;
		}
		
		recoverTreeHelper(root.left, swappedNode);
		if (swappedNode[2] != null && swappedNode[2].val > root.val) {
			swappedNode[1] = root;
			if (swappedNode[0] == null) {
				swappedNode[0] = swappedNode[2];
			}
		}
		
		swappedNode[2] = root;
		
		recoverTreeHelper(root.right, swappedNode);
	}
}
