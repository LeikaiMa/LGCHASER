package compressString;
// 因为知道了整个string 的length 就可以将字符串变成字符的数组。
// string 用toChararray 来变成 char[] String 可以用valueOf 反过来变成真正的字符串。
// 如果是primitive 就需要用返回值，而不是primitive 就可以直接传reference 然后直接改变。

public class WithArray {
	String compressAlternate(String str) {
		int size = countCompression(str);
		if (size >= str.length()) {
			return str;
		}

		char[] array = new char[size];
		int index = 0;
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				index = setChar(array, last, index, count);
				last= str.charAt(i);
				count = 1;
			}
		}
		
		index = setChar(array, last, index, count);
		return String.valueOf(array);
	}
	
	public int setChar(char[] array, char c, int index, int count) {
		array[index] = c;
		index++;
		char[] cnt= String.valueOf(count).toCharArray();
		
		for (char x: cnt) {
			array[index] = x;
			index++;
		}
		return index;
	}

	public static int countCompression(String str) {
		if (str == null || str.isEmpty()) {
			return 0;
		}
		char last = str.charAt(0);
		int size = 0;
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				last = str.charAt(i);
				size += 1 + String.valueOf(count).length();
				count = 1;
			}
		}
		size += 1 + String.valueOf(count).length();
		return size;
	}
}
