package permutationSequence;

// 这道题借助了divide 那道题的思路，想到了他的所有的情况的总数是n! 也就是 n *(n-1) !而后面也就是 n-1个数的排列的总数。
// 因为是按照从小到大的顺序来进行排，所以可以从头往后进行排，前面排好了，从里面将这个remove 掉，整个还是排好序的，由这个想到了用arraylist 里面的先将所有的元素都按照顺序add 进来，然后每次从中间删掉一个，然后再在这里取元素往后面进行排
// 现在的问题是这个里面该取哪个元素，比如213 这个肯定是1**已经排过了，所以他肯定能得到1 *(n-1)!的数，在这个index 的后面。这个就类似于整除。
// 要注意的是因为这个k是从1开始的，整除会有问题，所以要先减去1 再除以 （n-1） !
// 因为又要每次求（n-1）！这个比较耗时间，所以用dp 的方法先将这些都存进去。然后每次都去取。
// 本来整除之后是在这个基础上少1的，倒是arraylist 又是从0开始的，所以这个就不需要+1，直接用得到的数据从里面get 出来就可以了。
// 然后得出来了之后这个就不能取了，就要从这里面进行remove
// 然后加到最重要返回的stringbuffer 里面。
// 再后面就是将前面这么多数减去，这样就不管这一位，去找后面一位。
// 最后有个要注意的是，因为开始的时候0! 可以赋值为1，最后可以找到，这一位，不然最终要提前一位出来，append 剩下的一位，防止除以0
// 方法类似http://yucoding.blogspot.com/2013/04/leetcode-question-68-permutation.html
// 他有一点做的比较好的是不是减，直接用% 值得学习。
import java.util.ArrayList;

public class DP {
	public static String getPermutation(int n, int k) {
		int[] dp = new int[10];
		int total = 1;
		for (int i = 1; i <= 9; i++) {
			total *= i;
			dp[i] = total;
		}
		// 这边赋值为1
		dp[0] = 1;

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			numbers.add(i);
		}

		StringBuffer sb = new StringBuffer();

		for (int i = n; i >= 1; i--) {
			int index = (k - 1) / dp[i - 1];
			sb.append(numbers.get(index));
			numbers.remove(index);
			k = k - dp[i - 1] * (index);
		}
		// sb.append(numbers.get(0));
		return sb.toString();
	}

	public static void main(String[] args) {
		int n = 5;
		int k = 10;
		System.out.println(getPermutation(n, k));
	}
}
