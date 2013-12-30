package editDistance;
// 这个的方法是将每种情况都列举出来，如果加上一个backtrack 的hashmap 就可以将整个过程反推出来。
// 整体的思路是通过比较两个字段的长度来判断，如果是相等是用replace，如果是小就插入，如果是大就删除，这个的问题在于如果是删头加尾就是长度相同，实际上只要删除和添加两步就可以完成，而我用的时候就要用replace 增加了步数。
// 这个在原来的基础上有更新的地方是如果是相同，就直接换成现在最后结果同样的位置的字母。如果是删除就比较不同的地方才开始删，其他保持不变，
// 添加的时候也是在不同的情况之后开始添加，而且直接添加的是最后结果这一位上字母。
// 因为原来那一题的情况是要保证中间过渡的词是在字典里，所以是需要进行遍历，而且只是替换，所以只要进行遍历就可以了
// 这题要速度，而且更新的情况更加复杂，所以需要用DP 来进行操作。
import java.util.ArrayList;
import java.util.HashSet;

public class BFSAndHashmap {
	public static int minDistance(String word1, String word2) {
		if (word1 == null || word1 == null) {
			return 0;
		}

		if (word1.length() == 0) {
			return word2.length();
		}
		if (word2.length() == 0) {
			return word1.length();
		}

		if (word1.equals(word2)) {
			return 0;
		}

		word1 = word1.toLowerCase();
		word2 = word2.toLowerCase();
		HashSet<String> visited = new HashSet<String>();
		visited.add(word1);
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add(word1);

		int step = -1;

		while (!arrayList.isEmpty()) {
			step++;
			ArrayList<String> tmp = new ArrayList<String>();
			for (String s : arrayList) {
				if (s.equals(word2)) {
					return step;
				} else {
					int len1 = word1.length();
					int len2 = word2.length();
					if (len1 < len2) {
						insertChar(word1, word2, tmp, visited);
					} else if (len1 == len2) {
						replaceChar(word1, word2, tmp, visited);
					} else {
						deleteChar(word1, word2, tmp, visited);
					}
				}
			}
			arrayList = tmp;
		}
		return -1;
	}

	private static void deleteChar(String word1, String word2, ArrayList<String> tmp,
			HashSet<String> visited) {
		int i = 0;
		for (; i < word2.length(); i++) {
			if (word1.charAt(i) != word2.charAt(i)) {
				break;
			}
		}
		for (; i < word1.length(); i++) {
			StringBuffer sb = new StringBuffer();
			sb.append(word1.substring(0, i)).append(word1.substring(i + 1));
			String s = sb.toString();
			if (!visited.contains(s)) {
				tmp.add(s);
				visited.add(s);
			}
		}
	}

	private static void replaceChar(String word1, String word2, ArrayList<String> tmp,
			HashSet<String> visited) {
		for (int i = 0; i < word1.length(); i++) {
			if (word1.charAt(i) == word2.charAt(i)) {
				continue;
			}
			char[] word = word1.toCharArray();
			word[i] = word2.charAt(i);
			String s = new String(word);
			if (!visited.contains(s)) {
				tmp.add(s);
				visited.add(s);
			}
		}

	}

	private static void insertChar(String word1, String word2, ArrayList<String> tmp,
			HashSet<String> visited) {
		int i = 0;
		for (; i < word1.length(); i++) {
			if (word1.charAt(i) != word2.charAt(i)) {
				break;
			}
		}
		for (; i <= word1.length(); i++) {
			StringBuffer sb = new StringBuffer();
			sb.append(word1.substring(0, i)).append(word2.charAt(i))
					.append(word1.substring(i));
			String s = sb.toString();
			if (!visited.contains(s)) {
				tmp.add(s);
				visited.add(s);
			}
		}

	}

	public static void main(String[] args) {
		String word1 = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdef";
		String word2 = "bcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefg";
		System.out.println(minDistance(word1, word2));
	}
}
