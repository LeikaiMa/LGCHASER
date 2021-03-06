package substringWithConcatenationOfAllWords;
// 这个是要求能不能有给定的参考单词，每个只用一次形成substring
// 不可能将所有单词排列组合看这些有没有，并且分别在哪个地方。
// 我现在采用的是DP 的方法，因为所有的单词的长度都是相等的，那么我可以针对每个可以形成这个长度单词的首字母位置写下对应的单词的序号。
// 这就要先建一个map 来写对应的单词和他自己的序号。
// 开始没有考虑单词会有重复，也就直接放进去单词和他本身的序号。
// 但是一旦有重复那么就会在map 里面覆盖。不能够统计出现过几次。
// 我采用的方法是建一个wrapper class 里面有自己的编号和出现的次数。
// 建好了dp 之后就是检查每个这么长的子字符串是不是只用words不重复的一遍完成。
// 一个一个进行移动，总共的个数是总长度-完全连接后的长度 +1
// 开始的时候设置一个初始参量，每个是每个的可以取的次数。如果在里面对应的找不到也就是-1的情况或者是次数用完那就返回false 如果还有存在，那么就将次数-1.完全通过之后返回true
// 如果成功的情况就将这个起始点的位置放进最终的结果里面
// 注意找的时候是有间隔的找，然后大循环的次数是 总共的长度 - 每个的长度 +1
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DPWithHashMap {
	public ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		if (S == null || S.length() == 0 || L == null || L.length == 0) {
			return indexes;
		}
		HashMap<String, Times> words = new HashMap<String, Times>();
		int count = 0;
		for (int i = 0; i < L.length; i++) {
			if (words.containsKey(L[i])) {
				words.get(L[i]).times++;
			} else {
				words.put(L[i], new Times(count++));
			}

		}
		int len = L[0].length();
		int[] dp = new int[S.length() - len + 1];
		createDP(dp, S, L, len, words);
		for (int i = 0; i < (S.length() - len * L.length + 1); i++) {
			if (checkWord(i, dp, L.length, len, words)) {
				indexes.add(i);
			}
		}
		return indexes;

	}

	private static boolean checkWord(int start, int[] dp, int size, int len,
			HashMap<String, Times> words) {
		int[] dpb = new int[words.size()];
		for (Map.Entry<String, Times> entry : words.entrySet()) {
			dpb[entry.getValue().index] = entry.getValue().times;
		}
		for (int i = 0; i < size; i++) {
			if (dp[start + len * i] == -1) {
				return false;
			} else if (dpb[dp[start + len * i]] == 0) {
				return false;
			} else {
				dpb[dp[start + len * i]]--;
			}
		}

		return true;
	}

	private static void createDP(int[] dp, String S, String[] L, int len,
			HashMap<String, Times> words) {
		for (int i = 0; i < dp.length; i++) {
			String s = S.substring(i, i + len);
			if (words.containsKey(s)) {
				dp[i] = words.get(s).index;
			} else {
				dp[i] = -1;
			}
		}
	}

	public class Times {
		int index;
		int times;

		public Times(int i) {
			index = i;
			times = 1;
		}
	}

	public static void main(String[] args) {
		 String S = "barfoothefoobarman";
		 String[] L = {"foo", "bar"};

//		String S = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
//		String[] L = { "fooo", "barr", "wing", "ding", "wing" };

		System.out.println(new DPWithHashMap().findSubstring(S, L));
	}

}
