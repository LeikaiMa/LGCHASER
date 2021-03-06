package anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
// 开始不知道string 能够自己进行sort 用的方法是将所有字母出现的个数统计出来，放进一个array 当中，然后比较array 
// 这里学会了如何比较array 可以直接用arrays.equals 来进行。
// 虽然想到了用hashmap 进行分类但是，但是只是按照长度来进行分类。这样不能从根本上进行解决问题。
// 这个其实是超时的，没有了解本质，解决就有问题。
public class NDimensionArray {
	public static ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> results = new ArrayList<String>();
		if (strs == null || strs.length == 0 || strs.length == 1) {
			return results;
		}

		HashMap<Integer, ArrayList<Integer>> groups = new HashMap<Integer, ArrayList<Integer>>();

		for (int i = 0; i < strs.length; i++) {
			int len = strs[0].length();
			if (groups.containsKey(len)) {
				groups.get(len).add(i);
			} else {
				ArrayList<Integer> group = new ArrayList<Integer>();
				group.add(i);
				groups.put(len, group);
			}
		}

		for (Map.Entry<Integer, ArrayList<Integer>> entry : groups.entrySet()) {
			if (entry.getValue().size() <= 1) {
				continue;
			} else {
				getAnagrams(entry.getValue(), results, strs);
			}
		}

		return results;
	}

	private static void getAnagrams(ArrayList<Integer> candidates,
			ArrayList<String> results, String[] strs) {

		int[][] sum = new int[candidates.size()][26];
		boolean[] anagrams = new boolean[candidates.size()];
		for (int i = 0; i < candidates.size(); i++) {
			int index = candidates.get(i);
			for (int j = 0; j < strs[index].length(); j++) {
				sum[i][strs[index].charAt(j) - 'a']++;
			}
			for (int j = i - 1; j >= 0; j--) {
				if (Arrays.equals(sum[i], sum[j])) {
					anagrams[i] = true;
					anagrams[j] = true;
				}
			}
		}

		for (int i = 0; i < strs.length; i++) {
			if (anagrams[i]) {
				results.add(strs[i]);
			}
		}
	}
	
	public static void main(String[] args) {
		String[] strs={"tea","and","ate","eat","dan"};
		System.out.println(anagrams(strs));
	}

}
