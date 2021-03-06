package wordLadder;

import java.util.ArrayList;
import java.util.HashSet;
// 这个是单向的，每一次进行的时候是取这个生成新的和自己不同的元素，如果到达结果，返回正确，然后将走过的步数+1之后返回。因为这个算是预测下一步，所以要+1
// 如果不是就将这个放在新的level的list 里面，类似于visited 的功能，这里破换字典直接删掉里面的元素。
// 然后将新的 list 和现在的list 进行更换，不断地循环，直到没有备选值为止，这时候没有找到结果，说明是没有值。
// 这个思路比较清楚，可以直接一步一步走下去。
public class UseHashSet {
	public static int ladderLength(String start, String end,
			HashSet<String> dict) {
		if (start.equals(end)) {
			return 1;
		}

		ArrayList<String> processing = new ArrayList<String>();
		processing.add(start);
		int len = 0;
		while (!processing.isEmpty()) {
			len++;
			ArrayList<String> tmp = new ArrayList<String>();
			for (String s : processing) {

				if (replace(s, end, dict, tmp)) {
					return len + 1;
				}

			}

			processing = tmp;

		}
		return 0;
	}

	private static boolean replace(String s, String end, HashSet<String> dict,
			ArrayList<String> tmp) {

		for (int i = 0; i < s.length(); i++) {
			char[] word = s.toCharArray();
			for (char c = 'a'; c <= 'z'; c++) {
				if (c == s.charAt(i)) {
					continue;
				}
				word[i] = c;
				String candidate = new String(word);

				if (candidate.endsWith(end)) {
					return true;
				}
				if (dict.contains(candidate)) {
					tmp.add(candidate);
					dict.remove(candidate);
				}

			}
		}
		return false;
	}

	public static void main(String[] args) {
		 String start = "hit";
		 String end = "cog";

//		 String start = "a";
//		 String end = "c";

//		String start = "hot";
//		String end = "dog";
		HashSet<String> dict = new HashSet<String>();
		 dict.add("hot");
		 dict.add("dot");
		 dict.add("dog");
		 dict.add("lot");
		 dict.add("log");

//		 dict.add("a");
//		 dict.add("b");
//		 dict.add("c");

//		dict.add("hot");
//		dict.add("dog");
		System.out.println(ladderLength(start, end, dict));
	}
}
