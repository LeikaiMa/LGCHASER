package magicIndex;
// 如果加上不是distinct 就不能直接比较mid 然后忽略另外一边
// 因为就算现在value 要比 index 要小，也可能在左边找到相同的。
// 这时候就要查从start 到 value 是否存在，最好也要和这个index - 1 去个小值，这样更加节省时间
// 同理可以看右边
// 但是要注意的是每次得到左边的一部分时候有值成功返回，需要看否成功，成功后就可以直接进行返回。省时间。
public class NotDistinctBS {
	public static int magicFast(int[] array, int start, int end) {
		// 这里面要注意end 是>=长度的值
		if (end < start || start < 0 || end >= array.length) {
			return -1;
		}
		int midIndex = (start + end) / 2;
		int midValue = array[midIndex];
		if (midValue == midIndex) {
			return midIndex;
		}
		int leftIndex = Math.min(midIndex - 1, midValue);
		int left = magicFast(array, start, leftIndex);
		if (left >= 0) {
			return left;
		}

		int rightIndex = Math.max(midIndex + 1, midValue);
		int right = magicFast(array, rightIndex, end);

		return right;
	}
	
	public static int magicFast(int[] array) {
		return magicFast(array, 0, array.length - 1);
	}
}
