package smallestOneMillion;
// 在无序数据里面找前n 个最小的数。有三种方法，一种是sort之后取前n个，一种是insert 到一个min heap 里面，可以取头然后插到另一个list 里面。
// 还有一个就是用下面一个算法，类似于quick sort
// 先随机选出一个pivot 然后根据这个pivot 把数据分到两边，左边是小的，右边是大的。
// 然后看左边的个数和rank 比如何，如果正好等于rank +1 就说明正好，返回的值就是里面的值或者是如果要求正好是第n位的值就去最大。
// 如果左边值太多，就在左边一堆数据当中去n个，递归下去。
// 如果左边值不够，就用右边的值来进行，但是rank的要用rank -leftSize 
// 这个好处在于，时间复杂度会降到linear 因为sort O(nlogn) min heap 是O(nlogm)。
public class SelectionRankAlgorithm {
	public int rank(int[] array, int left, int right, int rank) {
		int pivot = array[randomIntInRange(left, right)];

		int leftEnd = partition(array, left, right, pivot);
		int leftSize = leftEnd - left + 1;
		if (leftSize == rank + 1) {
			return max(array, left, leftEnd);
		} else if (rank < leftSize) {
			return rank(array, left, leftEnd, rank);
		} else {
			return rank(array, leftEnd + 1, right, rank - leftSize);
		}
	}

	private int max(int[] array, int left, int leftEnd) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int partition(int[] array, int left, int right, int pivot) {
		while (true) {
			while (left <= right && array[left] <= pivot) {
				left++;
			}
			while (left <= right && array[right] > pivot) {
				right--;
			}
			if (left > right) {
				return left - 1;
			}
			swap(array, left, right);
		}
	}

	private void swap(int[] array, int left, int right) {
		// TODO Auto-generated method stub

	}

	private int randomIntInRange(int left, int right) {
		// TODO Auto-generated method stub
		return 0;
	}
}
