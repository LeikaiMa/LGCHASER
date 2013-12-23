package longestCombinedWord;

import java.util.HashMap;
// 首先按照从长到短的顺序进行比较，因为长的可能性最高。
// 将所有的单词放在一个hashmap 当中，以供以后查找方便，比较好的方法是将value设置为true 这样可以和没有的false 形成对比。
// 然后将这个单词从第一个字母开始遍历，拆成两个，如果左右两个都存在的话就表示成功。直接返回。
public class CombinedTwoWords {
	public String getLongestWord(String[] list) {
		String[] array = SortByLength(list);

		HashMap<String, Boolean> map = new HashMap<>();
		for (String str : array) {
			map.put(str, true);
		}

		for (String s : array) {
			for (int i = 1; i < s.length(); i++) {
				String left = s.substring(0,i);
				String right = s.substring(i);
				if (map.get(left) == true && map.get(right) == true) {
					return s;
				}
			}
		}
		return null;
	}

	private String[] SortByLength(String[] list) {
		// TODO Auto-generated method stub
		return null;
	}

}
