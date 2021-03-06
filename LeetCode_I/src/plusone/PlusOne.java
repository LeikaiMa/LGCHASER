package plusone;

import java.util.Arrays;

public class PlusOne {
//	public class Solution {
		public static int[] plusOne(int[] digits) {
			// array is length
			for (int i = digits.length - 1; i >= 0; i--) {
				if (digits[i] >= 0 && digits[i] < 9) {
					digits[i]++;
					return digits;
				} else {
					digits[i] = 0;
				}
			}
			int[] newDigits = new int[digits.length + 1];
			newDigits[0] = 1;
			// use arraycopy to copy one array to another.
			// the first param is srcarray pos. the second is the dest and pos
			// the size is the length
			System.arraycopy(digits, 0, newDigits, 1, digits.length);
			return newDigits;

		}
//	}

	public static void main(String[] args) {
		int test1 = 0;
		int test2 = 1;
		int test3 = 100;
		int test4 = 109;
		int test5 = 99;
		int[] a1 = parseInt(test1);
		int[] a2 = parseInt(test2);
		int[] a3 = parseInt(test3);
		int[] a4 = parseInt(test4);
		int[] a5 = parseInt(test5);

		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(a2));
		System.out.println(Arrays.toString(a3));
		System.out.println(Arrays.toString(a4));
		System.out.println(Arrays.toString(a5));
		
		System.out.println(Arrays.toString(plusOne(a1)));
		System.out.println(Arrays.toString(plusOne(a2)));
		System.out.println(Arrays.toString(plusOne(a3)));
		System.out.println(Arrays.toString(plusOne(a4)));
		System.out.println(Arrays.toString(plusOne(a5)));

	}

	private static int[] parseInt(int number) {
		String s = String.valueOf(number);
//		String[] strArray = s.split("");
//		System.out.println(Arrays.toString(strArray));
//		int[] intArray = new int[strArray.length];
//		for (int i = 0; i < strArray.length; i++) {
//			if (!strArray[i].equals(""))
//				intArray[i] = Integer.parseInt(strArray[i]);
//		}
//		return intArray;
		char[] charArray = s.toCharArray();
		int[] intArray = new int[charArray.length];
		for(int i = 0; i < charArray.length; i++) {
		     intArray[i] = Integer.parseInt("" + charArray[i]);
		} 
		return intArray;
	}	

}
