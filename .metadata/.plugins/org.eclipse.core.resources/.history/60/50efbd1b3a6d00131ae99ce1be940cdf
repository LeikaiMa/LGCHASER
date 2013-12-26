package wordBreak;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Recursive {
	public static boolean wordBreak(String s, Set<String> dict) {
		if (dict.isEmpty()) {
			return false;
		}

		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		for (String word : dict) {
			map.put(word, true);
		}

		return wordBreakHelper(s, map);

	}

	private static boolean wordBreakHelper(String s,
			HashMap<String, Boolean> map) {
		if (map.containsKey(s)) {
			return map.get(s);
		}

		for (int i = s.length() - 1; i > 0; i--) {
			String left = s.substring(0, i);
			String right = s.substring(i);
			if (map.containsKey(left) && map.get(left)
					&& wordBreakHelper(right, map)) {
				return true;
			}
		}
		map.put(s, false);
		return false;
	}

	public static void main(String[] args) {
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
		

		System.out.println(wordBreak(s, dict) == false);
	}
}
