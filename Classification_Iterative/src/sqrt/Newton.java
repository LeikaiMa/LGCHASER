package sqrt;
//VII
//这个是用牛顿迭代法，原本用的二分法，可能会溢出，可以加一个限定条件，
//牛顿这个方法就记住就可以了。
//http://www.cnblogs.com/AnnieKim/archive/2013/04/18/3028607.html
//http://fisherlei.blogspot.com/2013/01/leetcode-sqrtx.html
public class Newton {
	public int sqrt(int x) {
		if (x == 0 || x == 1) {
			return x;
		}

		double last = 0;
		double res = 1;
		while (res != last) {
			last = res;
			res = (res + x / res) / 2;
		}

		return (int) res;
	}
}
