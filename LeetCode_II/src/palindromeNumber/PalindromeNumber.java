package palindromeNumber;
// 判断palindrome number 不能使用额外的space 就说明不能用string 的东西。
// 因为负数不是对称数，所以直接返回false 
// 先算出总共int 的位数，然后第一位和最后以为进行对比
// 关键点是怎么把这一位上的数字取出，可以先用比他大一位的取余也就是10的这个数位的power 再整除比他小一位的10的power 这样能够取出。
// 注意的是power 是double 要强制转换为int
// 如果不同直接返回false 否则到最后返回true
public class PalindromeNumber {
	public static boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int n = 0;
		int a = x;
		while (a > 0) {
			n++;
			a = a / 10;

		}
		int i = 1;
		while (n > i) {
			int pi = (int) Math.pow(10, i);
			int qi = (int) Math.pow(10, i - 1);
			int pn = (int) Math.pow(10, n);
			int qn = (int) Math.pow(10, n - 1);
			int hd = x % pn / qn;
			int ld = x % pi / qi;
			if (hd != ld) {
				return false;
			}
			n--;
			i++;
		}
		return true;
	}

	public static void main(String[] args) {
		// System.out.println(Integer.MIN_VALUE);
		// System.out.println(Integer.MAX_VALUE);
		// System.out.println((Integer.MIN_VALUE + 1) * -1);
		// System.out.println(Integer.MAX_VALUE * -1);
		// System.out.println((int) Math.pow(10, 0));
		System.out.println(isPalindrome(1230000321) == true);
		System.out.println(isPalindrome(11) == true);
		System.out.println(isPalindrome(9) == true);

	}
}
