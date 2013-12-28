package removeElement;
// 这个就是用两个pointer 来进行遍历，如果相同直接跳过，如果不同就将这个值进行复制进到慢的指针所在的地方，为了简便加上一个统计个数的来保证万一一个都没有
// 如果有一个复制了，计数器加一。
public class TwoPointer {
	public int removeElement(int[] A, int elem) {
		if (A == null || A.length == 0) {
			return 0;
		}

		int faster = 0;
		int slow = 0;
		int length = 0;
		while (faster < A.length) {
			if (A[faster] == elem) {
				faster++;
			} else {
				A[slow] = A[faster];
				length++;
				slow++;
				faster++;
			}
		}
		return length;
	}
}
