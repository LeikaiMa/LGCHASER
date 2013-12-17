package zigzag;
// zigzag 关键点在转弯处如何处理，这里用多个stringbuffer 作为每一行的保存。
// 然后用一个increament作为移动的步伐， 可以在一些条件下进行改变。比如转向之类的反应
public class ZigZagConversion {
	public  static String convert(String s, int nRows) {
		if (s == null || nRows == 1) {
			return s;
		}
		StringBuffer[] stringBuffers = new StringBuffer[nRows];
		StringBuffer resultBuffer = new StringBuffer();
		int row = 0;
		int increament = 1;
		for (int i = 0; i < nRows; i++) {
			stringBuffers[i] = new StringBuffer();
		}
		for (int i = 0; i < s.length(); i++) {
			stringBuffers[row].append(s.charAt(i));
			row += increament;
			if (row == nRows) {
				row = row - 2;
				increament = -1;
			}
			if (row == -1) {
				row += 2;
				increament = 1;
			}
		}
		for (int i = 0; i < nRows; i++) {
			resultBuffer.append(stringBuffers[i].toString());
		}
		return resultBuffer.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 3));
	}
}
