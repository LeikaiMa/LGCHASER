package reverseInteger;
// reverse integer 总体流程是原来数据取出最后一位，然后新的integer在最后一位上插入，开始可以将一些特殊情况直接处理。
// 比如最大值和最小值还有一位数的都可以直接返回
// 在过程中判断的时候看是否overflow 可以放一个比他慢的参数，如果参数比快的还要大说明overflow了
// 这样的话开始就应该先判断是否是正负数，否则就应该另外考虑。
// 出循环后看是否正常出循环，如果不是就直接返回最大或者最小值。如果是正常返回，就应该返回output 里面的值加上符号。
public class ReverseInteger {
	public static int reverse(int x) {
		if (x == Integer.MIN_VALUE || x == Integer.MAX_VALUE
				|| (x > -10 && x < 10)) {
			return x;
		}
		boolean positive = true;
		boolean overflow = false;
		if (x < 0) {
			positive = false;
		}

		x = Math.abs(x);

		int output = x % 10;
		x = x / 10;
		int slow = output;
		while (x > 0) {
			slow = output;
			if (slow > output) {
				overflow = true;
				break;
			}
			output = output * 10 + x % 10;
			x = x / 10;
		}

		if (overflow) {
			if (positive) {
				return Integer.MAX_VALUE;
			} else {
				return Integer.MIN_VALUE;
			}
		} else {
			if (positive) {
				return output;
			} else {
				return -1 * output;
			}
		}

	}

	public static void main(String[] args) {
		System.out.println(reverse(-123));
	}
}
