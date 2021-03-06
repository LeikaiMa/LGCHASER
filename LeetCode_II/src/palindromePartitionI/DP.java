package palindromePartitionI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class DP {
	public class SubPalindrome {
		ArrayList<String> subResult;
		int end = 0;

		public SubPalindrome(ArrayList<String> s, int e) {
			subResult = s;
			end = e;
		}

	}

	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (s == null || s.isEmpty()) {
			return result;
		}
		// s = s.trim().replace(" ", "");
		// s = s.replace("[^a-zA-Z0-9]", "").toLowerCase();
		HashMap<Integer, ArrayList<Integer>> palindromes = new HashMap<Integer, ArrayList<Integer>>();

		int length = s.length();
		for (int i = 0; i < length; i++) {
			ArrayList<Integer> a = new ArrayList<Integer>();
			a.add(i);
			palindromes.put(i, a);
		}

		for (int i = 1; i < length - 1; i++) {
			int expand = 1;
			while (i - expand >= 0 && i + expand < length) {
				int e = 1;
				for (; e <= expand; e++) {
					if (s.charAt(i - e) != s.charAt(i + e)) {
						break;
					}
				}
				if (e > expand) {
					ArrayList<Integer> a = palindromes.get(i - expand);
					a.add(i + expand);
					expand++;
				} else {
					break;
				}
			}
		}

		for (int i = 0; i < length - 1; i++) {
			if (s.charAt(i) != s.charAt(i + 1)) {
				continue;
			} else {
				ArrayList<Integer> a = palindromes.get(i);
				a.add(i + 1);
			}
			int expand = 1;
			while (i - expand >= 0 && i + 1 + expand < length) {
				int e = 1;
				for (; e <= expand; e++) {
					if (s.charAt(i - e) != s.charAt(i + 1 + e)) {
						break;
					}
				}
				if (e > expand) {
					ArrayList<Integer> a = palindromes.get(i - expand);
					a.add(i + 1 + expand);
					expand++;
				} else {
					break;
				}
			}
		}

		ArrayList<Integer> candidates = palindromes.get(0);
		Queue<SubPalindrome> queue = new LinkedList<SubPalindrome>();
		for (int i : candidates) {
			int end = i + 1;
			ArrayList<String> subResult = new ArrayList<String>();
			subResult.add(s.substring(0, i + 1));
			SubPalindrome sp = new SubPalindrome(subResult, end);
			queue.add(sp);
		}

		while (!queue.isEmpty()) {
			SubPalindrome sp = queue.poll();
			if (sp.end == length) {
				result.add(sp.subResult);
			} else {
				int end = sp.end;

				ArrayList<Integer> nexts = palindromes.get(end);
				for (int n : nexts) {
					ArrayList<String> subResult = new ArrayList<String>();
					subResult.addAll(sp.subResult);
					subResult.add(s.substring(end, n + 1));
					SubPalindrome nsp = new SubPalindrome(subResult, end + 1);
					queue.add(nsp);
				}
			}
		}
		return result;

	}

	// private static void addSubResult(int end, ArrayList<String> subResult,
	// HashMap<Integer, ArrayList<Integer>> palindromes, int length, String s) {
	// if (end == length) {
	// return;
	// }
	// ArrayList<Integer> nexts = palindromes.get(end);
	// for (int n : nexts) {
	// subResult.add(s.substring(, i + 1));
	// }
	//
	//
	// }

	public static void main(String[] args) {
		String s = "aabaaaadfadfadfadfaereqr";
		ArrayList<ArrayList<String>> results = new DP().partition(s);
		for (ArrayList<String> result : results) {
			System.out.println(result);
		}
	}
}
