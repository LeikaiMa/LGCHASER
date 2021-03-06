package triangle;

import java.util.ArrayList;
import java.util.Arrays;

public class ON {
	public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}
		if (triangle.size() == 1) {
			return triangle.get(0).get(0);
		}
		int[] results = new int[triangle.size()];
		results[0] = triangle.get(0).get(0);

		for (int i = 1; i < triangle.size(); i++) {
			results[i] = results[i - 1] + triangle.get(i).get(i);
			for (int j = i - 1; j > 0; j--) {
				results[j] = Math.min(results[j], results[j - 1]) + triangle.get(i).get(j);
			}
			results[0] = results[0] + triangle.get(i).get(0);
		}
		Arrays.sort(results);
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
