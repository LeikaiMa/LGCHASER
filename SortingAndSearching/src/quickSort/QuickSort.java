package quickSort;

// quicksort 就是将值分配到pivot 的两边，开始不管分到两边的顺序到底是不是sort。
// 因为pivot 如果不和两边的编相同或者在那个范围之外，就要继续做相同的sort，这个导致的结果就是一直quick sort 到最内部。
// 间接保证了整个array 都是sorted
// 在partition 也就是左右分类的时候，一共有三个坐标一个是左一个是pivot 还有一个是右。 左边小就不移动，如果右边大也不移动，如果都不满足了，就把左右交换了，就可以实现小的在左边打的在右边。
// 一般情况是O(nlog(n)) worst 是O（n^2) 占用的memory 是O（log(n))
public class QuickSort {
	public void quickSort(int arr[], int left, int right) {
		int index = partition(arr, left, right);
		if (left < index - 1) {
			quickSort(arr, left, index - 1);
		}
		if (index < right) {
			quickSort(arr, index, right);
		}
	}

	public int partition(int arr[], int left, int right) {
		int pivot = arr[(left + right) / 2];
		while (left <= right) {
			while (arr[left] < pivot) {
				left++;
			}
			while (arr[right] > pivot) {
				right--;
			}

			if (left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	private void swap(int[] arr, int left, int right) {
		// TODO Auto-generated method stub

	}
}
