package longestCommonPrefix;
//VI
//这题目不难，但是要注意的点比较多，一个是没有的时候应该返回的是 “” 而不是null
//还有比较的时候要知道因为没有排序，第一个可能会比其他的要长，如果这个时候取对应的位置的时候，就会出现报错的情况
//要考虑到的是如果一旦遇到超过长度或者是这个地方的值不同就返回现在已经累计的prefix
//如果这个数值是最小的，就有可能提前出来了，这时候要记得把已经存的prefix 也输出来。
public class CompareCharacterByCharacter {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}

		if (strs.length == 1) {
			return strs[0];
		}

		for (int i = 0; i < strs[0].length(); i++) {
			char c = strs[0].charAt(i);

			for (int j = 1; j < strs.length; j++) {
				if (i >= strs[j].length() || c != strs[j].charAt(i)) {
					return strs[0].substring(0, i);
				}
			}
		}

		return strs[0];
	}
}
