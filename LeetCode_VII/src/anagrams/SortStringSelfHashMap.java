package anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
// 通过思考，了解到string是可以自己sort 的，先将string 拆成char array 然后用 char array 进行sort 得到了一个sort 好的array
// 然后将这些array 放进一个hashmap
// 这里用到了anagram 的本质，所有的单词的总数都相同，而且每个单词的字母组成也相同。这样排完序之后就是相同的string
// 放到hashmap 那么相同的anagram 就是相同的key， 后面存的时候放到arraylist 里面用他的index 而不是 具体的string 可以省空间。
// 然后将hashmap size里面超过1的value 都取出来，这里用到了values() 这个collection比较实用，还有对应的有keySet() entrySet() 这些在以后的写的时候都可以写
// 尤其是没有提示的时候，要知道会用这个。
// 最重要的是了解这个的本质，然后通过这个本质来找相应的工具。 这样能够更好的完成任务。
public class SortStringSelfHashMap {
	public static ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> results = new ArrayList<String>();
		if (strs == null || strs.length == 0 || strs.length == 1) {
			return results;
		}

		HashMap<String, ArrayList<Integer>> groups = new HashMap<String, ArrayList<Integer>>();

		for (int i = 0; i < strs.length; i++) {
			char[] word = strs[i].toCharArray();
			Arrays.sort(word);
			String newWord = new String(word);
			if (groups.containsKey(newWord)) {
				groups.get(newWord).add(i);
			} else {
				ArrayList<Integer> group = new ArrayList<Integer>();
				group.add(i);
				groups.put(newWord, group);
			}
		}

		for (ArrayList<Integer> group : groups.values()) {
			if (group.size() <= 1) {
				continue;
			}
			
			for (int i : group) {
				results.add(strs[i]);
			}
		}
		
		return results;
	}
	
	public static void main(String[] args) {
		String[] strs={"tea","and","ate","eat","dan"};
		System.out.println(anagrams(strs));
	}
}
