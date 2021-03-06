package wordBreak;
// 速度太慢，因为递归太多。而且没有记录，要 2^n 复杂度。
import java.util.HashSet;
import java.util.Set;

public class RecursiveBackTrace {
	public static boolean wordBreak(String s, Set<String> dict) {
		return wordBreakHelper(s, dict, 0);
	}

	private static boolean wordBreakHelper(String s, Set<String> dict, int start) {
		if (start == s.length()) {
			return true;
		}

		for (String word : dict) {
			int len = word.length();
			if (start + len > s.length()) {
				continue;
			}
//			System.out.println("string length: " + s.length() + " start: "
//					+ start + " start + len: " + (start + len));
//			System.out.println(s.substring(start, start + len));
			if ((s.substring(start, start + len)).equals(word)) {
				if (wordBreakHelper(s, dict, start + len)) {
					return true;
				}
			}
		}
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
