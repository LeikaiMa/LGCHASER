package longestSubstringWithoutRepeatingCharacters;

import java.util.ArrayList;
// 这个用的方法是主要是能够将重复出现的字母，从开始到第一次出现删掉功能，用到subList clear 的method
// 主要是重复之前的不能够再长了，只有避开重复的字符，也就是第一次出现之后的第一个开始有可能变长。
// 而之前积累的string 的长度是潜在最大的，所以要进行比较。
// 这里主要看长度是用size 删之前的片段是用subList 的方法。
public class UseArraylist {
	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		if (s.length() == 1) {
			return 1;
		}
		int max = Integer.MIN_VALUE;
		ArrayList<Character> subString = new ArrayList<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int index = subString.indexOf(c);
			if (index == -1) {
				subString.add(c);
			} else {
				max = Math.max(subString.size(), max);
				subString.subList(0, index + 1).clear();
				subString.add(c);
			}
		}
		max = Math.max(subString.size(), max);
		return max;
	}
	
	public static void main(String[] args) {
		String s= "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s)==3);
		s = "bbbbb";
		System.out.println(lengthOfLongestSubstring(s));
	}
}
