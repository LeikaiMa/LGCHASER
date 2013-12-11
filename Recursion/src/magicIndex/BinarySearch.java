package magicIndex;
// 运用二分法，可以加快速度。
// 因为二分法需要递归，所以每次传入的参数的个数要一样，这样可以做一个接口，虽然是同样的功能，但是里面的参数个数不同
// 二分法 开始是要判断是否越界，比如后端小于前端，前后端是否超边界。 这样可以直接进行返回
// 接着是看是否成功，如果成功就可以直接返回值。如果不是继续进行下面的递归。
public class BinarySearch {
	public static int magicFast(int[] array, int start, int end) {
		if (end < start || start < 0 || end >= array.length) {
			return -1;
		}
		
		int mid = (start + end) / 2;
		if (array[mid] == mid) {
			return mid;
		} else if(array[mid] > mid) {
			return magicFast(array, start, mid - 1);
		} else {
			return magicFast(array, mid + 1, end);
		}
	}
	
	public static int magicFast(int[] array) {
		return magicFast(array, 0, array.length - 1);
	}
}
