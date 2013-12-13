package isPermutation;

import java.util.Arrays;
// 检查是否为permutation 本质上看是否有相同个数的不同的元素。
// 如果从本身出发，将自己重新sort 如果最后形成两个同样的string， 就说明他原来的就是permutation。
// 本身sort 一个很长用的方法就是，将自己转换为char array 用的是 toCharArray，之后sort 就可以用Arrays.sort 最后直接new 这个String 就可以形成
public class SortString {
	public boolean permutation(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		return sort(s).equals(sort(t));
	}
	
	public String sort(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
}
