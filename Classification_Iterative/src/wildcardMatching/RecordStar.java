package wildcardMatching;

//wildcard 比较困难的是* 如何使用，因为他包括0 到无穷个字符，因为有这么多种情况需要考虑，就需要一种是递归一种是iteration
//因为是从前往后，所以递归的话就不是很好，用iteration的话可以用一个来标记位置，一旦不成功就返回到原来的地方，然后让另外一个+1。
//但是在java 中需要有很多情况调用函数不能是null或者是out of index， 这时候就得先把这些情况考虑进去，然后判断，不论是用一整个if 来进行判断
//还是在用&& 之前进行短路来进行判断，都需要进行。
//而且写函数的时候最开始就应该去判断是否为null 如果是null 下面很多函数都不能进行调用。
//这边一点点小的trick 是多个*在一起等于一个*所以可以直接向后移到最后一个*的位置。
//同时还要考虑一个先出来另个没有出来的情况。
//两个string 进行比较本质上也就是两个指针的移动比较。 
//DP 应该可以进行解决，但是这题没有细究。

// 要注意的开始star 要重置，这个时候if 结束之后要记得continue。 不然后会执行后面的if 语句就会超出报错。
public class RecordStar {
	public static boolean isMatch(String s, String p) {
		if (p.replace("*", "").length() > s.length()) {
			return false;
		}

		int ps = 0;
		int pp = 0;
		int pss = -1;
		int pps = -1;

		while (ps < s.length()) {
			if (pp >= p.length()) {
				if (pps > -1) {
					pp = pps;
					ps = pss + 1;
					pss = pss + 1;
					continue;
				} else {
					return false;
				}
			}

			if (p.charAt(pp) == '?' || p.charAt(pp) == s.charAt(ps)) {
				pp++;
				ps++;
			} else if (p.charAt(pp) == '*') {
				while (pp < p.length() - 1 && p.charAt(pp + 1) == '*') {
					pp++;
				}
				pss = ps;
				pps = pp;
				pp++;
			} else if (pps > -1) {
				pp = pps;
				ps = pss + 1;
				pss = pss + 1;
			} else {
				return false;
			}
		}

		while (pp < p.length()) {
			if (p.charAt(pp++) != '*') {
				return false;
			}
		}

		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isMatch("aa", "*") == true);
	}
}
