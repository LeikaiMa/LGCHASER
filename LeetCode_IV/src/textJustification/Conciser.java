package textJustification;

import java.util.ArrayList;
// 这个要比之前自己写的更加简洁，因为考虑到如果只有一个单词或者是最后一个list 这样话都是加上一个空格然后最后将整个string 补充到所指定的长度。
// 开始考虑这题的时候，主要也就是分三种情况，一种是只有一个单词，一种是不是结尾但不止一个单词，还有一个是结尾。
// 这里用的一个小技巧是到达第一个超过的时候将前面的全部合并起来。这样的话有一种情况就是最后一个超出了范围，虽然for loop 里面是这个范围，但是在if 里面之前先判断是否已经到了，这样可以直接短路进去。
// lastI 是从0 是利用0 肯定单个不会超过L 总共判断的长度是总共的length 和 i 这个length 加上中间的空格，因为是超前一个，直接减就是空格的个数。
// 如果超过了说明之前的肯定是最大的满足的。
// 计算出中间的space 的个数，是直接相减，因为是计算前一个所以是要减1，然后先插一个单词一个空格，判断如果是最后一个就不要加空格，最后加上多余的空格
// 如果是多个单词的不是最后一行的情况，那么要计算正常的每个的空格数，这个时候用整除来进行，然后多余的是用求余来进行，然后从左向右来+1 来补充
// 最后如果不是最后一个，需要将现在这个补到cur len里面。因为是提前一个计算。
// 如果还是满足，就将现在的len 加上去。
public class Conciser {
	public ArrayList<String> fullJustify(String[] words, int L) {
		int wordsCount = words.length;
		ArrayList<String> result = new ArrayList<String>();
		int curLen = 0;
		int lastI = 0;
		for (int i = 0; i <= wordsCount; i++) {
			if (i == wordsCount || curLen + words[i].length() + i - lastI > L) {
				StringBuffer buf = new StringBuffer();
				int spaceCount = L - curLen;
				int spaceSlots = i - lastI - 1;
				if (spaceSlots == 0 || i == wordsCount) {
					for (int j = lastI; j < i; j++) {
						buf.append(words[j]);
						if (j != i - 1)
							appendSpace(buf, 1);
					}
					appendSpace(buf, L - buf.length());
				} else {
					int spaceEach = spaceCount / spaceSlots;
					int spaceExtra = spaceCount % spaceSlots;
					for (int j = lastI; j < i; j++) {
						buf.append(words[j]);
						if (j != i - 1)
							appendSpace(buf, spaceEach
									+ (j - lastI < spaceExtra ? 1 : 0));
					}
				}
				result.add(buf.toString());
				lastI = i;
				curLen = 0;
			}
			if (i < wordsCount)
				curLen += words[i].length();
		}
		return result;
	}

	private void appendSpace(StringBuffer sb, int count) {
		for (int i = 0; i < count; i++)
			sb.append(' ');
	}
}
