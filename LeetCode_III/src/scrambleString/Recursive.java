package scrambleString;
// 分析这道题的本质，求两个string 是不是 scramble string 
// 如果两个相同就是
// 如果不相等将这个两个string 进行等间距的拆分，左边如果和左边是scramble 右边和右边是scramble 就是。
// 或者是相反进行拆分，左和右是scramble 右和左 是scramble则是
// 这里用到一个递归。
// 如果只有一个直接比较就可以知道，如果不是一个，首先进行sort 看是不是最基本的个数和元素就不对应，如果不对应直接返回false 不用继续进行递归。
// 之后一个一个遍历，进行拆分，拆分的时候然后进行递归进行比较是不是scramble。
// 只要一个是就可以返回是scramble
import java.util.Arrays;

public class Recursive {
	public static boolean isScramble(String s1, String s2) {
		if (s1 == null && s2 == null) {
			return true;
		}
		if (s1.isEmpty() && s2.isEmpty()) {
			return true;
		}
		int l1 = s1.length();
		int l2 = s2.length();
		if (l1 != l2) {
			return false;
		}
		if (l1 == 1) {
			if (s1.charAt(0) ==  s2.charAt(0)) {
				return true;
			} else {
				return false;
			}
		}
		
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		for (int i = 0; i < c1.length; i++) {
			if (c1[i] != c2[i]) {
				return false;
			}
		}
		
		for (int i = 1; i < l1; i ++) {
			String s1l1 = s1.substring(0, i);
			String s1r1 = s1.substring(i);
			
			String s2l1 = s2.substring(0, i );
			String s2r1 = s2.substring(i);
			if (isScramble(s1l1, s2l1) && isScramble(s1r1, s2r1)) {
				return true;
			} 
			
			String s2l2 = s2.substring(0, l2 - i);
			String s2r2 = s2.substring(l2 - i);
			if (isScramble(s1l1, s2r2) && isScramble(s1r1, s2l2)) {
				return true;
			}
		}
		return false;
	}
	
	

	
	public static void main(String[] args) {
//		String s1= "abcd";
//		String s2= "bdac";
		String s1= "abcdd";
		String s2= "dbdac";
		System.out.println(isScramble(s1, s2) == false);
//		 s1= "ab";
//		 s2 = "ba";
//		 System.out.println(isScramble(s1, s2) ==  true);
//		s1 = "ymjmfxshglxwrrgufcvvzjuietjzzz";
//		s2 = "fxczujvmwizrzgxgjmvzelyjthusrf";
//		System.out.println(isScramble(s1, s2));
	}
}
