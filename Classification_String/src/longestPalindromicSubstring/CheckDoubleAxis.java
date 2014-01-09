package longestPalindromicSubstring;
// II
//在一个string 中找最大的回文，可以用的方法就是以某个为轴，然后向两边进行扩展，如果轴的两边相同，说明扩展到目前属于回文。
//轴有两种，一种是单轴，一种两个相同字母的双轴，轴都是需要从前向后进行遍历。
//优化的是开始如果没有或者是1 就是直接返回原来的字符串
//如果不只是1就说明最最基本的是第一个字符本身，可以作为基础条件。
//expand 也可以有个基础的值，后面的每一次都必须是在这个基础值上+1来完成，因为题目里已经保证这个只有一个唯一的最长的回文。
//同时要进行限定的expand 不成超过字符串的边界。
//检查要从最小的1开始，如果没到最大值的时候就已经不是回文就说明可以直接不用检查比他更大的expand
//检查完单轴和双轴的，就可以直接将所记录的最大回文直接进行返回。
public class CheckDoubleAxis {
	public String longestPalindrome(String s) {
		if (s == null || s.isEmpty() || s.length() == 1) {
			return s;
		}

		int max = 0;
		int lm = -1;
		int hm = -1;

		for (int i = 0; i < s.length(); i++) {
			for (int span = 0; span <= Math.min(i, s.length() - 1 - i); span++) {
				int l = i - span;
				int h = i + span;

				if (s.charAt(l) == s.charAt(h)) {
					if (2 * span + 1 > max) {
						max = 2 * span + 1;
						lm = l;
						hm = h;
					}
				} else {
					break;
				}
			}
		}

		for (int i = 0; i < s.length() - 1; i++) {
			for (int span = 0; span <= Math.min(i, s.length() - 1 - i - 1); span++) {
				int l = i - span;
				int h = i + 1 + span;

				if (s.charAt(l) == s.charAt(h)) {
					if (2 * span + 2 > max) {
						max = 2 * span + 2;
						lm = l;
						hm = h;
					}
				} else {
					break;
				}
			}
		}

		return s.substring(lm, hm + 1);
	}
}
