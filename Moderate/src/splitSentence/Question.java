package splitSentence;

import java.util.Hashtable;
// 如果是要进行返回里面的内容而不仅仅是是要进行比较不合适的个数，这时候要用到object
// 复制的时候就不能仅仅是取值，而是应该将它deep copy 出来
// 一种方法是将他直接new 出来，里面用里面的参数来进行传递，这样返回来的reference 也就不同了。
public class Question {
	public String sentence;
	public Trie dictionary;

	public static class Result {
		public int invalid = Integer.MAX_VALUE;
		public String parsed = "";

		public Result(int inv, String p) {
			invalid = inv;
			parsed = p;
		}

		public Result clone() {
			return new Result(this.invalid, this.parsed);
		}

		public static Result min(Result r1, Result r2) {
			if (r1 == null) {
				return r2;
			} else if (r2 == null) {
				return r1;
			}

			return r2.invalid < r1.invalid ? r2 : r1;
		}
	}

	public Result parse(int wordStart, int wordEnd,
			Hashtable<Integer, Result> cache) {
		if (wordEnd >= sentence.length()) {
			return new Result(wordEnd - wordStart, sentence
					.substring(wordStart).toUpperCase());
		}

		if (cache.containsKey(wordStart)) {
			return cache.get(wordStart).clone();
		}

		String currentWord = sentence.substring(wordStart, wordEnd + 1);

		boolean validPartial = dictionary.contains(currentWord, false);
		boolean validExact = validPartial
				&& dictionary.contains(currentWord, true);

		Result bestExact = parse(wordEnd + 1, wordEnd + 1, cache);
		if (validExact) {
			bestExact.parsed = currentWord + " " + bestExact.parsed;
		} else {
			bestExact.invalid += currentWord.length();
			bestExact.parsed = currentWord.toLowerCase() + " "
					+ bestExact.parsed;
		}

		Result bestExtend = null;
		if (validPartial) {
			bestExtend = parse(wordStart, wordEnd + 1, cache);
		}

		Result best = Result.min(bestExact, bestExtend);
		cache.put(wordStart, best.clone());
		return best;
	}

}
