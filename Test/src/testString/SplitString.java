package testString;
// 这个说明以/ 这个来进行区分，取前面，如果后面没有就不取了。
public class SplitString {
	public static void main(String[] args) {
		String s = "/a/./b/../../c/";
		String[] splitter = s.split("/");
//		System.out.println(splitter.length);
//		for (String string : splitter) {
//			System.out.println(string);
//		}
		System.out.println(splitter[0].length());
		System.out.println(splitter[0]);
		System.out.println(splitter[1]);
		System.out.println(splitter[6]);
		System.out.println(splitter[5]);
	}
}
