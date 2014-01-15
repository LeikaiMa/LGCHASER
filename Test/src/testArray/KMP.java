package testArray;
//KMP 的方法主要就是因为如果这个不行，最好不要从前面一个一个进行比较而是应该跳到前面最合适的位置。
//这样就要有一个dp 的数组来记录下一次要跳的位置，所以会有一个next 的array 来进行记录
//next 表示如果这一位和要比较的string 的某一位不同应该要跳哪一位。
//这里就应该要计算整个跳转的位置。一个是j 表示现在要填的位置，一个是k 表示前面要跳转的位置。
//开始next 0 的时候表示如果没有匹配应该去哪里，用-1表示，这样能够标记出这个是头，
//所以k 也是从-1开始
//如果两个地方是相同的，就应该跳到现在k 标志位置 + 1 因为现在比较的是前一位，所以记录的结果应该是后一位的， 所以是j 是从0 开始，然后最后记录的是next[++j] = ++k
//应为开始是有个默认的情况所以是k 是 -1  的时候也是无条件开始，还有一种情况是两个是相同的情况。
//如果不同的情况应该k 就要返回前面的情况，而k 最有效的是next[k] 的，所以返回k 更新为next[k] 跳转到前面。

//这里有一个优化的情况是有可能是++j 和 ++k的位置p 上面相同，那么应该next[j] 所在的位置应该是next[k] 的位置。
//如果不是还是按照原来的，因为之前已经自加过了，所以是next[j] = k 的情况。
import java.util.Arrays;
//http://www.cnblogs.com/yjiyjige/p/3263858.html
public class KMP {
	public static int[] getNext(String ps) {

		char[] p = ps.toCharArray();

		int[] next = new int[p.length];

		next[0] = -1;

		int j = 0;

		int k = -1;

		while (j < p.length - 1) {

			if (k == -1 || p[j] == p[k]) {

				// next[++j] = ++k;
				if (p[++j] == p[++k]) { // 当两个字符相等时要跳过

					next[j] = next[k];

				} else {

					next[j] = k;

				}

			} else {

				k = next[k];

			}

		}

		return next;

	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(getNext("ABCABB")));
	}
}
