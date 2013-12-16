package pickMIntegers;
// 随机选取m 个数据的子集， 中间很容易想到就用random
// 首先直接复制前m 个到里面，然后从m 个开始，然后进行随机选取，然后将选取的index如果是在m 里面的 值进行替换
// 因为是要保证概率不变，所以要在0 i 进行random， 只有在m 里面才能进行。
public class Iterative {
	int rand(int lower, int higher) {
		return lower + (int) (Math.random() * (higher - lower + 1));
	}
	
	int[] pickMInteratively(int[] original, int m ) {
		int[] subset= new int[m];
		
		for (int i = 0; i < m; i++) {
			subset[i] = original[i];
		}
		
		for (int i = m; i < original.length; i++) {
			int k = rand(0, i);
			if (k < m) {
				subset[k] = original[i];
			}
		}
		
		return subset;
	}
}
