package grayCode;
//I - 7
//graycode 主要用了递归的方法，在 0 的时候就只有1个0 在其他的情况下都是比前一种情况，在最开始加了一个1，同时包括原来的
//但是加1的时候要注意是原来的倒序，因为只能改变一个。
//同时要注意 <<  的等级要比+ 小，所以要先运行<< 要加 （）
import java.util.ArrayList;
// 可以用iterative 的方法，将之前的放在一起，中间用临时变量，然后将临时的变量存到最后结果里面。
// 要注意的是自己错的情况是 1 << 应该是i 写成了n get 时候应该是j 写成i
// 还有就是运算符的优先级搞错了。
// ！ > 算术运算符 > 关系运算符 > && > || > 赋值运算符
public class AddOnFormerResult {
	public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> results = new ArrayList<Integer>();
		if (n < 0) {
			return results;
		}

		results.add(0);

		for (int i = 0; i < n; i++) {
			ArrayList<Integer> moreCode = new ArrayList<Integer>();
			for (int j = results.size() - 1; j >= 0; j--) {
				moreCode.add((1 << i) + results.get(j));
			}

			results.addAll(moreCode);
		}

		return results;
	}
}
