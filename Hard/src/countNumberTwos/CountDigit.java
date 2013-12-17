package countNumberTwos;
// 观察结构不需要遍历所有的来统计。可以根据自身这个数来进行推断。
// 每位来进行统计，如果是比现在这个数要小，就需要round down 统计这个减掉取余之后剩下的数，
// 如果是比他要大的，说明这个里面也全部包括了，需要round up
// 如果是正好要统计的，说明这个正好在一半，需要看右边的具体的数字，不能仅仅很粗略的round up 和round down
// 只有/10之后才能看出到底这个有多少个，所以要/10
// 这样进行统计，主要可以学到如何进行round up 和round down 
// 根据自己所在的index 的位置，可以用power 来进行10的指数乘， 然后可以得到下一个next 的指数乘，依旧是多一位，用原来的数据减去next 就能得到round down
// 用round down 得到的数据再加上一个next 就可以得到round up
// 原先power 是用来得到right 的数据。
public class CountDigit {
	public static int count2sInRange(int number) {
		int count = 0;
		int len = String.valueOf(number).length();
		for (int digit = 0; digit < len; digit++) {
			count += count2sInRangeAtDigit(number, digit);
		}
		return count;
	}

	public static int count2sInRangeAtDigit(int number, int d) {
		int poweOf10 = (int) Math.pow(10, d);
		int nextPowerOf10 = poweOf10 * 10;
		int right = number % poweOf10;

		int roundDown = number - number % nextPowerOf10;
		int roundUp = roundDown + nextPowerOf10;

		int digit = (number / poweOf10) % 10;
		if (digit < 2) {
			return roundDown / 10;
		} else if (digit == 2) {
			return roundDown / 10 + right + 1;
		} else {
			return roundUp / 10;
		}
	}
}
