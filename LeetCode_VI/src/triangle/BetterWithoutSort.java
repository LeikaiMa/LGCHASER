package triangle;

import java.util.ArrayList;
// 这个比前一种方法好，因为这个是从后往前，用一个array 来进行存储，开始的时候将最顶上的那个复制到array里面。
// 然后比他短的要加的是自己序号和序号+1 的，从前往后的话可以在修改之前取到值，因为用的始终是后面 那一个。
// 依次到第一层，这个时候就只有一个解，一般都是从大的往小的走比较好。
// 这里自己犯的一个错误是将triangle size -1 来赋值最开始的array
public class BetterWithoutSort {
	public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}
		int[] results = new int[triangle.size()];
		for (int i = 0; i < triangle.size(); i++) {
			results[i] = triangle.get(triangle.size() - 1).get(i);
		}
		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				results[j] = triangle.get(i).get(j)
						+ Math.min(results[j], results[j + 1]);
			}
		}
		return results[0];
	}
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
		ArrayList<Integer> l1 = new ArrayList<>();
		l1.add(2);
		triangle.add(l1);
		ArrayList<Integer> l2 = new ArrayList<>();
		l2.add(3);
		l2.add(4);
		triangle.add(l2);
		ArrayList<Integer> l3 = new ArrayList<>();
		l3.add(6);
		l3.add(5);
		l3.add(7);
		triangle.add(l3);
		ArrayList<Integer> l4 = new ArrayList<>();
		l4.add(4);
		l4.add(1);
		l4.add(8);
		l4.add(3);
		triangle.add(l4);
		System.out.println(minimumTotal(triangle));
	}
}
