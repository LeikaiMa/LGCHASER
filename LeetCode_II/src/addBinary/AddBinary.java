package addBinary;

import java.util.ArrayList;
// 整体的思路是先去除完全不可能的情况，然后取长的。
// 因为int 和string 的index 的方向不同，所以要从后往前，而且避免走过，所以用短的来进行遍历。
// 在里面的时候可以将character 转换为int ，因为可以用加法所以不要太考虑是不是只用逻辑运算符。
// 加法的本质上就是一个sum 和一个carry ，因为允许使用加法，所以carry 就是 / 2 因为这个是二进制加法， sum就是% 2
// 不一定要把sum 清空， 但是carry 一定不能清空，因为下一位加的时候要继续用。 
// 然后把每一位存到arraylist 里面，最后输出的时候是将里面的倒序输出到buffer 里面，然后buffer 再输出为result
public class AddBinary {
	public static String addBinary(String a, String b) {
		if (a == null || b == null || a.isEmpty() || b.isEmpty()) {
			return null;
		}
		String longer, shorter;
		ArrayList<Integer> sumArrayList = new ArrayList<Integer>();
		if (a.length() >= b.length()) {
			longer = a;
			shorter = b;
		} else {
			longer = b;
			shorter = a;
		}

		int indexLong = longer.length() - 1;
		int indexShort = shorter.length() - 1;
		int sum = 0;
		int carry = 0;
		while (indexShort >= 0) {
			int l = longer.charAt(indexLong) - '0';
			int s = shorter.charAt(indexShort) - '0';
			int total = l + s + carry;
			sum = total % 2;
			carry = total / 2;
			sumArrayList.add(sum);
//			sum = 0;
			indexLong--;
			indexShort--;
		}

		while (indexLong >= 0) {
			int l = longer.charAt(indexLong) - '0';
			int total = l + carry;
			sum = total % 2;
			carry = total / 2;
			sumArrayList.add(sum);
//			sum = 0;
			indexLong--;
		}

		if (carry > 0) {
			sumArrayList.add(carry);
		}

		StringBuffer result = new StringBuffer();
		for (int i = sumArrayList.size() - 1; i >= 0; i--) {
			result.append(sumArrayList.get(i));
		}

		return result.toString();

	}
	
	public static void main(String[] args) {
		String a = "110";
		String b = "1";
		String result = addBinary(a, b);
		System.out.println(result);
	}
}
