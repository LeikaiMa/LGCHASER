package medianOfTwoSortedArray;
// 求中位数，如果是排好序的两组数，而且复杂度要保证在log(m + n) 上，就需要采用找第k 个数的方法，这个是变种的二分法。
// 先将两个数组送到helper 函数里面，因为不像C或者C++可以直接在数组上直接加移动数组，得到里面的值，而是应该将start 和 end 直接传进去，两个相减就是现在的长度。
// 这个时候就需要end 不是实际的end的值，而是length 那一位，所以要小心outof Index
// 然后求中位数所在的index的位置。要考虑到整除的问题，而且index是从1 开始的就是如果是奇数就+1 /2 或者是 /2 +1 
// 如果是偶数，一个是直接/2 另一个是/ 2 +1
// 进入helper 里面求k 个的时候，省的下面区分AB的大小的情况，可以先进行比较lenA 和lenB 的大小如果前面要比后面的大，就直接交换进行处理。
// 一旦满足前面的大小排序，就可以进行下面的比较。如果小的长度已经为0，就可以直接返回B[k-1] 
// 如果k 是1 的话就可以直接返回 A B的第一个值的小值
// 接下来就是真正比较，先将k/2 和A 取小值，防止k/2 都比A 要大，这样肯定取的A的最大的值或者K/2 的值。 然后B 要去的值是用k 来进行减掉A拿出的个数，
// 如果这两个值比较，注意这个时候比较的时候开始是0 开始所以要进行-1 
// 如果A 要B 小这样A 前面的所有的值都不可能，这样传到下面的时候讲A的start 的 + a 比较过的个数，注意不能是k/2 然后k 也可以减去已经比较过的个数 同样是A 的个数，相当于过滤掉这么多个数。
// 如果是B的，则是B的start 增大，k 的个数减少
// 如果是相等的就可以直接返回了。但是要注意仍然是-1的，主要看是从0 开始的，还是从1 开始 的。
public class KthElement {
	public static double findMedianSortedArrays(int A[], int B[]) {
		int lenA = A.length;
		int lenB = B.length;
		int total = lenA + lenB;
		if (total % 2 == 1) {
			return findMedianSortedArraysHelper(A, 0, lenA, B, 0, lenB,
					(total + 1) / 2);
		} else {
			return (findMedianSortedArraysHelper(A, 0, lenA, B, 0, lenB,
					total / 2) + findMedianSortedArraysHelper(A, 0, lenA, B, 0,
					lenB, total / 2 + 1)) / 2.0;
		}
	}

	public static double findMedianSortedArraysHelper(int A[], int as, int ae,
			int B[], int bs, int be, int k) {
		int lenA = ae - as;
		int lenB = be - bs;
		if (lenA > lenB) {
			return findMedianSortedArraysHelper(B, bs, be, A, as, ae, k);
		}

		if (lenA == 0) {
			return B[bs + k - 1];
		}

		if (k == 1) {
			return Math.min(A[as], B[bs]);
		}

		int ak = Math.min(k / 2, lenA);
		int bk = k - ak;

		if (A[as + ak - 1] < B[bs + bk - 1]) {
			return findMedianSortedArraysHelper(A, as + ak, ae, B, bs, be, k
					- ak);
		} else if (A[as + ak - 1] > B[bs + bk - 1]) {
			return findMedianSortedArraysHelper(A, as, ae, B, bs + bk, be, k
					- bk);
		} else {
			return A[as + ak - 1];
		}
	}
	
	
	public static void main(String[] args) {
		int[] A = {2} ;
		int[] B = {};
		System.out.println(findMedianSortedArrays(A, B));
	}
}
