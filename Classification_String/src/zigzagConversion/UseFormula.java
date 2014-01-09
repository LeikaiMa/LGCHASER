package zigzagConversion;
// I
// 这个有区别于之前自己做的时候，要对整个找规律，除了第一行和最后一行都是1个，所以两个轮回对应之间的距离就是 nRows * 2 -2
// 然后一个轮回是有两个，再找第二个和第一个的距离，可以看到是 之前一个轮回的距离 - 2 * 自己第一个所在的index 位置。
// 这样一行一行的遍历，中间按照上面算出来的间距进行跳跃，如果是中间的要加上第二个的，每个都要保证不能超过len 否则会出错
// 自己在这题做错的情况一个是while 循环 应该是< 自己写成 > 
// 然后没有将所有的情况写到一起。 break 跳出的条件是 >= 自己写成了 >
public class UseFormula {
	public static String convert(String s, int nRows) {
		if (nRows == 1) {
			return s;
		}
		int span = nRows * 2 - 2;
		int len = s.length();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < nRows; i++) {
			int index = i;
			int next = span - 2 * i;
			while (index < len) {
				sb.append(s.charAt(index));
				if (i != 0 && i != nRows - 1) {
					if (index + next >= len) {
						break;
					} else {
						sb.append(s.charAt(index + next));
					}
				}
				index += span;
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "ABC";
		int nRows = 3;
		System.out.println(convert(s, nRows));
	}
}
