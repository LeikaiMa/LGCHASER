package decodeWays;
// 这一题类似于小女孩走楼梯的问题，可以是走一步也可以是走两步。
// 但是比那个有限制在于，走一步的时候0 是不能走的，走两步的时候只有10-26才能走。
// 这时候可以考虑利用DP 来解决问题。
// 但实现要解决掉一些特殊情况，比如字符串是空的，返回0 字符串只有一个0 返回0 如果字符串是除了0 之外的其他单个字符返回1.
// 在DP 后面设置base case 走到台阶的最后一格的后面可以是两步也可以是1步，但是因为如果1步和两步都放进循环，会超出范围。（当然可以将DP 的空间再增加1）
// 然后看最后一个台阶，如果是0 就是表示不能走说明是0 ，其他的情况说明都可以走，而且方法是1
// 接下来就是从倒数第二格开始进行倒推，如果是0 说明这格不能走，直接跳过，因为创建数组的时候已经默认是 0
// 如果不是0 说明至少可以走1步到下面一个格子，可以把下面一个格子到最后的走的方法复制到前面来。
// 如果这个格子和后面一个格子合起来是在10-26之间，说明可以跳两格，这样可以把后面跳两格的方法复制到前面来，再加上默认可以跳一格的方法。
// 最终返回的是第一格的统计的方法数
public class DecodeWays {
	public static int numDecodings(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}
		if (s.equals("0")) {
			return 0;
		}
		if (s.length() == 1) {
			return 1;
		}

		int[] num = new int[s.length() + 1];
		num[s.length()] = 1;
		if (s.charAt(s.length() - 1) != '0') {
			num[s.length() - 1] = 1;
		}

		for (int i = s.length() - 2; i >= 0; i--) {
			if (s.charAt(i) == '0') {
				continue;
			}
			int tmp = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
			if (tmp >= 10 && tmp <= 26) {
				num[i] = num[i + 2] + num[i + 1];
			} else {
				num[i] = num[i + 1];
			}
		}
		return num[0];
	}

	public static void main(String[] args) {
		
		System.out.println(numDecodings("10") == 1);
		System.out.println(numDecodings("0") == 0);
	}
}
