package numToString;
// 将数字转换为单词，可以分析出，以1000 位一个部分，里面的百位的解释方法都是相同的，可以用while 循环不断的/1000 然后里面的 数字是100的计数 + 一个所处的位置。
// 所有的对应可以用一个array 来表示，array 的本质是带有坐标的字符，这样可以利用这个pair
// 开始的时候也可以直接去分析0 还有负数，如果是负数可以转为正数来进行求解。
// 求1000 以内的数同样也是可以用 逐步分析的方法，先剥离出100 的然后再 10 最后是1 的。
// 最开始可以在最外面存储一个static 的数组
public class NumToString {
	public static String[] digits = { "One", "Two", "Three", "Four", "Five",
			"Six", "Seven", "Eight", "Nine" };
	public static String[] teens = { "Eleven", "Twelve", "Thirteen",
			"Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
			"Nineteen" };
	public static String[] tens = { "Ten", "Twenty", "Thirty", "Forty",
			"Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
	public static String[] bigs = { "", "Thousand", "Million" };

	public static String numToString(int number) {
		if (number == 0) {
			return "Zero";
		} else if (number < 0) {
			return "Negative" + numToString(-1 * number);
		}

		int count = 0;
		String str = "";

		while (number > 0) {
			if (number % 1000 != 0) {
				str = numToString100(number % 1000) + bigs[count] + " " + str;
			}
			number /= 1000;
			count++;
		}

		return str;
	}

	public static String numToString100(int number) {
		String str = "";

		if (number >= 100) {
			str += digits[number / 100 - 1] + " Hundred ";
			number %= 100;
		}

		if (number >= 11 && number <= 19) {
			return str + teens[number - 11] + " ";
		} else if (number == 10 || number >= 20) {
			str += tens[number / 10 - 1] + " ";
			number %= 10;
		}

		if (number >= 1 && number <= 9) {
			str += digits[number - 1] + " ";
		}

		return str;
	}
}
