package testString;
// string 在method 里面改了是不会返回的，因为是新建了string
public class ChangeStringInMethod {
	public static void main(String[] args) {
		String s = "a";
		changeString (s);
		System.out.println(s);
		
	}

	private static void changeString(String s) {
		s = s + "b";
	}
}
