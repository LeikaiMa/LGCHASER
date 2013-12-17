package grayCode;

import java.util.ArrayList;
// graycode 主要用了递归的方法，在 0 的时候就只有1个0 在其他的情况下都是比前一种情况，在最开始加了一个1，同时包括原来的
// 但是加1的时候要注意是原来的倒序，因为只能改变一个。
// 同时要注意 <<  的等级要比+ 小，所以要先运行<< 要加 （）
public class GrayCode {
	public static ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> results = new ArrayList<Integer>();
		if (n == 0) {
			results.add(0);
		}
		// else if (n == 1) {
		// results.add(0);
		// results.add(1);
		// }
		else {
			ArrayList<Integer> moreResults = new ArrayList<Integer>();
			results = grayCode(n - 1);
			for (int i = results.size() - 1; i >= 0; i--) {
				int code = results.get(i);
				code = (1 << (n - 1)) + code;
				moreResults.add(code);
			}
			results.addAll(moreResults);
		}
		return results;
	}

	public static void main(String[] args) {
		System.out.println(grayCode(3));
		// System.out.println(1<< 1 );
	}
}
