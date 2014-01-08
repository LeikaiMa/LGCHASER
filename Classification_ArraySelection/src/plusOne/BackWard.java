package plusOne;
// I - 12
// use arraycopy to copy one array to another.
// the first param is srcarray pos. the second is the dest and pos
// the size is the length

// 这个是从后面往前，如果不是9 就直接自加1 然后就可以返回了，如果是9 就变成再到前面，相当于一个循环就还是+1， 然后一直到出去，最开始的就是1
// 然后后面的将原来的所有的复制过来。
public class BackWard {
	public int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] != 9) {
				digits[i]++;
				return digits;
			} else {
				digits[i] = 0;
			}
		}

		int[] newDigits = new int[digits.length + 1];
		newDigits[0] = 1;
		System.arraycopy(digits, 0, newDigits, 1, digits.length);
		return newDigits;
	}
}
