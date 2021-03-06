package testTreeMap;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class TestTreeMap {
	//这个说明在for 循环里面不能删除entry。
	public static void main(String[] args) {
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		treeMap.put(1, 1);
		treeMap.put(2, 2);
		ArrayList<Integer> arrayList = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry: treeMap.entrySet()) {
			arrayList.add(entry.getKey());
		}
		for (int i: arrayList) {
			treeMap.remove(i);
		}
		
		System.out.println(treeMap.size());
	}
}
