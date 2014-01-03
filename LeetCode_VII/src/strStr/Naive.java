package strStr;
// 这题可能是考察C++的指针问题，对于JAVA只需要对应的一个一个遍历即可。
public class Naive {
	public String strStr(String haystack, String needle) {
		int lenH = haystack.length();
		int lenN = needle.length();
		if (lenH == 0 && lenN == 0) {
			return haystack;
		}
		if (lenH < lenN) {
			return null;
		}

		if (lenH != 0 && lenN == 0) {
			return haystack;
		}
		// for (int i = 0; i <= lenH - lenN; i++) {
		// if (haystack.substring(i, i+lenN).equals(needle)) {
		// return haystack.substring(i);
		// }
		// }
		// return null;
		// int i = haystack.indexOf(needle);
		// if (i == -1) {
		// return null;
		// } else {
		// return haystack.substring(i);
		// }

		for (int i = 0; i <= lenH - lenN; i++) {
			int j = 0;
			for (; j <= lenN; j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					break;
				}
			}
			if (j == lenN) {
				return haystack.substring(i);
			}
		}
		return null;

	}
}
