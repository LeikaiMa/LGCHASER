package removeDuplicateFromSortedArrayI;
// 这个是基本的两指针前进判断的方式，在这题里面多用了一个size 的变量来记录了新有的size 的大小。就不需要最后重新数
// 主要关键是slow 的移动，要移动到下一个里面将fast 的值复制进去。
// 开始的如果是1，要将其分开因为他返回的是1，而不是0
public class TwoPointer {
	public static int removeDuplicates(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		if (A.length == 1) {
			return 1;
		}
		int slow = 0;
		int fast = 1;
		int size = 1;
		while (fast < A.length) {
			if (A[fast] != A[slow]) {
				slow++;
				A[slow] = A[fast];
				size++;
				fast++;
			} else {
				fast++;
			}
		}
		return size;
	}

	public static void main(String[] args) {
		int[] A = { 1, 1, 2 };
		System.out.println(removeDuplicates(A));
	}
}
