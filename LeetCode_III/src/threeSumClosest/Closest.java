package threeSumClosest;
// 同样的方法，一个作为array的遍历，还有连个作为另一种遍历，两头进行夹击，过小，左边+1， 过大右边-1
// 如果是相等正好直接返回。
// 有个gap 最大值作为比较记录。
// 每次在里面遍历的时候记住gap 然后和这个标杆进行比较。如果比这个还要小就更新标杆
import java.util.Arrays;

public class Closest {
	public static int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		int result = 0;
		int gap = Integer.MAX_VALUE;
		for (int i = 0; i < num.length - 2; i++) {
			int sum = 0;
			int g = Integer.MAX_VALUE;
			for (int j = i + 1, k = num.length - 1; j < k;) {
				sum = num[j] + num[k] + num[i];

				g = sum - target;
				if (g < 0) {
					j++;
				} else if (g > 0) {
					k--;
				} else {
					return target;
				}
				if (Math.abs(g) < gap) {
					gap = Math.abs(g);
					result = sum;
				}
			}

		}
		return result;
	}

	public static void main(String[] args) {
		// int[] S = { -1, 2, 1, -4 };
		int[] S = { 87, 6, -100, -19, 10, -8, -58, 56, 14, -1, -42, -45, -17,
				10, 20, -4, 13, -17, 0, 11, -44, 65, 74, -48, 30, -91, 13, -53,
				76, -69, -19, -69, 16, 78, -56, 27, 41, 67, -79, -2, 30, -13,
				-60, 39, 95, 64, -12, 45, -52, 45, -44, 73, 97, 100, -19, -16,
				-26, 58, -61, 53, 70, 1, -83, 11, -35, -7, 61, 30, 17, 98, 29,
				52, 75, -73, -73, -23, -75, 91, 3, -57, 91, 50, 42, 74, -7, 62,
				17, -91, 55, 94, -21, -36, 73, 19, -61, -82, 73, 1, -10, -40,
				11, 54, -81, 20, 40, -29, 96, 89, 57, 10, -16, -34, -56, 69,
				76, 49, 76, 82, 80, 58, -47, 12, 17, 77, -75, -24, 11, -45, 60,
				65, 55, -89, 49, -19, 4 };
		System.out.println(threeSumClosest(S, -275));
	}

}
