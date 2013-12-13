package isPermutation;
// 也可以将所有的letter 放进到相应的数组里面，并且计数。
// 最开始的时候可以判断两个string 是否是一样长，不是一样长可以直接返回false
// 然后check 的时候一个一个减，如果减到0 一下，说明不是一个permutation。
public class CountCharacters {
	public boolean permutation(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] letters = new int[256];
		
		char[] s_array = s.toCharArray();
		for (char c : s_array) {
			letters[c]++;
		}
		
		for (int i = 0; i < t.length(); i++) {
			int c = (int) t.charAt(i);
			if (--letters[c] < 0) {
				return false;
			}
		}
		return true;
	}
}
