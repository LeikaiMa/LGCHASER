package anagrams;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
// 要将anagram 放在一起，分析题目得知，这个不需要排序，只是将有共同属性的集合在一起。
// 这样的内在属性可以得出hashtable 最为合适，而且复杂度也最低。
// key 可以变成 anagram 的group 转换为统一形式。
// value 则可以是一个list 里面存储所有的一个类的东西。
// 可以对原来的array 进行遍历，不过要判断开始建的hashtable 里面有没有这个key。如果没有这个key 就需要新建
// 如果有可以取出来然后向里面value push 进新的东西
// 最后可以通过遍历，再把hashtable 里面的值全部重新存回array里面。
// 在得到统一的anagram 时候，要注意的一点是可以利用string 的toCharArray， 然后把 sort 的功能交给Arrays.sort
// 将char 的数组转回string可以直接新建一个string 不需要自己多操作。

public class GroupByHashtable {
	public void sort(String[] array) {
		Hashtable<String, LinkedList<String>> hash = new Hashtable<>();

		for (String s : array) {
			String key = sortChars(s);
			if (!hash.containsKey(key)) {
				hash.put(key, new LinkedList<String>());
			}

			LinkedList<String> anagrams = hash.get(key);
			anagrams.push(s);
		}

		int index = 0;
		for (String key : hash.keySet()) {
			LinkedList<String> list = hash.get(key);
			for (String t : list) {
				array[index] = t;
				index++;
			}
		}

	}

	private String sortChars(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}

}
