package longestSubstringWithoutRepeatingCharacters;
// 这题目就是重复的字符前面的字符不可能会有更长的不重复的字符，所以一旦遇到了重复的就要将之前的前部删掉。
// 也就是每次要记录，经过的元素，记录有两种方法，一种是用hashmap 一种就是用array ，因为是考察的是字母，所以只需要256长度的数组。
// 每次往前读一位就要将这个数据记录下来，因为不能有重复，所以状态只有两种，有还是没有，所以可以用boolean 来表示，还有一个指针放在后面作为删除的时候用。
// 一旦有重复，就是这个已经在前面置为了true，就可以先求出目前不重复的字符串的长度，也就是跑的快的字符位置-跑的慢的。
// 然后将第一次出现前面的都置为没有看见，就是false，因为自己有第二次，所以这个还是true 不能置为false
// 因为起点变为第一次出现的后面一个。所以要注意指针的位置要在这个基础上在+1
// 如果是不存在就只要正常的进行标记就可以了。
public class TwoPointer {
	public static int lengthOfLongestSubstring(String s) {
		boolean[] character = new boolean[256];
		int i = 0;
		int j = 0;
		int max = Integer.MIN_VALUE;
		while (j < s.length()) {
			char c = s.charAt(j);
			if (character[c]) {
				max = Math.max(max, j - i);
				while (s.charAt(i) != c) {
					character[s.charAt(i)] = false;
					i++;
				}
				i++;
				j++;
			} else {
				character[c] = true;
				j++;
			}
		}
		max = Math.max(max, j - i);
		return max;
	}

	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s) == 3);
		s = "bbbbb";
		System.out.println(lengthOfLongestSubstring(s) == 1);
	}
}
