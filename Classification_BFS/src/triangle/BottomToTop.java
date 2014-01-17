package triangle;
//VI
//这个比前一种方法好，因为这个是从后往前，用一个array 来进行存储，开始的时候将最顶上的那个复制到array里面。
//然后比他短的要加的是自己序号和序号+1 的，从前往后的话可以在修改之前取到值，因为用的始终是后面 那一个。
//依次到第一层，这个时候就只有一个解，一般都是从大的往小的走比较好。
//这里自己犯的一个错误是将triangle size -1 来赋值最开始的array
import java.util.ArrayList;
//这个里面要注意的是triangle 不要拼写错误，然后最好用一个array 存里面值，这样就要从长的往短的里面走。
public class BottomToTop {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		int[] result = new int[triangle.size()];

		for (int i = 0; i < triangle.size(); i++) {
			result[i] = triangle.get(triangle.size() - 1).get(i);
		}

		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				result[j] = Math.min(result[j], result[j + 1])
						+ triangle.get(i).get(j);
			}
		}

		return result[0];
	}
}
