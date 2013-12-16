package rankOfNumber;
// 因为是BST， 所以有常规的insert 如果是<= data 就塞进左边，如果 > data 就塞进右边。
// 但是如果是node 的情况，很多时候要考虑到是否为null
// 在insert 的时候可以用递归的方法，因为左右child 都是同样的node
// 因为是将相同的也塞进左边，所以很自然得到的时候和自己相等或者比自己小的就可以直接去left size
// 同时也可以用in order 的方式进行traverse 整个BST
// 同样得到rank 的方法也是需要进行判断是否为null 如果是null 就返回-1 而且左边是就返回左边的rank 如果是右边就返回右边+左边 + 1
// 同样也是需要用递归进行求解。
// 如果想要考虑全部，一种很好的方法就是看if else 语句有没有全部包含。
public class RankNode {
	public int left_size = 0;
	public RankNode left, right;
	public int data = 0;

	public RankNode(int d) {
		data = d;
	}

	public void insert(int d) {
		if (d <= data) {
			if (left != null) {
				left.insert(d);
			} else {
				left = new RankNode(d);
			}
			left_size++;
		} else {
			if (right != null) {
				right.insert(d);
			} else {
				right = new RankNode(d);
			}
		}
	}

	public int getRank(int d) {
		if (d == data) {
			return left_size;
		} else if (d < data) {
			if (left == null) {
				return -1;
			} else {
				return left.getRank(d);
			}
		} else {
			int right_rank = right == null ? -1 : right.getRank(d);
			if (right_rank == -1) {
				return -1;
			} else {
				return left_size + 1 + right_rank;
			}
		}
	}
}
