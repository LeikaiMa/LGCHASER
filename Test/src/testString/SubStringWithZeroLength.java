package testString;

public class SubStringWithZeroLength {

	public static void main(String[] args) {
		String s = "abc";
		System.out.println(s.substring(0, 0));
		System.out.println(s.substring(0));
		StringBuffer sb = new StringBuffer();
		sb.append(s.subSequence(0, 0)).append("a").append(s.substring(0));
		System.out.println(sb.toString());
		System.out.println(s.substring(s.length()) + "-----");
	}

}
