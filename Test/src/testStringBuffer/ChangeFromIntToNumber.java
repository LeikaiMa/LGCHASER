package testStringBuffer;
// StringBuffer 要直接插入数字直接append 要插在前面用insert 
public class ChangeFromIntToNumber {
	public static void main(String[] args) {
		StringBuffer resultBuffer = new StringBuffer();
		resultBuffer.append('0');
		resultBuffer.append(9);
		resultBuffer.insert(0, 9);
		System.out.println(resultBuffer);
	}
}
