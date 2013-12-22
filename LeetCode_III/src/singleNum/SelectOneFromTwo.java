package singleNum;
// 从数组里面挑出只有一个的，可以利用^ 来进行bit 的运算。因为当有两个相同的时候可以通过^ 来进行抵消。
public class SelectOneFromTwo {
	public static int singleNumber(int[] A) {
		int single = 0;
		for (int i = 0; i < A.length; i++) {
			single = single ^ A[i];
		}
		return single;
	}
	
	public static void main(String[] args) {
		int [] A = {1,2,3,4,2,3,1,5,5,6,4};
		System.out.println(singleNumber(A));
	}
}
