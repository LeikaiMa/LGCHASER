package mergeSort;
// mergesort 是将一个array 输入，然后建一个等长的helper的array，用来到后面进行先存储，然后比较，那么原来的array的值就可进行任意的修改。
// 然后是将其对半拆分，进行merge 处理，一直到剩下最后一个，依次递归，
// 递归之后要将其进行合并，通过告知范围，首先将其存在helper 里面，然后给两个指针，对前一半和后一半进行比较， 得到的比较赋值给原有的array，这样达到保存的效果。
// 要注意的是，因为是小到大进行排列，后一半如果满足条件，就不需要进行赋值，但是如果多出来的是前一半，由于位置改变所以需要将其进行赋值。
// Runtime O（n log(n)）average Memory 是depends

public class MergeSort {
	public void mergeSort(int[] array) {
		int[] helper = new int[array.length];
		mergeSort(array, helper, 0, array.length - 1);
	}

	public void mergeSort(int[] array, int[] helper, int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			mergeSort(array, helper, low, middle);
			mergeSort(array, helper, middle + 1, high);
			merge(array, helper, low, middle, high);
		}
	}

	public void merge(int[] array, int[] helper, int low, int middle, int high) {
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}

		int helperLeft = low;
		int helperRight = middle + 1;
		int current = low;

		while (helperLeft <= middle && helperRight <= high) {
			if (helper[helperLeft] <= helper[helperRight]) {
				array[current] = helper[helperLeft];
				helperLeft++;
			} else {
				array[current] = helper[helperRight];
				helperRight++;
			}
			current++;
		}

		int remaining = middle - helperLeft;
		for (int i = 0; i <= remaining; i++) {
			array[current + i] = helper[helperLeft + i];
		}
	}
}
