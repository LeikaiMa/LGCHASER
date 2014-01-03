package mergeTwoSortedArray;
// 这个是比较简单的题，要注意的是从后向前，如果相等优先去填充那个要插进来的值，这样可以减少原来array 的元素的移动。
// 出来的条件是只要一个插完就出来，看剩下的如果是要插入的，就继续插完，否则就说明已经插完了。
public class ArrayBackwards {
	public void merge(int A[], int m, int B[], int n) {
		if (B == null || B.length == 0) {
			return;
		}

		int i = m - 1, j = n - 1, k = m + n - 1;

		while (i >= 0 && j >= 0) {
			if (A[i] > B[j]) {
				A[k--] = A[i--];
			} else {
				A[k--] = B[j--];
			}
		}

		if (i < 0) {
			while (k >= 0) {
				A[k--] = B[j--];
			}
		}
	}
}
