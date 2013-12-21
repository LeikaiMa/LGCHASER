package distinctSubsequences;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

// 这个用了一个比较复杂的一个方法。
// 用了DFS 首先建一个DP，将每个字母对应的在另外一个字符串中位置表示出来，放进一个treeset
// 每次找到一个，在他的所对应的后面一个去找相应的字母的所在位置，如果不是正好下一个位置，说明中间的那些字母已经被删除。
// 要注意的是每次去取的subSet 是比他要大的，这样到了最后一个如果还是有值的话说明可以有这一种方法。
// 然后递归回来相加。
// 但是时间复杂度要比完全在DP里操作要高很多。

public class DPSolution {
	public int numDistinct(String S, String T) {
		if (S.length() < T.length()) {
			return 0;
		}

		if (T.length() == 0 && S.length() != 0) {
			return 1;
		}

		if (T.length() == 0 && S.length() == 0) {
			return 1;
		}
		ArrayList<TreeSet<Integer>> tArrayList = new ArrayList<TreeSet<Integer>>();
		for (int i = 0; i < T.length(); i++) {
			tArrayList.add(new TreeSet<Integer>());
		}
		for (int i = 0; i < T.length(); i++) {
			for (int j = 0; j < S.length(); j++) {
				if (T.charAt(i) == S.charAt(j)) {
					tArrayList.get(i).add(j);
				}
			}
		}
		if (tArrayList.size() == 1) {
			return tArrayList.get(0).size();
		}
		int num = numDistinctHelper(tArrayList, 1, tArrayList.get(0).tailSet(0));
		return num;
		
		
		      
	}

	private int numDistinctHelper(ArrayList<TreeSet<Integer>> tArrayList,
			int start, SortedSet<Integer> subT) {
		if (start == tArrayList.size()) {
			return subT.size();
		} else {
			int result = 0;
			for (int i : subT) {
				SortedSet<Integer> nextT = tArrayList.get(start).tailSet(i + 1);
				if (nextT.size() == 0) {
					continue;
				}
				result += numDistinctHelper(tArrayList, start + 1, nextT);
			}
			return result;
		}
	}

	public static void main(String[] args) {
//		String S = "ABCDE";
//		String T = "AEC";
		 String S = "rabbbit";
		 String T = "rabbit";
//		 String S = "aacaacca";
//		 String T = "ca";
		System.out.println(new DPSolution().numDistinct(S, T));
	}
}
