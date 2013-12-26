package testStringBuffer;
// stringbuffer 同样也是前闭后开的substring
public class SubStringInStringBuffer {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		sb.append("abc");
		System.out.println(sb.substring(1, sb.length()));
	}
}
