package testTreeMap;

import java.util.TreeMap;
// tree map 也是要删除duplicate 
public class Duplicate {
	public static void main(String[] main) {
		TreeMap< Integer, Integer> tm = new TreeMap<>();
		tm.put(1, 1);
		tm.put(1, 2);
		System.out.println(tm.size());
	}
}
