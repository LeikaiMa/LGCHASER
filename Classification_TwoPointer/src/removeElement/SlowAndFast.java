package removeElement;
//IV
//这个就是用两个pointer 来进行遍历，如果相同直接跳过，如果不同就将这个值进行复制进到慢的指针所在的地方，为了简便加上一个统计个数的来保证万一一个都没有
//如果有一个复制了，计数器加一。
public class SlowAndFast {
	public int removeElement(int[] A, int elem) {
		int len = 0;
		int slow = 0;
		int fast = 0;

		while (fast < A.length) {
			if (A[fast] != elem) {
				A[slow] = A[fast];
				slow++;
				fast++;
				len++;
			} else {
				fast++;
			}
		}

		return len;
	}
}
