package testString;

public class SubStringExceedLength {
// runtime error
//	说明substring 不能超过最大限制。
	public static void main(String[] args) {
		String s = "abc";
//		String subString = s.substring(-1, 2);
//		System.out.println(subString);
//		System.out.println(subString);
		
		
		String subString = s.substring(4);
		System.out.println(subString);
	}

}
