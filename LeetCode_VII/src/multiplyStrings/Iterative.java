package multiplyStrings;
// 这道题是将两个string 相乘， 想到的办法还是用平时最基本的计算公式来进行计算。
// 首先看有没有特殊情况来进行处理。如果有一个是空或者是没有，就直接返回 “”
// 然后有可能这些string 的开头是0 开头的，要将这些0 trim 掉，用的是正则表达式来进行替换，这个是表示开头是0 匹配不止1个但是最后不全部trim 掉。
// 然后看如果有一个是0 就返回0 如果有一个是1 返回另一个。
// 然后为了减少递归的次数，就比较两个的长度，让小的做乘数，这样乘以的次数要少一些。
// 然后进行一个数字和一行进行相乘，从最后一个往前乘，同样要用到carry 的中间变量。 然后用到sum 和carry 来进行储存，最后出来的时候看carry 是不是大于0 如果是大于0 还要将这个carry 塞进去
// 所有的因为都是前插的操作，所以用的是insert 0 的操作。
// 然后得到每一位相乘的，越往后，要在后面进行补0，这样就是每一行要加起来的各行
// 后面就是相加，同样是用carry 的方法，为了避免考虑长短的问题，就在短的前面补0 这样两个就是同样长度的。比较省事，不然还要将长的之前补进来。
// 要注意的是补0 的时候不能用一个string buffer 的变量来进行判断长度，因为每次for 循环判断的时候要重新计算。所以先在前面用一个变量储存要插0的个数，这样不容易出错。
// 这题主要是要细心，将这些情况都考虑进去。
public class Iterative {
	public static String multiply(String num1, String num2) {
		if (num1 == null || num1.isEmpty() || num2 == null || num2.isEmpty()) {
			return "";
		}

		num1 = num1.trim().replaceFirst("^0+(?!$)", "");
		num2 = num2.trim().replaceFirst("^0+(?!$)", "");
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		if (num1.equals("1")) {
			return num2;
		}
		if (num2.equals("1")) {
			return num1;
		}

		if (num1.length() <= num2.length()) {
			return multiplyHelper(num2, num1);
		} else {
			return multiplyHelper(num1, num2);
		}

	}

	private static String multiplyHelper(String multiplicand, String multiplier) {
		StringBuffer[] steps = new StringBuffer[multiplier.length()];
		for (int i = 0; i < multiplier.length(); i++) {
			StringBuffer tmp = multiplyOneDigit(multiplicand,
					multiplier.charAt(multiplier.length() - 1 - i));
			for (int j = 0; j < i; j++) {
				tmp.append(0);
			}
			steps[i] = tmp;
		}

		StringBuffer result = steps[0];
		for (int i = 1; i < steps.length; i++) {
			int diff = result.length() - steps[i].length();
			if (diff > 0) {
				for (int j = 0; j < diff; j++) {
					steps[i].insert(0, 0);
				}
			} else if (diff < 0){
				for (int j = 0; j < -diff; j++) {
					result.insert(0, 0);
				}
			}
			result = add(result, steps[i]);
		}

		return result.toString();

	}

	private static StringBuffer add(StringBuffer augend, StringBuffer addend) {
		int carry = 0;
		StringBuffer sum = new StringBuffer();
		for (int i = augend.length() - 1; i >= 0; i--) {
			int a = augend.charAt(i) - '0';
			int b = addend.charAt(i) - '0';
			int s = a + b + carry;
			carry = s / 10;
			sum.insert(0, s % 10);
		}

		if (carry > 0) {
			sum.insert(0, carry);
		}
		return sum;
	}

	private static StringBuffer multiplyOneDigit(String multiplicand,
			char multiplier) {
		StringBuffer result = new StringBuffer();
		int b = multiplier - '0';
		int carry = 0;
		for (int i = multiplicand.length() - 1; i >= 0; i--) {
			int a = multiplicand.charAt(i) - '0';
			int product = a * b + carry;
			carry = product / 10;
			result.insert(0, product % 10);
		}

		if (carry > 0) {
			result.insert(0, carry);
		}
		return result;
	}

	public static void main(String[] args) {
		String num1 = "140";
		String num2 = "721";
		System.out.println(multiply(num1, num2));
	}

}
