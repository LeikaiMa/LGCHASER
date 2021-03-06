package subSets;

import java.util.ArrayList;
import java.util.Arrays;
// 一点注意的是要升序输出，而递归下来是倒序，所以开始的时候要注意把array 倒叙。 但是因为是primitive，所以最好先转换为Collection
// 还有一点要deep copy就必须要进行clone 下来赋新的值。
public class Subsets {
	public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
		if (S == null) {
			return null;
		}
		Arrays.sort(S);
		ArrayList<Integer> s = new ArrayList<Integer>();
		for (int i = S.length - 1; i >= 0; i--) {
			s.add(S[i]);
		}
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		addSubSet(results, s, 0);
		return results;
	}

	private static void addSubSet(ArrayList<ArrayList<Integer>> results,
			ArrayList<Integer> s, int index) {

		if (index == s.size()) {
			ArrayList<Integer> a = new ArrayList<Integer>();
			results.add(a);
		} else {
			addSubSet(results, s, index + 1);
			int i = s.get(index);
			ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> a : results) {
				@SuppressWarnings("unchecked")
				ArrayList<Integer> c = (ArrayList<Integer>) a.clone();
				c.add(i);
				r.add(c);
			}
			results.addAll(r);

		}

	}

	public static void main(String[] args) {
		int[] S = new int[3];
		S[0] = 4;
		S[1] = 1;
		S[2] = 0;
		System.out.println(Arrays.toString(S));
		ArrayList<ArrayList<Integer>> result = subsets(S);
		for (ArrayList<Integer> arrayList : result) {
			System.out.println(arrayList);
		}
	}
}
