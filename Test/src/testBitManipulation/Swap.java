package testBitManipulation;
// 这个说明的情况减号比 << 优先级要高。
// 交换的情况用XOR 必须要保证两个肯定不同数据，如果是在自己上面一个就引入第三个变量，作为暂时储存
// 否则会将会置0
public class Swap {

	public static void main(String[] args) {
		System.out.println((1<< 2) -1);
		int i = 2;
		int j = 2;
		i = i^j;
		j = i^j;
		i = i^j;
		
		System.out.println(i);
		System.out.println(j);
		
		int[] n= new int[2];
		n[0] = 0;
		n[1] = 1;
		n[0] = n[0] ^ n[1];
		n[1] = n[0] ^ n[1];
		n[0] = n[0] ^ n[1];
		System.out.println(n[0]);
		System.out.println(n[1]);
	}

}
