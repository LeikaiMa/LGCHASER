package searchInRotatedArray;
// 这个是找没有排序的头，也就是pivot 同样的是由 二分法来进行，不过while 循环的内容不一样了。
// 只要找到第一个左边比有点小或者相等的就可以了
// 也是找mid 如果mid 还是比right 要大，那么pivot 就还在mid 后面， left 就变成mid + 1
// 如果mid 比右边小或者等于，那么就说明在左边，但是right 还是要变成mid 不能再小，防止这个就是pivot
public class FindPivot {
	int FindSortedArrayRotation(int A[], int N) {
		int L = 0;
		int R = N - 1;
		while (A[L] > A[R]) {
			int M = L + (R - L) /2;
			if (A[M] > A[R]) {
				L = M + 1;
			} else {
				R = M;
			}
		}
		return L;
	}
}
