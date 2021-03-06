package rotatedArray;
// 对于rotated 的sorted array，本能想到是二分法。
// 但是因为顺序不同，所以要对原来的binary search 要进行修改。
// 基本的原则是判断已经成为顺序的一半
// 如果左边比中间要小，说明左边确实为start 和mid 能够进行比较，如果成功，就可以在那个里面进行查找。如果没有，就要在右边进行查找。
// 同理可以看出是要对具体的值进行比较。
// search 要传入的参量是本身这个array，左起点和右起点，还有要比较的值。
// 如果相同就要先比较另外一端的值，如果不同，就只要比较那边的，如果相同说明两边都要比较。错误就要用-1来进行表示。
// 这里可以注意如果有值返回了，就不要其他的进行比较。
public class customBinarySearch {
	public int search(int[] a, int left, int right, int x) {
		int mid = (left + right) / 2;
		if (x == a[mid]) {
			return mid;
		}
		if (right < left) {
			return -1;
		}
		
		if (a[left] < a[mid]) {
			if (x >= a[left] && x <= a[mid]) {
				return search(a, left, mid -1, x);
			} else {
				return search(a, mid+1, right, x);
			}
		} else if (a[mid] < a[left]) {
			if (x >= a[mid] && x <= a[right]) {
				return search(a, mid + 1, right, x);
			} else {
				return search(a, left, mid - 1, x);
			}
		} else if (a[left] == a[mid]) {
			if (a[mid] != right) {
				return search(a, mid+1, right, x);
			} else {
				int result = search(a, left, mid - 1, x);
				if (result == -1) {
					return search(a, mid + 1, right, x);
				} else {
					return result;
				}
			}
		}
		return -1;
	}
}
