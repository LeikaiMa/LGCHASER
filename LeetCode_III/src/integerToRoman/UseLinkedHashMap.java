package integerToRoman;

import java.util.LinkedHashMap;
import java.util.Map;
// linked hashmap 可以作为遍历使用，这样就有顺序。
// 里面加上put 放进去，然后进行遍历。
public class UseLinkedHashMap {
	public String intToRoman(int num) {
		LinkedHashMap<Integer, String> iToR = new LinkedHashMap<Integer, String>();
		iToR.put(1000, "M");
		iToR.put(900, "CM");
		iToR.put(500, "D");
		iToR.put(400, "CD");
		iToR.put(100, "C");
		iToR.put(90, "XC");
		iToR.put(50, "L");
		iToR.put(40, "XL");
		iToR.put(10, "X");
		iToR.put(9, "IX");
		iToR.put(5, "V");
		iToR.put(4, "IV");
		iToR.put(1, "I");
		StringBuffer result = new StringBuffer();
		for (Map.Entry<Integer, String> entry : iToR.entrySet()) {
			int rep = num /entry.getKey();
			for (int i = 0; i < rep; i++) {
				result.append(entry.getValue());
			}
			num = num % entry.getKey();
		}
		
		return result.toString();
	}
	
	public static void main(String[] args) {
//		int input = 2022;
//		System.out.println(intToRoman(input));
	}
}
