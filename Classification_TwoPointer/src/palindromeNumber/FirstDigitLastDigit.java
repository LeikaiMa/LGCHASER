package palindromeNumber;
// II
//判断palindrome number 不能使用额外的space 就说明不能用string 的东西。
//因为负数不是对称数，所以直接返回false 
//先算出总共int 的位数，然后第一位和最后以为进行对比
//关键点是怎么把这一位上的数字取出，可以先用比他大一位的取余也就是10的这个数位的power 再整除比他小一位的10的power 这样能够取出。
//注意的是power 是double 要强制转换为int
//如果不同直接返回false 否则到最后返回true

// 在这里做的时候要注意的因为不能额外的空间，就是要直接在自己身上做文章。
// 负数直接不是，直接返回。 如果reverse 有可能会overflow 所以就不行。
// 要搞就直接取第一个和最后一位的数字进行比较。
// 首先怎么得到第一位，要得到div 用x 去整除，得到是1位就说明已经得到想要的，只要每次整除这个div 就可以得到第一位。
// 最后一位得到就直接%，然后进行比较就可以了。
// 然后要将第一位和最后一位去掉，用和之前相反的方法，前面是% 最后一位去掉是用/
// 然后div 因为整个数少了两位就直接 /100
// 最后看x 是否为0 如果能正常出来就说明是palindrome， 如果不是在中间比较过程中的时候就返回false
public class FirstDigitLastDigit {
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}

		int div = 1;
		while (x / div >= 10) {
			div *= 10;
		}

		while (x > 0) {
			int h = x / div;
			int l = x % 10;

			if (h != l) {
				return false;
			}

			x = (x % div) / 10;
			div /= 100;
		}

		return true;
	}
}
