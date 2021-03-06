package substringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
// 这个思路是没有用DP，是直接将所有单词进行统计放进一个hashmap key 是单词本身，value 是统计的个数
// 然后从第一个开始，每次跳过单词的长度，数这么多的个单词是不是把之前统计的hashmap 全部用完，如果提前用完，就说明错误，如果最后的时候map 是空的就说明正好。
// 每次都是substring 这个有重复计算。如果不想重复计算，用DP 参考自己写的。
// 这里有用的比较好的，是自己用过的检查有没有key 如果没有新建放进去，如果有取出来+1再放进去，因为相同的key 会进行覆盖。
// 然后hashmap 可以直接新建的时候里面放一个map 然后生成的时候就是对应的map
public class Conciser {
	public ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (S == null || S.length() == 0 || L == null || L.length == 0) {
			return res;
		}

		int n = L.length, m = L[0].length(), l = S.length();
		Map<String, Integer> covered = new HashMap<String, Integer>();

		for (int i = 0; i < n; i++) {
			if (covered.containsKey(L[i])) {
				covered.put(L[i], covered.get(L[i]) + 1);
			} else {
				covered.put(L[i], 1);
			}
		}

		int i = 0;
		while (l - i >= n * m) {
			Map<String, Integer> temp = new HashMap<String, Integer>(covered);
			for (int j = 0; j < n; j++) {
				String tempStr = S.substring(i + j * m, i + (j + 1) * m);
				if (temp.containsKey(tempStr)) {
					if (temp.get(tempStr) - 1 == 0) {
						temp.remove(tempStr);
					} else {
						temp.put(tempStr, temp.get(tempStr) - 1);
					}
				} else {
					break;
				}
			}
			if (temp.size() == 0) {
				res.add(i);
			}
			i++;
		}
		return res;
	}
}
