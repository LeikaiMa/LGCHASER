package singleNumber;
//III
//从数组里面挑出只有一个的，可以利用^ 来进行bit 的运算。因为当有两个相同的时候可以通过^ 来进行抵消。

public class XOR {
	public int singleNumber(int[] A) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            result ^= A[i];
        }
        
        return result;
    }
}
