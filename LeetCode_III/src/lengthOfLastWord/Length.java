package lengthOfLastWord;
// 要先过滤掉最后的可能的空格，如果全部是空格直接返回0
// 再从后向前数不是空格的数，如果遇到空格就提前出来。
// 最后返回数的个数。
public class Length {
	public static int lengthOfLastWord(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}
		int i = s.length() - 1;
		for (; i >= 0; i--) {
			if (s.charAt(i) != ' ') {
				break;
			}
		}

		if (i == -1) {
			return 0;
		}

		int num = 0;

		for (; i >= 0; i--) {
			if (s.charAt(i) != ' ') {
				num++;
			} else {
				break;
			}
		}

		return num;
	}
	
	public static void main(String[] args) {
		String s = "  ";
		System.out.println(lengthOfLastWord(s));
	}
}
