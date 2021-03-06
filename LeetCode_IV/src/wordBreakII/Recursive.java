package wordBreakII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Recursive {
	public static ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> result = new ArrayList<String>();
		if (dict == null || dict.isEmpty()) {
			return result;
		}
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		for (String word : dict) {
			map.put(word, true);
		}
		result = wordBreakHelper(s, map);
		return result;
	}

	private static ArrayList<String> wordBreakHelper(String s,
			HashMap<String, Boolean> map) {
		ArrayList<String> result = new ArrayList<String>();
		if (map.containsKey(s)) {
			if (map.get(s)) {
				result.add(s);
			} else {
				map.put(s, false);
			}
		}
		for (int i = s.length() - 1; i > 0; i--) {
			String left = s.substring(0, i);
			String right = s.substring(i);

			if (map.containsKey(left) && map.get(left)) {
				ArrayList<String> rights = wordBreakHelper(right, map);
				if (rights.size() > 0) {
					for (String subRight : rights) {
						result.add(left + " " + subRight);
					}
				}
			}
		}
		if (!map.containsKey(s)) {
			map.put(s, false);
		}
		return result;
	}

	public static void main(String[] args) {
//		String s = "catsanddog";
//		Set<String> dict = new HashSet<>();
//		dict.add("cat");
//		dict.add("cats");
//		dict.add("and");
//		dict.add("sand");
//		dict.add("dog");
//		System.out.println(wordBreak(s, dict));
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		Set<String> dict = new HashSet<>();
		dict.add("a");
		dict.add("aa");
		dict.add("aaa");
		dict.add("aaaa");
		dict.add("aaaaa");
		dict.add("aaaaaa");
		dict.add("aaaaaaa");
		dict.add("aaaaaaaa");
		dict.add("aaaaaaaaa");
		dict.add("aaaaaaaaaa");
		

		System.out.println(wordBreak(s, dict));
	}

}
