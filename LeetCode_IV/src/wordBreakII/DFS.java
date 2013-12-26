package wordBreakII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DFS {
	public static ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> result = new ArrayList<String>();
		if (s == null || s.isEmpty()) {
			return result;
		}
		StringBuffer sb = new StringBuffer();
		wordBreakHelper(0, s, dict, result, sb);
		return result;
	}

	private static void wordBreakHelper(int start, String s, Set<String> dict,
			ArrayList<String> result, StringBuffer sb) {
		int len = s.length();
		if (start == len) {
			result.add(sb.substring(0, sb.length() - 1));
			return;
		}

		for (int end = start + 1; end <= len; end++) {
			// System.out.println("end: " + end + "len: " + len + "start: " +
			// start);
			String left = s.substring(start, end);
			if (dict.contains(left)) {
				int lastPos = sb.length();
				sb.append(left + " ");
				wordBreakHelper(end, s, dict, result, sb);
				sb.delete(lastPos, sb.length());
			}
		}
	}

	public static void main(String[] args) {
		// String s = "catsanddog";
		// Set<String> dict = new HashSet<>();
		// dict.add("cat");
		// dict.add("cats");
		// dict.add("and");
		// dict.add("sand");
		// dict.add("dog");
		// System.out.println(wordBreak(s, dict));
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
