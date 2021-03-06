package wildcardMatching;

// wildcard 比较困难的是* 如何使用，因为他包括0 到无穷个字符，因为有这么多种情况需要考虑，就需要一种是递归一种是iteration
// 因为是从前往后，所以递归的话就不是很好，用iteration的话可以用一个来标记位置，一旦不成功就返回到原来的地方，然后让另外一个+1。
// 但是在java 中需要有很多情况调用函数不能是null或者是out of index， 这时候就得先把这些情况考虑进去，然后判断，不论是用一整个if 来进行判断
// 还是在用&& 之前进行短路来进行判断，都需要进行。
// 而且写函数的时候最开始就应该去判断是否为null 如果是null 下面很多函数都不能进行调用。
// 这边一点点小的trick 是多个*在一起等于一个*所以可以直接向后移到最后一个*的位置。
// 同时还要考虑一个先出来另个没有出来的情况。
// 两个string 进行比较本质上也就是两个指针的移动比较。 
// DP 应该可以进行解决，但是这题没有细究。

public class ReconsiderStar {
	public static boolean isMatch(String s, String p) {
		int indexS = 0;
		int indexP = 0;
		int starS = -1;
		int starP = -1;
		if (s == null || p == null) {
			return false;
		}
		if (p.isEmpty() && s.isEmpty()) {
			return true;
		} else if (p.isEmpty() && !s.isEmpty()) {
			return false;
		}

		if (p.replace("*", "").length() > s.length()) {
			return false;
		}
		while (indexS < s.length()) {
			if (indexP == p.length()) {
				if (starP > -1) {
					indexP = starP;
					indexS = ++starS;
					continue;
				} else {
					return false;
				}
			}
			char cs = s.charAt(indexS);
			char cp = p.charAt(indexP);
			if (cs == cp || cp == '?') {
				indexP++;
				indexS++;
			} else if (cp == '*') {
				while (indexP < p.length() && p.charAt(indexP) == '*') {
					indexP++;
				}

				starP = indexP;
				starS = indexS;
			} else if (cs != cp && cp != '?' && starP > -1) {
				indexP = starP;
				indexS = ++starS;
			} else {
				return false;
			}

		}

		while (indexP < p.length()) {
			if (p.charAt(indexP) != '*') {
				return false;
			}
			indexP++;

		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isMatch("aa", "*a") == true);
		System.out.println(isMatch("c", "*?*") == true);
		System.out.println(isMatch("hi", "*?") == true);
		System.out.println(isMatch("", "") == true);
		System.out.println(isMatch("a", "a*") == true);
		System.out.println(isMatch("aa", "a") == false);
		System.out.println(isMatch("aa", "aa") == true);
		System.out.println(isMatch("aaa", "aa") == false);
		System.out.println(isMatch("aa", "*") == true);
		System.out.println(isMatch("aa", "a*") == true);

		System.out.println(isMatch("ab", "?*") == true);
		System.out.println(isMatch("aab", "c*a*b") == false);
	}
}
