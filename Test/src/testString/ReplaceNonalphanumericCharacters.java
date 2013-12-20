package testString;
// 用正则表达式将非英文字母的替换掉
public class ReplaceNonalphanumericCharacters {
	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		s = s.replaceAll("[^a-zA-Z]", "");
		System.out.println(s);
	}
}
