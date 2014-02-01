package findKthSmallest;
//quick seleciton 和 quick sort 类似，都是去找一个pivot 然后将小的返回到左边，大的放在右边，
//然后看整个pivot 的位置是不是正好是想要的k 的位置，如果是就返回，如果不是，k 要小检查左边，如果k 要大，检查右边。
//这里刚进来的时候因为是数组，有index，所以k 正好也就可以是k - 1
//然后进去partition 也是要传进去first 和 last 然后返回的是pivot 的位置。
//进去之后pivot 是random 出来的，先将pivot 放到最后去
//从前面开始往后进行遍历，如果他要比last 大，也就是比pivot 的值要小，那么将他和first 进行交换，然后first 向后移动一个位置
//最后将pivot 和first 进行交换，pivot 返回的就是现在的index
//一直到k 为止，如果不行的 话就返回minimum value
//http://www.geekviewpoint.com/java/search/quickselect
import java.util.Random;

public class QuickSelection {
	public int quickSelect(int[] G, int k) {
		return quickSelect(G, 0, G.length - 1, k - 1);
	}

	private int quickSelect(int[] G, int first, int last, int k) {
		if (first <= last) {
			int pivot = partition(G, first, last);
			if (pivot == k) {
				return G[k];
			}

			if (pivot > k) {
				return quickSelect(G, first, pivot - 1, k);
			}
			return quickSelect(G, pivot + 1, last, k);
		}

		return Integer.MIN_VALUE;
	}

	private int partition(int[] G, int first, int last) {
		int pivot = first + new Random().nextInt(last - first + 1);
		swap(G, last, pivot);

		for (int i = first; i < last; i++) {
			if (G[i] > G[last]) {
				swap(G, i, first);
				first++;
			}
		}
		swap(G, first, last);
		return first;
	}

	private void swap(int[] G, int x, int y) {
		int tmp = G[x];
		G[x] = G[y];
		G[y] = tmp;
	}

	// public int findKthSmallest(int[] a, int k) {
	// int value = 0;
	// int n = a.length;
	// int c = 5;
	//
	// while (true) {
	// int pivot = FindPivot(a, n, c);
	//
	// int[] count = new int[2];
	//
	// countElements(a, n, pivot, count);
	// }
	// }
	//
	// private void countElements(int[] a, int n, int pivot, int[] count) {
	//
	// }
	//
	// private int FindPivot(int[] a, int n, int c) {
	// while (n > 1) {
	// int pos = 0;
	// int tmp = 0;
	//
	// for (int start = 0; start < n; start += c) {
	// int end = start + c;
	// if (end > n) {
	// end = n;
	// }
	//
	// for (int i = start; i < end - 1; i++) {
	// for (int j = i + 1; j < end; j++) {
	// if (a[j] < a[i]) {
	// tmp = a[i];
	// a[i] = a[j];
	// a[j] = tmp;
	// }
	// }
	// }
	//
	// end = (start + end) / 2;
	// tmp = a[end];
	// a[pos++] = tmp;
	// }
	//
	// n = pos;
	// }
	// return a[0];
	// }
	// http://www.sysexpand.com/?path=exercises/kth-smallest
}