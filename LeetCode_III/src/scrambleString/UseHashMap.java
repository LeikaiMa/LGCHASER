package scrambleString;

import java.util.HashMap;

public class UseHashMap {
	public boolean isScramble(String s1, String s2) {
		if (s1 == null && s2 == null) {
			return true;
		}
		if (s1.isEmpty() && s2.isEmpty()) {
			return true;
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}
		for (int i = 0; i < s2.length(); i++) {
			char c = s2.charAt(i);
			if (!map.containsKey(c)) {
				return false;
			} else if (map.get(c) <= 0) {
				return false;
			} else {
				map.put(c, map.get(c) - 1);
			}
		}
		return true;
	}
}
