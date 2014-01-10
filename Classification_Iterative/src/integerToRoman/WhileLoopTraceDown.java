package integerToRoman;
// III
//由于linkedhashmap 速度比较慢，而且这一题不需要多次使用，可以从最大的开始进行递减 用/ 和 % 结合。
//只有10 的整数倍才有可能有很多个，其余的都只有一个，如果比他要大，就直接append 然后减掉就可以了。
//主要的难点是要记录各种number 对应的 罗马unit 的方法。

// 主要是从大的开始往小的算，要注意的是如果是10的倍数，就要算repeat 然后用的% 如果不是就只有可能是一个，用的是- 其实%应该也可以。
public class WhileLoopTraceDown {
    public String intToRoman(int num) {
        StringBuffer result = new StringBuffer();
		if (num >= 1000) {
			result.append(repeat(num, 1000, "M"));
			num %= 1000;
		}
		if (num >= 900) {
			result.append("CM");
			num -= 900;
		}
		if (num >= 500) {
			result.append("D");
			num -= 500;
		}
		if (num >= 400) {
			result.append("CD");
			num -= 400;
		}

		if (num >= 100) {
			result.append(repeat(num, 100, "C"));
			num %= 100;
		}
		
		if (num >= 90) {
			result.append("XC");
			num -= 90;
		}
		
		if (num >= 50) {
			result.append("L");
			num -= 50;
		}
		
		if (num >= 40) {
			result.append("XL");
			num -= 40;
		}
		
		if (num >= 10) {
			result.append(repeat(num, 10, "X"));
			num %= 10;
		}
		
		if (num >= 9) {
			result.append("IX");
			num -= 9;
		}
		if (num >= 5) {
			result.append("V");
			num -= 5;
		}
		if (num >= 4) {
			result.append("IV");
			num -= 4;
		}
		if (num >= 1) {
			result.append(repeat(num, 1, "I"));
			num %= 1;
		}
		
		return result.toString();

    }
    
    public static String repeat(int num, int fac, String unit) {
		StringBuffer s = new StringBuffer();
		for (int i = 0; i < num / fac; i++) {
			s.append(unit);
		}
		return s.toString();
    }
}
