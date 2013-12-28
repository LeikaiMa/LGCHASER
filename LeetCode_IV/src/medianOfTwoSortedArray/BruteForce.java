package medianOfTwoSortedArray;
// 这个求中间的数是总长/2 如果是偶数中间一个是总长 / 2 还有一个是 总长 -1 /2
import java.util.Arrays;

public class BruteForce {
	public static double findMedianSortedArrays(int A[], int B[]) {
		int lenA = A.length;
		int lenB = B.length;
		int[] result = new int[lenA + lenB];
		System.arraycopy(A, 0, result, 0, lenA);
		System.arraycopy(B, 0, result, lenA, lenB);
		Arrays.sort(result);

		if ((lenA + lenB) % 2 == 1) {
			return result[(lenA + lenB) / 2];
		} else {
			return (result[(lenA + lenB) / 2] + result[(lenA + lenB - 1) / 2]) / 2.0;
		}

	}
	
	public static void main(String[] args) {
		int[] A = {};
		int[] B = {2,3};
		System.out.println(findMedianSortedArrays(A, B));
	}
}
