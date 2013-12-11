package distinctSubsequences;

import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class RefinedDS {
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

		TreeMap<Integer, Integer> countMap = new TreeMap<Integer, Integer>();
		for (int j = 0; j < s.size(); j++) {
			if ((s.get(j) == t.get(0)) && (ns.get(j) >= nt.get(0))) {
				countMap.put(j, ns.get(j));
			}
		}
		TreeMap<Integer, Integer> takeMap = new TreeMap<Integer, Integer>();
		for (int i = 1; i < t.size(); i++) {
			takeMap = new TreeMap<>();
			for (int j = 0; j < s.size(); j++) {
				if ((s.get(j) == t.get(i)) && (ns.get(j) >= nt.get(i))) {
					takeMap.put(j, ns.get(j));
				}
			}
			ArrayList<Integer> arrayList = new ArrayList<Integer>();
			for (Map.Entry<Integer,Integer> entry : takeMap.entrySet()) {
				SortedMap<Integer, Integer> subCountMap = new TreeMap<Integer, Integer>();
				
				subCountMap = countMap.subMap(0, entry.getKey());
				if (subCountMap.size() != 0) {
					int total = 0;
					for (Map.Entry<Integer, Integer> e : subCountMap.entrySet()) {
						total += e.getValue();
					}
					takeMap.put(entry.getKey(), total * entry.getValue());
				} else {
					arrayList.add(entry.getKey());
				}
			}
			for (int key : arrayList) {
				takeMap.remove(key);
			}
			countMap = takeMap;
			
		}
		int result = 0;
		for (Map.Entry<Integer, Integer> entry : takeMap.entrySet()) {
			result += entry.getValue();
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

	public static void main(String[] args) {
		 String S = "ABCDE";
		 String T = "AEC";
//		 String S = "rabbbit";
//		 String T = "rabbit";
//		String S = "aacaacca";
//		String T = "ca";
		System.out.println(numDistinct(S, T));
	}
}
