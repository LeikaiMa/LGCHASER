package makeChange;
// 看能够有多少种拆分方法，可以从大到小，因为每次是根据现在剩下的钱和要采用钱来进行计算，格式相同，所以可以进行相同方法进行递归。
// 每次进来可以确定下一个尝试的大小，可以用switch 来判断下一个转换，类似于一个状态机。
// 然后用一个for 循环来产生不同挑选的方法，然后给后面进行递归。
// 最后把所有的方法汇总，就是总的方法
// 因为最后是1 所以可以作为收尾，而且能够保证肯定能够成功。 如果不是1 就要判断能否成功匹配。不能直接return。
public class MakeChange {
	public static int makeChange(int n, int denom) {
		int next_denom = 0;
		switch (denom) {
		case 25:
			next_denom = 10;
			break;
		case 10:
			next_denom = 5;
			break;
		case 5:
			next_denom = 1;
			break;
		case 1:
			return 1;
		}
		int ways = 0;
		for (int i = 0; i * denom <= n; i++) {
			ways += makeChange(n - i * denom, next_denom);
		}
		return ways;
	}

	public static void main(String[] args) {
		System.out.println(makeChange(100, 25));
	}
}
