package removeDuplicatesFromSortedArrayI;
//V
//这个是基本的两指针前进判断的方式，在这题里面多用了一个size 的变量来记录了新有的size 的大小。就不需要最后重新数
//主要关键是slow 的移动，要移动到下一个里面将fast 的值复制进去。
//开始的如果是1，要将其分开因为他返回的是1，而不是0

//这个没有一直复制，而是等到不同的时候再将里面的值复制过来。
public class SlowCopyFast {
	public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}

		if (A.length == 1) {
			return 1;
		}

		int slow = 0;
		int fast = 1;

		while (true) {
			while (fast < A.length && A[fast] == A[slow]) {
				fast++;
			}

			if (fast < A.length) {
				A[++slow] = A[fast];
			} else {
				return slow + 1;
			}
		}
	}
}
