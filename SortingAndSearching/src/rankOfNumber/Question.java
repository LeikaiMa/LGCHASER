package rankOfNumber;
// 因为要去得到每一个的rank 如果用普通的array的方法，要进行平移，所消耗的会很大，用bst 会少很多log n 。
// bst 关键的是node，可以自己定义node 内的内容，最基本的是一个left 和right node 还有本身的data，但是在这一题要求排序，所以要再加上一项是记录
// left child 的个数。
public class Question {
	private static RankNode root = null;

	public static void track(int number) {
		if (root == null) {
			root = new RankNode(number);
		} else {
			root.insert(number);
		}
	}

	public static int getRankOfNumber(int number) {
		return root.getRank(number);
	}
}
