package binaryTreePostorderTraversal;
// II?
import java.util.ArrayList;
import java.util.Stack;
// 本来的想法是再用一个stack 保存相应的对应的有没有访问过这个node的子树，用一个boolean 按照同样的顺序开始存
// 开始的时候存进去的时候都是false ，然后取出来的时候，先存进去变成true 然后看left 和right 的child 如果有，按照，right 再left 的顺序，都是false 来存进去。
// 这样能够标记好，后输出避免重复运算。
// 但是这种情况可以看做有一个prev 的node ，有几种情况，stack 最上面就是这个prev 是这的left child 是这个的right child 
// 也可能是prev 是自己的left child 或者right child 
// 这样整个过程就是一个down 一个up 的过程。 如果是down 的过程，因为是先要输出左边的，所以先访问左边，这里要注意的不是两个if 因为只要往左边探，右边的等返回来的时候再探。
// 同样要考虑的是开始的时候是prev 是null 这个时候也要进去也属于down 的过程。
// 但是有些可能只有right 所以在down 的时候不能省略，而是优先是左，实在没有的情况再是右
// 如果是up 上来了，那么就是cur 的left 是prev 那么看右边有没有，如果右边还有的话，就先探到右边，也就是将其push 进去。
// 最后结束的时候算做一次经历结束，应该将prev 变成cur
// 有三种情况是要将cur 的值输到arraylist 的，一个是到leaf 也就是down 的时候没有left 也咩有right child 
// 一种是从left 上来之后发现没有right 就应该把这个root 给存进去
// 还有一种，是从right 上来的，这时候到了输出root 的时候， 记住在这三种情况下都是要将值pop 出来
// 但是这个可以不单独列出来，可以直接放到else 里面。
// 因为每次都是prev 变成cur 而cur 是peek 开头的，如果没有新的push 下次就是和现在的是相等的，所以都到了else 里面，这里可以同时添加到结果里，然后将这个值pop 出来。
// 容易犯的错误在于 不同于其他的情况开始的是peek 出cur ，直到 加进去的时候是pop 这样可以利用else 的功能
// down 时候是else if 而不是if 因为这个只是为了给只有right 用的。
public class StackAndPrev {
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		if (root == null) {
			return result;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode prev = null;

		while (!stack.isEmpty()) {
			TreeNode cur = stack.peek();
			if (prev == null || prev.left == cur || prev.right == cur) {
				if (cur.left != null) {
					stack.push(cur.left);
				} else if (cur.right != null) {
					stack.push(cur.right);
				}
			} else if (cur.left == prev) {
				if (cur.right != null) {
					stack.push(cur.right);
				}
			} else {
				result.add(cur.val);
				stack.pop();
			}

			prev = cur;
		}

		return result;
	}
}
