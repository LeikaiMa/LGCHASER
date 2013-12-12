package mergeArrays;
// 将两个sorted的arrays 合并，可以不从头开始考虑，因为要移位，而是可以从后面开始。
// 只需要比较最后的两个的大小， 如果最后的比较大的就放在A的后面。
// 如果A提前消耗完，就需要将B继续存起来，因为A本身就在里面。
public class MergeTwoSortedArrays {
	public static void merge(int[] a, int[] b, int lastA, int lastB) {
		int indexA = lastA - 1;
		int indexB = lastB - 1;
		int indexMerged = lastA + lastB - 1;

		while (indexA >= 0 && indexB >= 0) {
			if (a[indexA] > b[indexB]) {
				a[indexMerged] = a[indexA];
				indexA--;
				indexMerged--;
			} else {
				a[indexMerged] = b[indexB];
				indexMerged--;
				indexB--;
			}
		}
		
		while (indexB >= 0) {
			a[indexMerged] = b[indexB];
			indexMerged--;
			indexB--;
		}
	}
}
