package combination;

import java.util.ArrayList;
// 这里用组合的方法使用了倒着插入的方法，通过k 不断减1 知道最后为1的时候将所有的n范围内的数新建一个arraylist
// 然后将这个list递归回去。每次插入比他要大的。
// 要注意的是，在base case 之前，不仅仅只有n 一个，可以是n 到 k 之间任意的个数，
// 这时候里面要用for loop 然后新建arraylist 将返回的值add 进新的，然后插入新的元素，在进行返回。
// 正着也可以，但是思考起来更加复杂一些。
public class BFSBacktrace {
	public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (k > n || n <= 0 || k <= 0) {
			return result;
		}

		result = combineHelper(n, k);
		return result;
	}

	private static ArrayList<ArrayList<Integer>> combineHelper(int n, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (k == 1) {
			for (int i = 1; i <= n; i++) {
				ArrayList<Integer> r = new ArrayList<Integer>();
				r.add(i);
				result.add(r);
			}
			return result;
		} else {
			for (int i = k; i <= n; i++) {
				ArrayList<ArrayList<Integer>> subResult = combineHelper(i - 1, k - 1);
				for (ArrayList<Integer> r: subResult) {
					ArrayList<Integer> subr = new ArrayList<Integer>();
					subr.addAll(r);
					subr.add(i);
					result.add(subr);
				}
			}
			return result;
		}
	}
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> result = combine(5, 2);
		for(ArrayList<Integer> r: result) {
			System.out.println(r);
		}
	}
}
