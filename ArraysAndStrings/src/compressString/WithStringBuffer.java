package compressString;

// 对于string 开始要检查是否为null 是否长度为0
// 长度为0 可以用length（）为0 或者直接是isEmpty（）
// 如果看数字的size ，比如两位数就占两位，可以先将int 转换为string 然后看 length()
// 然后比较好的连接string 的方法是用stringbuffer 这样不需要新建。
// 然后用append 和 toString 做string类似的操作。
// size 因为要加元素本身就要加1

public class WithStringBuffer {
	public String compressBetter(String str) {
		int size = countCompression(str);
		if (size >= str.length()) {
			return str;
		}

		StringBuffer mystr = new StringBuffer();
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				mystr.append(last);
				mystr.append(count);
				last = str.charAt(i);
				count = 1;
			}
		}

		mystr.append(last);
		mystr.append(count);
		return mystr.toString();
	}

	public static int countCompression(String str) {
		if (str == null || str.isEmpty()) {
			return 0;
		}
		char last = str.charAt(0);
		int size = 0;
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				last = str.charAt(i);
				size += 1 + String.valueOf(count).length();
				count = 1;
			}
		}
		size += 1 + String.valueOf(count).length();
		return size;
	}
}
