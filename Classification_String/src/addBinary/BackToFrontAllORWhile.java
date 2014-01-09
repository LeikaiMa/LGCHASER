package addBinary;
// II
//整体的思路是先去除完全不可能的情况，然后取长的。
//因为int 和string 的index 的方向不同，所以要从后往前，而且避免走过，所以用短的来进行遍历。
//在里面的时候可以将character 转换为int ，因为可以用加法所以不要太考虑是不是只用逻辑运算符。
//加法的本质上就是一个sum 和一个carry ，因为允许使用加法，所以carry 就是 / 2 因为这个是二进制加法， sum就是% 2
//不一定要把sum 清空， 但是carry 一定不能清空，因为下一位加的时候要继续用。 
//然后把每一位存到arraylist 里面，最后输出的时候是将里面的倒序输出到buffer 里面，然后buffer 再输出为result

// 现在的这个方法是将最后结果直接生成一个string buffer 每次在他的前面添加结果。
// 不管a b 还是 carry 有值
// 而是三个都为0 的时候才停止，中间不要担心是否过界，因为只是>=0 的时候才取值。
// 这里错的是留下来的是取余，而进位的是整除的，自己开始做的时候搞反了。
public class BackToFrontAllORWhile {
	public String addBinary(String a, String b) {
		int la = a.length() - 1;
		int lb = b.length() - 1;
		int c = 0;
		StringBuffer sb = new StringBuffer();
		while (la >= 0 || lb >= 0 || c > 0) {
			int v = c;
			if (la >= 0) {
				v += a.charAt(la) - '0';
			}

			if (lb >= 0) {
				v += b.charAt(lb) - '0';
			}

			sb.insert(0, v % 2);
			c = v / 2;
			la--;
			lb--;
		}

		return sb.toString();
	}
}
