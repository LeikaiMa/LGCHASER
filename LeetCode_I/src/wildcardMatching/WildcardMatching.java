package wildcardMatching;

public class WildcardMatching {
	public static boolean isMatch(String s, String p) {
		int is = 0;
		int ip = 0;
		if (s.isEmpty() && p.isEmpty()) {
			return true;
		} else if (p.isEmpty()) {
			return false;
		} else if (s.isEmpty()) {
			while (ip < p.length()) {
				if (p.charAt(ip) != '*') {
					return false;
				}
				ip++;
			}
			return true;
		}
		if (s.length() != p.length() && !p.contains("*")) {
			return false;
		}
		char cp = p.charAt(ip);
		char cs = s.charAt(is);

		while (is < s.length() && ip < p.length()) {

			cp = p.charAt(ip);
			cs = s.charAt(is);
			if (cp == '?') {
				is++;
				ip++;
				continue;
			} else if (cp == '*') {
				if (ip + 1 >= p.length()) {
					return true;
				} else if (p.charAt(ip + 1) == '*') {
					ip++;
					continue;
				} else if (p.charAt(ip + 1) == '?') {
					int count = 0;
					ip++;
					while (ip < p.length()
							&& (p.charAt(ip) == '?' || p.charAt(ip) == '*')) {
						if (p.charAt(ip) == '?') {
							count++;
						}
						ip++;
					}
					if (ip == p.length()) {
						if (s.length() - is < count) {
							return false;
						} else
							return true;
					} else {
						int tmp = s.indexOf(p.charAt(ip), is);

						while (tmp - is < count) {
							if (tmp == -1) {
								break;
							}
							tmp = s.indexOf(p.charAt(ip), tmp + 1);
						}
						if (tmp == -1) {
							return false;
						} else {
							is = tmp;
							continue;
						}

					}

				} else {
					// is = s.indexOf(p.charAt(ip + 1), is);
					// if (is == -1) {
					// return false;
					// } else {
					// ip++;
					// }
					int newIs = s.indexOf(p.charAt(ip + 1), is);
					while (newIs != -1) {
						String subS = s.substring(newIs);
						String subP = p.substring(ip+1);
						if (isMatch(subS, subP)) {
							return true;
						} else {
							newIs = s.indexOf(p.charAt(ip + 1), newIs + 1);
						}
					}
					return false;
				}

			} else {
				if (cp != cs) {
					return false;
				}
				is++;
				ip++;
			}

		}

		if (is < s.length()) {

			if (cp != '*') {
				return false;
			} else {
				return true;
			}

		}

		while (ip < p.length()) {
			if (p.charAt(ip) != '*') {
				return false;
			}
			ip++;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isMatch("aa", "*a")==true);
		System.out.println(isMatch("c", "*?*")==true);
		System.out.println(isMatch("hi", "*?")==true);
		System.out.println(isMatch("", "")== true);
		System.out.println(isMatch("a", "a*")==true);
		System.out.println(isMatch("aa", "a")==false);
		System.out.println(isMatch("aa", "aa")==true);
		System.out.println(isMatch("aaa", "aa")==false);
		System.out.println(isMatch("aa", "*")==true);
		System.out.println(isMatch("aa", "a*")==true);

		System.out.println(isMatch("ab", "?*")==true);
		System.out.println(isMatch("aab", "c*a*b")==false);
	}
}
