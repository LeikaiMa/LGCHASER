package mimumWindowSubstring;
// 要找最小的window 就是包括里面所有字母的字符串长度最小，肯定要遍历整个要查找的字符串S 所以肯定复杂度至少为O(n)
// 一般要为n 就是遍历至少一个指针遍历一遍不回头，想到这个是个字符串，最好是有两个指针， 一个是指在要匹配的字符串T的前面一个是后面。
// 因为要匹配，一般的会想到是用hashmap 来进行预存，但是可能有重复的，也就不好存所在的index，而是要存个数，这时候hashmap 就比不过array
// 因为ascii 只有256，可以接收先生成一个256长度的int 的字符串来存每个字符的个数。
// 这样将T遍历一遍就可以将每个字母出现的次数都统计出来。 
// 然后就是要进行匹配，因为现在用的是数组，所以要进行匹配更新维护的也就是一个256的数组。里面主要存的是出现符合T的字母的个数，其他的存不存也就没有什么意义。
// 然后什么时候结束，为了每次都加起来，就预设置一个int 来记录总数，但是因为里面没有告诉这些总数分别包括那些，那就需要我在+1 的时候分别对待，
// 比如在遇到是属于T的字母，如果已经超过了总共需要的个数，就没有必要增加。 而appear 这个指出现次数需要自增，这就是为什么要区别对待。
// 在外面只有出现的字母才有必要+1 所以看expect 是不是>0
// 首先就让字符尾的指针往后移，一直移到总共个数达到T的长度，也就是每个字母至少出现了至少需要的次数。
// 这个时候看看头能不能缩进，因为是要最小，如果开头有些没有必要的字母就可以去除。
// 而且如果遇到的这个字母已经超过需要的量，也可以缩进。缩进的时候要注意将这个字母出现的次数-1
// 一旦到不能缩进，就将这个子字符串的长度和最外面的min 进行比较，如果小，更新min 还有minStart 
// 然后尾部再往后走，如果字符串里面的字母个数满足T的需求都可以进行缩。然后更新min和minStart
// 最后到了结尾，出来看看min有没有一次更新过，如果没有更新过就说明没有这样的存在，可以返回 ""
// 如果更新过了，那么就返回这个substring 这就是为什么要存size 和start 的原因
// 比较好的一道题。
public class TwoPointerDp {

	public static String minWindow(String S, String T) {
		int[] appearCount = new int[256];
		int[] expectCount = new int[256];

		for (int i = 0; i < T.length(); i++) {
			expectCount[T.charAt(i)]++;
		}

		int wordEnd = 0, wordStart = 0;
		int appear = 0;
		int min = Integer.MAX_VALUE;
		int minStart = -1;
		for (; wordEnd < S.length(); wordEnd++) {
			char c = S.charAt(wordEnd);
			if (expectCount[c] > 0) {

				if (appearCount[c] < expectCount[c]) {
					appear++;
				}
				appearCount[c]++;
			}

			if (appear == T.length()) {
				while (appearCount[S.charAt(wordStart)] > expectCount[S
						.charAt(wordStart)]
						|| expectCount[S.charAt(wordStart)] == 0) {
					appearCount[S.charAt(wordStart)]--;
					wordStart++;
				}
				
				if (min > wordEnd - wordStart + 1) {
					min = wordEnd - wordStart + 1;
					minStart = wordStart;
				}
			}
		}
		
		if (min != Integer.MAX_VALUE) {
			return S.substring(minStart, minStart + min);
		} else {
			return "";
		}
	}
	
	public static void main(String[] args) {
		String S = "ADOBECODEBANC";
		String T = "ABC";
		System.out.println(minWindow(S, T));
	}
}
