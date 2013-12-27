package splitSentence;

// 从start 和end 都为0 开始，有两种方式，一种是进行切割的，一种是将这个保存为一个整体进行所以有两种方式，而通过这两种方式来进行比较，取消的那一个。
// 这样递归的base case 是end 到达尾部，这样有两种情况一种还是进行切割， 这时候两个值是相同的，返回的是0，然后加上前面的一个不影响。
// 一个是没有切割联合在一起的，这样值最大，可能不会在进行切割的之上。如果前一个没有值，那么就相等，因为正好等于长度的大小，如果存在那么就应该是0.这样肯定也不会被min 取到，是一个很巧妙的base case的方法
// 首先利用substring 来进行word 然后切割进行递归。切割的意思是后面判断的收尾还是一样。都是end + 1
// 连接的意思，就是start 不变，但是end 加上1，便是连接在一起。
// 之前如果单词在里面不存在，就要将后面的返回回来的值加上单词长度。
// 如果是联合的，看之后递归回来的情况。
// 最后返回的是两个比较的小值。
public class Simple {
	public String sentence;
	public Trie dictionary;

	public int parseSimple(int wordStart, int wordEnd) {
		if (wordEnd >= sentence.length()) {
			return wordEnd - wordStart;
		}

		String word = sentence.substring(wordStart, wordEnd + 1);

		int bestExact = parseSimple(wordEnd + 1, wordEnd + 1);

		if (!dictionary.contains(word, true)) {
			bestExact += word.length();
		}

		int bestExtend = parseSimple(wordStart, wordEnd + 1);

		return Math.min(bestExact, bestExtend);
	}
}
