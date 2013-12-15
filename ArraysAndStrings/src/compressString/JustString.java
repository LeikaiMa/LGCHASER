package compressString;
// 这种可以先建一个字符串，然后有个初始条件，放在循环之前。
// 在循环中可以有两种更新条件，一种是递增，一种是存储然后重置。
// 然后在最后的时候把循环里面没有解决的问题再收尾。
// 但是直接用string 的加法，因为是新建新的string 所以更加耗空间。
public class JustString {
	public String compressBad(String str) {
		String mystr = "";
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				mystr += last + "" + count;
				last = str.charAt(i);
				count = 1;
			}
		}
		return mystr + last + count;
	}
}
