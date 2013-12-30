package testHashMap;

import java.util.HashMap;
// 如果map 里面没有这个元素返回的是null 不是原来想的-1
public class GetNoSuchElement {
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("123", 1);
		System.out.println(map.get("234"));
	}
}
