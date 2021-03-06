package searchForRange;

import java.util.Arrays;

public class BinarySearch {
	public static  int[] searchRange(int[] A, int target) {
		int pos = binarySearch(A, target, 0, A.length -1);
		if (pos == -1) {
			int[] result = {-1, -1};
			return result;
		}
		int left = pos;
		int right = pos;
		while (left >= 0 && A[left] == target) {
			left--;
		}
		left++;
		while (right <= A.length - 1 && A[right] ==  target) {
			right ++;
		}
		right --;
		int[] result = {left, right};
		return result;
	}
	
	public static int binarySearch(int[] A, int target, int start, int end) {
		if (start > end) {
			return -1;
		} 
		
		int mid = start + (end - start) / 2;
		if (A[mid] == target) {
			return mid;
		} else if (A[mid] < target) {
			return binarySearch(A, target, mid + 1, end);
		} else {
			return binarySearch(A, target, start, mid - 1);
		}
	}
	
	public static void main(String[] args) {
		int[] A = {5, 7, 7, 8, 8, 10};
		int target = 2;
		System.out.println(Arrays.toString(searchRange(A, target)));
	}
}
