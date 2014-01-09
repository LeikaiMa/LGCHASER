package stringToInteger;
// II
// 这里用的新的策略就是开始的时候过滤掉空格，然后开始判断是正数还是负数，
// 接下来进去的时候进行累加，用正数进行累加，一旦遇到不是数字的情况就从循环里面跳出，这里面不用直接返回值是因为要判断是正是负，可以归结到外面进行一起判断，自己开始错的时候就是在这里错的
// 然后主要的就是要比较是否是overflow 比较的方法，是拿现在的值如果是正数就是Integer 的最大值/10 来进行比较，如果已经大了，就直接返回最大值。
// 如果相等就看现在这个值是不是和7相等或者比7大，因为最大值的最后一位是7
// 如果是负数，那么就要变成负数看是不是比最小的/10还要小。如果还要小就直接返回最小值，如果是相等就要进行比较是不是比8 要大，或者相等，因为最小值的是以8结尾的。
// 如果是正常的就直接*10加上现在这个一位上的数字。
// 最后的时候看原来的符号是正还是负，返回这个值或者是相反数。
public class IndexOneByOne {
	public static int atoi(String str) {
		int index = 0;
		int result = 0;
		if (str.isEmpty()) {
			return result;
		}
		while (str.charAt(index) == ' ') {
			index++;
		}

		boolean positive = true;
		if (str.charAt(index) == '+') {
			index++;
		} else if (str.charAt(index) == '-') {
			positive = false;
			index++;
		}

		for (int i = index; i < str.length(); i++) {
			char c = str.charAt(i);
			if (!Character.isDigit(c)) {
				break;
			}

			if (positive && result > Integer.MAX_VALUE / 10) {
				return Integer.MAX_VALUE;
			}

			if (positive && result == Integer.MAX_VALUE / 10 && c >= '7') {
				return Integer.MAX_VALUE;
			}

			if (!positive && -result < Integer.MIN_VALUE / 10) {
				return Integer.MIN_VALUE;
			}

			if (!positive && -result == Integer.MIN_VALUE / 10 && c >= '8') {
				return Integer.MIN_VALUE;
			}

			result = result * 10 + (c - '0');
		}

		if (positive) {
			return result;
		} else {
			return -result;
		}
	}
	
	public static void main(String[] args) {
		String str="  -0012a42";
		System.out.println(atoi(str));
	}
}
