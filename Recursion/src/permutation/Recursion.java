package permutation;

import java.util.ArrayList;
// string 的permutation 的基本思路是每个是上一个所有的string 的permutation 中任意位置插入加入的元素。
// 和求subset 的区别是，subset 除了加上去新的，原有的还要包括进去，所以最好那种类型的题目要新建一个arraylist 为morearraylist。
// 无论什么题目，最好开头的时候判断是否为null， 这样能够减少没有必要的runtime 的error
// 而且要返回什么值，最好开头就将这个值创建好。
// 这道题的base case 在于如果里面没有元素就是为“”
// 然后下面的难点就在于如何将新加入的字母插入到字符串中。
// 这里解决的方法是取第一个字符，然后将剩下的字符串递归得到arraylist
// 插入的时候要利用好string 的一系列的函数，比如charAt 是取固定的index的字符，
// substring 是为了取固定范围的string， 如果只是1个参数是从这个参数到最后面。如果是两个，前闭后开。
// 然后两个连在一起是直接相加。

public class Recursion {
	public static ArrayList<String> getPerms(String str) {
		if (str == null) {
			return null;
		}
		ArrayList<String> permutations = new ArrayList<String>();
		if (str.length() == 0) {
			permutations.add("");
			return permutations;
		}
		
		char first  = str.charAt(0);
		String remainder = str.substring(1);
		ArrayList<String> words = getPerms(remainder);
		for (String word: words) {
			for (int j = 0; j <= word.length(); j++) {
				String s = insertCharAt(word, first, j);
				permutations.add(s);
			}
		}
		return permutations;
	}

	private static String insertCharAt(String word, char c, int i) {
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}
	
	
}
