package longestPalindromeSubstring;
// 在一个string 中找最大的回文，可以用的方法就是以某个为轴，然后向两边进行扩展，如果轴的两边相同，说明扩展到目前属于回文。
// 轴有两种，一种是单轴，一种两个相同字母的双轴，轴都是需要从前向后进行遍历。
// 优化的是开始如果没有或者是1 就是直接返回原来的字符串
// 如果不只是1就说明最最基本的是第一个字符本身，可以作为基础条件。
// expand 也可以有个基础的值，后面的每一次都必须是在这个基础值上+1来完成，因为题目里已经保证这个只有一个唯一的最长的回文。
// 同时要进行限定的expand 不成超过字符串的边界。
// 检查要从最小的1开始，如果没到最大值的时候就已经不是回文就说明可以直接不用检查比他更大的expand
// 检查完单轴和双轴的，就可以直接将所记录的最大回文直接进行返回。
public class Axis {
	public static String longestPalindrome(String s) {
		if (s == null) {
			return null;
		}
		if (s.isEmpty() || s.length() == 1) {
			return s;
		}
		int length = s.length();
		int le = 0;
		String result = s.substring(0, 1);

		for (int i = 0; i < length; i++) {
			int expand = le + 1;
			while (i - expand >= 0 && i + expand < length) {
				int e = 1;
				for (; e <= expand; e++) {
					if(s.charAt(i -e) != s.charAt(i+e)) {
						break;
					}
				}
				if (e > expand) {
					le = expand;
					result = s.substring(i - expand, i + expand + 1);
					expand++;
				} else {
					break;
				}
				
			}

			if (result.equals(s)) {
				return s;
			}
		}
		le = ((le * 2 + 1)- 2) /2;
		for (int i = 0; i < length - 1; i++) {
			if (s.charAt(i) != s.charAt(i + 1)) {
				continue;
			} else if (result.length() == 1) {
				result = s.substring(i, i+2);
			}
			int expand = le + 1 ;
			while (i - expand >= 0 && i + 1 + expand < length) {
				int e = 1;
				for (; e <= expand; e++) {
					if(s.charAt(i -e) != s.charAt(i+e + 1)) {
						break;
					}
				}
				if (e > expand)  {
					le = expand;
					result = s.substring(i - expand, i + expand + 2);
					expand++;
				} else {
					break;
				}
				
			}
			if (result.equals(s)) {
				return s;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		String s = "abc";
		System.out.println(longestPalindrome(s).equals("a"));
		s = "abba";
		System.out.println(longestPalindrome(s).equals("abba"));
		s = "ababba";
		System.out.println(longestPalindrome(s).equals("abba"));
		s = "abacaba";
		System.out.println(longestPalindrome(s).equals("abacaba"));
		s = "bb";
		System.out.println(longestPalindrome(s).equals("bb"));
		s = "aaaabaaa";
		System.out.println(longestPalindrome(s).equals("aaabaaa"));
	}
}
