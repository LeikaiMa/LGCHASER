package substringWithConcatenationOfAllWords;
//V
//这个思路是没有用DP，是直接将所有单词进行统计放进一个hashmap key 是单词本身，value 是统计的个数
//然后从第一个开始，每次跳过单词的长度，数这么多的个单词是不是把之前统计的hashmap 全部用完，如果提前用完，就说明错误，如果最后的时候map 是空的就说明正好。
//每次都是substring 这个有重复计算。如果不想重复计算，用DP 参考自己写的。
//这里有用的比较好的，是自己用过的检查有没有key 如果没有新建放进去，如果有取出来+1再放进去，因为相同的key 会进行覆盖。
//然后hashmap 可以直接新建的时候里面放一个map 然后生成的时候就是对应的map
import java.util.ArrayList;
import java.util.HashMap;
//这里遇到的问题是要想到是将所有的值存到一个hashmap 里面，虽然可以用array 来进行，但是这样查找的速度会比较快。
public class HashMapToStoreAllCandidates {
	public ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (S == null || S.length() == 0 || L == null || L.length == 0) {
			return result;
		}

		int n = L.length;
		int m = L[0].length();
		int len = S.length();

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (String l : L) {
			if (map.containsKey(l)) {
				map.put(l, map.get(l) + 1);
			} else {
				map.put(l, 1);
			}
		}

		int i = 0;

		while (i <= len - n * m) {
			HashMap<String, Integer> tmp = new HashMap<String, Integer>(map);
			helper(tmp, S, i, result, n, m);
			i++;
		}

		return result;
	}

	private void helper(HashMap<String, Integer> map, String s, int start,
			ArrayList<Integer> result, int n, int m) {
		for (int i = 0; i < n; i++) {
			String word = s.substring(start + i * m, start + (i + 1) * m);
			if (!map.containsKey(word)) {
				return;
			} else {
				if (map.get(word) == 1) {
					map.remove(word);
				} else {
					map.put(word, map.get(word) - 1);
				}
			}
		}

		result.add(start);
	}
}
