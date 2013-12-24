package scrambleString;
// 往往递归都可以用作DP
// 这里建出三维数组，第一维指的是两个string 的长度。第二位是两个string 开始位置。
// 首先可以写出基础的，当长度为1只要比较当前那一个元素是不是相同就可以知道是否是scramble
// 然后从2 开始一直到length， 因为长度是从小到大，这样最好是从两个字符串的后面开始往前，判断将这些长度进行各种形式的拆分，两个substring 是不是scramble
// 因为之前的值都存进数组当中，只要从里面取值就可以了。
// 最后返回的是起始位置为0 长度为length 的两个字符串是不是scramble
// 判断是不是scramble 也是同样的方法，不同起始点，切割相同的长度，看两个是不是相同。 因为之前是从最小的1开始，肯定前面的情况都已经考虑进去了。
// 只要从数组里取就可以直接得到以前计算的结果。
public class QuickerDP {
	public static boolean isScramble(String s1, String s2) {
		int len = s1.length();
		if (len != s2.length()) {
			return false;
		}
		if (len == 0) {
			return true;
		}

		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();

		boolean[][][] result = new boolean[len + 1][len][len];

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				result[1][i][j] = (c1[i] == c2[j]);
			}
		}

		for (int k = 2; k <= len; k++) {
			for (int i = len - k; i >= 0; i--) {
				for (int j = len - k; j >= 0; j--) {
					for (int m = 1; m < k; m++) {
						if (result[m][i][j] && result[k - m][i + m][j + m]
								|| result[m][i][j + k - m]
								&& result[k - m][i + m][j]) {
							result[k][i][j] = true;
							break;
						}
					}
				}
			}
		}
		return result[len][0][0];
	}

	public static void main(String[] args) {
		// String s1 = "abcd";
		// String s2 = "bdac";
		 String s1= "abcdd";
		 String s2= "dbdac";
		System.out.println(isScramble(s1, s2) == false);
		s1 = "ab";
		s2 = "ba";
		System.out.println(isScramble(s1, s2) == true);
		s1 = "ymjmfxshglxwrrgufcvvzjuietjzzz";
		s2 = "fxczujvmwizrzgxgjmvzelyjthusrf";
		System.out.println(isScramble(s1, s2));
	}
}
