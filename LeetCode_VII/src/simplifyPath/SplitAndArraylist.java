package simplifyPath;
// 这题主要要注意几个corner case 如果是 空的，或者是. 就跳过
// 如果是 .. 看里面有没有值，如果没有值，就跳过，如果有值，像我用arraylist 就remove last 如果是用stack 就pop 出来。
// 其他的都是直接插入。
// 最后拼接的时候，看如果是空的，就返回/ 如果不是空的，就一个/ 一个内容。
// 如果是arraylist 就正常拼接就可以了。如果是stack 就插在前面。
import java.util.ArrayList;
public class SplitAndArraylist {
	public static String simplifyPath(String path) {
		if (path == null) {
			return "/";
		}
		String[] parts = path.split("/");
		
		ArrayList<String> dir = new ArrayList<String>();
		
		for(String s: parts) {
			if (s.length() == 0 || s.equals(".")) {
				continue;
			}
			if (s.equals("..")) {
				if (dir.size() == 0) {
					continue;
				} else {
					dir.remove(dir.size() - 1);
				}
			} else {
				dir.add(s);
			}
		}
		if (dir.size() == 0) {
			return "/";
		}
		StringBuffer sb = new StringBuffer();
		for (String s : dir) {
			sb.append("/").append(s);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String path = "/a/./b/../../c/";
		
		System.out.println(simplifyPath(path));
		String path2 = "/../";
		System.out.println(simplifyPath(path2));
		String path3 = "/home//foo/";
		System.out.println(simplifyPath(path3));
		String path4 = "/...";
		System.out.println(simplifyPath(path4));
	}
	
	
}
