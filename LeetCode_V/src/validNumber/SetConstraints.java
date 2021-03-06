package validNumber;
// 这个写的比较糟糕，考虑的情况不全面，靠的试出来
// 这里要注意的情况是首先两边的空格可以删掉。 
// 最开始的时候可以有+-， 其他+- 的情况必须是前面有e 然后后面是数字
// 开始也可以是. 然后后面必须出现数字。 只能够出现一次
// e 只能出现一次，必须前面有数字后面也有数字。只能出现一次
// 空格只能前后两边有，如果中间有，就是错的。
// 其他的情况都不行。

public class SetConstraints {
	public static boolean isNumber(String s) {
		if (s == null) {
			return false;
		}

		s = s.trim().toLowerCase();
		if (s.length() == 0) {
			return false;
		}

		char first = s.charAt(0);

		if (first == '-' || first == '+') {
			return helper(s.substring(1));
		} else {
			return helper(s);
		}

	}

	private static boolean helper(String s) {
		if (s.length() == 0) {
			return false;
		}
		boolean hasE = false;
		boolean hasDot = false;
		char first = s.charAt(0);

		if (!Character.isDigit(first)) {
			if (first == '.' && s.length() >= 2
					&& Character.isDigit(s.charAt(1))) {
				hasDot = true;
			} else {
				return false;
			}
		}

		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				continue;
			} else if (c == 'e') {
				if (!hasE
						&& i < s.length() - 1
						&& (Character.isDigit(s.charAt(i + 1))
								|| s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-')) {
					hasE = true;
					hasDot = true;
				} else {
					return false;
				}
			} else if (c == '+' || c == '-') {
				if (s.charAt(i - 1) == 'e' && i < s.length() - 1
						&& Character.isDigit(s.charAt(i + 1))) {
					i++;
				} else {
					return false;
				}

			}

			else if (c == '.' && !hasDot) {
				hasDot = true;
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isNumber("0") == true);
		System.out.println(isNumber("-0") == true);
		System.out.println(isNumber(" 0.1 ") == true);
		System.out.println(isNumber("abc") == false);
		System.out.println(isNumber("1 a") == false);
		System.out.println(isNumber("2e10") == true);
		System.out.println(isNumber(".1") == true);
		System.out.println(isNumber("3.") == true);
		System.out.println(isNumber(".") == false);
		System.out.println(isNumber("+.8") == true);
		System.out.println(isNumber("+-.") == false);
		System.out.println(isNumber("6e6.5") == false);
		System.out.println(isNumber(" 005047e+6") == true);
		System.out.println(isNumber("6+1") == false);
		System.out.println(isNumber("4e+") == false);
	}
}
