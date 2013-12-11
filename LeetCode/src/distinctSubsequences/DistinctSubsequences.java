package distinctSubsequences;

import java.util.ArrayList;

public class DistinctSubsequences {
	public static int numDistinct(String S, String T) {
		S = S.toLowerCase();
		T = T.toLowerCase();
		if (S.length() < T.length()) {
			return 0;
		}

		if (T.length() == 0 && S.length() != 0) {
			return 1;
		}

		if (T.length() == 0 && S.length() == 0) {
			return 1;
		}

		ArrayList<Character> s = new ArrayList<Character>();
		ArrayList<Integer> ns = new ArrayList<Integer>();
		ArrayList<Character> t = new ArrayList<Character>();
		ArrayList<Integer> nt = new ArrayList<Integer>();
		shrink(s, ns, S);
		shrink(t, nt, T);


		ArrayList<Integer> count = new ArrayList<Integer>();
		int result = 0;
		int pt = 0;
		for (int ps = 0; ps < s.size(); ps++) {
			if ((s.get(ps) == t.get(pt)) && (ns.get(ps) >= nt.get(pt))) {
				count.add(ns.get(ps));
				pt++;
				if (pt == t.size()) {
					result += total(nt, count);
					pt = 0;
					count.clear();
				}
			} else {
				pt = 0;
				count.clear();
			}
		}

		return result;
	}



	private static int total(ArrayList<Integer> nt, ArrayList<Integer> count) {
		int result = 1;
		for (int i = 0; i < nt.size(); i++) {
			int ct = nt.get(i);
			int cs = count.get(i);
			if (cs > ct) {
				result *= combination(cs, ct);
			}
		}
		return result;
	}

	private static void shrink(ArrayList<Character> s, ArrayList<Integer> ns,
			String S) {
		int position = 0;
		int count = 1;
		s.add(S.charAt(position));
		for (int i = 1; i < S.length(); i++) {
			if (s.get(position) == S.charAt(i)) {
				count++;
			} else {
				ns.add(count);
				s.add(S.charAt(i));
				count = 1;
				position++;
			}
		}
		ns.add(count);
	}

	private static int combination(int m, int n) {

		return factorial(m) / (factorial(n) * factorial(m - n));
	}

	private static int factorial(int n) {
		if (n == 0 || n == 1)
			return 1;
		else
			return n * factorial(n - 1);
	}

	public static void main(String[] args) {
//		String S = "ABCDE";
//		String T = "AEC";
		// String S = "rabbbit";
		// String T = "rabbit";
		 String S = "aacaacca";
		 String T = "ca";
		System.out.println(numDistinct(S, T));
	}

}
