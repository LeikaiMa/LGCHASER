package testArray;
//这个是直接将两个list 连接在一起，在system 里面有 arraycopy 这个，前面是要拷贝的array 后面是目标的array 然后是具体的长度， 每个都代表的是里面的起点和长度
// 第二个直接用length 因为上面一个用的是length - 1
import java.util.Arrays;

public class ConcatArrays {
	public static void main(String[] args){
		int[] A = {};
		int[] B = {2,3};
		int lenA = A.length;
		int lenB = B.length;
		int[] result = new int[lenA + lenB];
		System.arraycopy(A, 0, result, 0, lenA);
		System.arraycopy(B, 0, result, lenA, lenB);
		Arrays.sort(result);
		System.out.println((-1)/2);
		System.out.println(A.length);
	}
}
