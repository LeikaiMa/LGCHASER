package splitSentence;
// 在这里面做了两个优化，一个是将已经做过的存进一个hashtable 里面。然后每次读取的时候先检查hashtable 里面有没有相应的东西如果有就可以直接返回结果。
// 还有一个就是先去预判有没有这个单词有没有开头的，如果没有就可以直接返回最大的数值，这样就不必计算后面的值了。
// 同样的是进行递归运算 base case 是如果wordEnd 到达最后面了，将wordEnd - wordStart 作为返回值。
// 然后看cache 里面是不是已经有start 的存在，如果有就直接返回里面的值。
// 没有的话就要进行计算。 
// 下面依旧是两种情况，一个是将两个进行截断，是用wordStart 和 wordEnd + 1 进行substring
// 然后将后面的全部变成wordEnd + 1 的形式传到后面去，
// 返回的值是Exact 的值， 如果这个分割开来的不是word 就要将这个word 的长度直接加进去。
// 然后还有一种就是将两个进行联合，这时候start 不变，end 变成加1
// 但是优化的情况是判断截出来的单词如果本身就不能组成单词这样把他联合起来没有意义。可以不进行递归，然后返回的是Integer 的最大的形式。
// 最后比较两个的大小返回。
import java.util.Hashtable;

public class Optimization {
	public String sentence;
	public Trie dictionary;

	public int parseOptimized(int wordStart, int wordEnd,
			Hashtable<Integer, Integer> cache) {
		if (wordEnd >= sentence.length()) {
			return wordEnd - wordStart;
		}

		if (cache.contains(wordStart)) {
			return cache.get(wordStart);
		}

		String currentWord = sentence.substring(wordStart, wordEnd + 1);

		boolean validPartial = dictionary.contains(currentWord, false);

		int bestExact = parseOptimized(wordEnd + 1, wordEnd + 1, cache);

		if (!validPartial || !dictionary.contains(currentWord, true)) {
			bestExact += currentWord.length();
		}

		int bestExtend = Integer.MAX_VALUE;
		if (validPartial) {
			bestExtend = parseOptimized(wordStart, wordEnd + 1, cache);
		}

		int min = Math.min(bestExact, bestExtend);

		cache.put(wordStart, min);
		return min;
	}
}
