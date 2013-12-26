package wordBreak;

import java.util.HashSet;
import java.util.Set;
// 因为这里只需要判断是否能到达最后一个len长度的位置，所以只需要进行一维的dp
// 将每个字典中的词取出来，看在能不能放在这一位上，然后在最后一位标记为可到达，然后从index 为0的时候开始进行标记。
// 如果这一位无法从前面达到，即直接忽略。最后看能否到达len
// 这个类似于BFS，但是只是适用于比较短的，dict
// 长的dict 就应该从字符串出发，看不同长度的substring 在字典中有没有值，有值就标注，最后同样看最后有没有到达最后的位置。
public class DP {
	public static boolean wordBreak(String s, Set<String> dict) {
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 0; i < s.length(); i++) {
			if (!dp[i]) {
				continue;
			}
			for (String word : dict) {
				int len = word.length();
				int end = len + i;
				if (end > s.length()) {
					continue;
				} else {
					if (s.substring(i, end).equals(word)) {
						dp[end] = true;
					}
				}
			}
		}
		return dp[s.length()];
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
