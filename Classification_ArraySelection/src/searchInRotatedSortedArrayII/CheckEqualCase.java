package searchInRotatedSortedArrayII;
//VI
//这里面有重复的情况要记住记住在原来的基础上考虑low 和 mid 相等的情况
//原来的情况是在正常的bst 的情况要先比较low是不是mid 小，如果小，说明这边一侧是正常的，看target 是不是在这两个值之间，如果是就在这个范围里进行查找。
//如果不是，就在另一个地方进行查找。
//如果low 要比mid 要大，索命右边是正常的，那么看target 是不是在右边的范围里面，如果是就查右边。如果不是就查左边的。
//如果low 和mid 是相等，就无法判断，这时候就让low++ 进行进一步搜索。

//这边要注意相等的情况，这个时候因为没有办法判断，所以应该low ++ 这种情况就是和没有dup 的区别的地方。
public class CheckEqualCase {
	public boolean search(int[] A, int target) {
		if (A == null || A.length == 0) {
			return false;
		}

		int low = 0;
		int high = A.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (A[mid] == target) {
				return true;
			}

			if (A[low] < A[mid]) {
				if (target >= A[low] && target < A[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else if (A[low] > A[mid]) {
				if (target > A[mid] && target <= A[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else {
				low++;
			}
		}

		return false;
	}
}
