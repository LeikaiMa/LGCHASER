package testString;
// string 之中也可以check 是不是一个字符串contain
// indexof 也是从这个之开始，第一个遇到对应的值
// 可以是一个character 也可以是string

public class ContainsCharacter {
	public static void main(String[] args) {
		String string = "aaa";
		String string2 = "**a";
		String string3 = "ab*";
		String string4 = "ab*dc**";
		System.out.println(string.contains("*"));
		System.out.println(string2.contains("*"));
		System.out.println(string3.indexOf("*", 0));
		System.out.println(string4.indexOf('*', 10));
	}
}
