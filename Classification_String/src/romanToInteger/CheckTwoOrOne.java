package romanToInteger;
// III
//用hashmap 将里面的对应的存起来，然后从头开始翻译字母。要注意的是优先考虑两个字母合在一起的，如果存在就是代表这个意思。
//如果不存在就是自己本身。 但是这样要将最后一个先不判断，留给一下子判断两个的。
//最后看是否是到最后一个，如果不是说明还有一个落下了，要补上。

// 先检查两个的行不行，可以的话就两个+2，不行的话就1个，因为是两个所以结尾应该是< len-1, 这样就要check 最后一个有没有被遍历到。
import java.util.HashMap;

public class CheckTwoOrOne {
    public int romanToInt(String s) {
        if (s == null || s.isEmpty()) {
			return 0;
		}
		int i = 0;
		int result = 0;
		HashMap<String, Integer> rToI = new HashMap<String, Integer>();

		rToI.put("M", 1000);
		rToI.put("CM", 900);
		rToI.put("D", 500);
		rToI.put("CD", 400);
		rToI.put("C", 100);
		rToI.put("XC", 90);
		rToI.put("L", 50);
		rToI.put("XL", 40);
		rToI.put("X", 10);
		rToI.put("IX", 9);
		rToI.put("V", 5);
		rToI.put("IV", 4);
		rToI.put("I", 1);

		while (i < s.length() - 1) {
			String num = "";
			num = num + s.charAt(i) + s.charAt(i + 1);
			if (rToI.containsKey(num)) {
				result += rToI.get(num);
				i += 2;
			} else {
				num = "" + s.charAt(i);
				result += rToI.get(num);
				i++;
			}
		}
		if (i == s.length() - 1) {
			result += rToI.get(String.valueOf(s.charAt(i)));
		}
		return result;
    }
}
