package trailingOfZeros;
// 因为阶乘很容易就超过int 的最大值，所以不能等到全部算完之后再求。
// 不能最后求，就需要在过程中求。
// 通过观察可以看出，2 要比 5 要多，所以只需要数5 的个数。
// 阶乘所有的5就是每一个数的5的个数，每个数的5的个数就是%5可以的次数。但是每次完成之后要/5

public class FactorOfFive {
	public int factorsOf5(int i) {
		int count = 0;
		while (i % 5 == 0) {
			count++;
			i /= 5;
		}
		return count;
	}
	
	public int countFactorZeros(int num) {
		int count = 0;
		for (int i = 2; i <= num; i++) {
			count += factorsOf5(i);
		}
		return count;
	}
}
