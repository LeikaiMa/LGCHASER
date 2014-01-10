package singleNumberII;
//III
//这边也是用的位操作，本质上用二进制来进行三进制的操作。
//首先看有哪些是加上现在这个是达到了两次，用& 来发现，再和现在的进行 | 加到 two 里面去
//one再和现在进行 ^ 来现在没有的。如果原来就有的就会变成0
//如果one two同样的bit 位都存在就说明已经是3个了，先& 得到这些位数，
//因为一旦到了 三个就要清空，所以就先取反然后分别和one two 进行 & ，清除这些位。 最后要找到剩下一个的，就去one 里面
//参考http://www.cnblogs.com/daijinqiao/p/3352893.html
public class ThreeTmp {
	public int singleNumber(int[] A) {
		int one = 0;
		int two = 0;
		int three = 0;

		for (int i : A) {
			two |= one & i;
			one = one ^ i;
			three = ~(one & two);
			one = one & three;
			two = two & three;
		}

		return one;
	}
}
