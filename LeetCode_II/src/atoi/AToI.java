package atoi;
// string 变成integer 有很多要注意的事项
// 首先是前面的空格要trim 掉
// 然后check 第一个是不是加减符号还是数字还是其他字符。
// 如果是加减符号应该就在positive 上面标记出来。
// 如果是字符，然后说明是正数，然后可以存到result 里面，然后看是不是只有一位，如果是就要直接返回值不然下面有很多要访问后面的index 的数就有可能报错。
// 如果是其他字符就直接返回是0
// 然后是一点一点往后检查后面的字符。两个边界条件，一个是到尾了，一个是不是正常的0~9 的字符。如果不是就跳出了，然后返回的就是目前为止计算出来的integer值
// 在循环里面要不断的check 如果加上后面一位会不会overflow 
// 检查overflow 的标准是 * 10 + number 然后/10 看是不是返回原来的值，如果不是的话就要直接返回overflow 的值，如果是正数，就返回最大值
// 如果是负数就返回integer 最小的值
// 由于是要提前看到后一个数，就需要在while 的check 条件+1< length
// 最后要再check是否是因为到头来出的循环。
// 这时候一种方法就是直接check 其他的部分是否满足，这个题里面就是是否是0~9 之间。
// 然后最后根据自己的符号返回正负值。
public class AToI {
	public static int atoi(String str) {
		if (str == null) {
			return 0;
		}
		str = str.trim();
		if (str.isEmpty()) {
			return 0;
		}
		boolean positive = false;
		boolean overflow = false;
		int pos = 0;
		int result = 0;
		int factor = 10;
		if (str.charAt(pos) == '+') {
			positive = true;
		} else if (str.charAt(pos) == '-') {
			positive = false;
		} else if (str.charAt(pos) >= '0' && str.charAt(pos) <= '9') {
			positive = true;
			result = str.charAt(pos) - '0';
			if (pos+1 == str.length()) {
				return result;
			}
		} else {
			return 0;
		}
		pos++;
		
		while (pos + 1 < str.length() && str.charAt(pos) >= '0'
				&& str.charAt(pos) <= '9') {
			result = result * factor + (str.charAt(pos) - '0');
			if (overflow) {
				if (positive) {
					return Integer.MAX_VALUE;
				} else {
					return Integer.MIN_VALUE;
				}
			}
			if ((result * 10 + (str.charAt(pos + 1) - '0')) / 10 != result) {
				overflow = true;
			}
			pos++;
		}

		if (str.charAt(pos) >= '0' && str.charAt(pos) <= '9') {
			result = result * factor + (str.charAt(pos) - '0');
			if (overflow) {
				if (positive) {
					return Integer.MAX_VALUE;
				} else {
					return Integer.MIN_VALUE;
				}
			}
		}
		if (positive) {
			return result;
		} else {
			return -result;
		}
	}

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		String s0 = "1";
		System.out.println(atoi(s0) == 1);
		String s1 = "    -00134";
		System.out.println(atoi(s1) == -134);
		String s2 = "    10522545459";
		System.out.println(atoi(s2) == Integer.MAX_VALUE);
		String s3 = "    -10522545459";
		System.out.println(atoi(s3) == Integer.MIN_VALUE);
		String s4 = "2147483648";
		System.out.println(atoi(s4) == Integer.MAX_VALUE);
	}
}
