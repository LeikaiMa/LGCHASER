package candy;

import java.util.Arrays;
// 这个的方法是首先将自己的第一个置为1，至少有一块糖。
// 然后有一个在自己的前面，如果前面那一个比自己小，那么就表示自己不是最低点，就让前面那一个往前再走。这里比较的是和自己相邻的，而不是和前一个指针所在位置。
// 如果前面的开始上升或者持平，说明前一个指针的后面一个是最低点。
// 那么就要倒推往回走。首先要判断前面是上升过来的，还是下降过来的，下降过来就没有值，上升过来的就有值。
// 所以是取1 和他本身的大值，这里可以优化的就是开始的时候可以全部置1，
// 然后从前前一个开始看直到自己的那个最高点的指针i 的位置，这个时候都是不断增加的，因为是有可能是相同的情况，那么就是取他本身或者是后一个小值+1的大值。
// 最后要看自己是不是和前一个相同，如果相同自己可以是最小的1，如果不是应该就是前面的基础上+1
// 然后就是将最后一个如果是小值的话，那么还要前面的倒推回去填满。自己肯定是1
// 这个思路比较复杂，面试的时候不推荐
public class TwoPointer {
	public static int candy(int[] ratings) {
		if (ratings == null) {
			return 0;
		}
		if (ratings.length == 0 || ratings.length == 1) {
			return ratings.length;
		}

		int[] candies = new int[ratings.length];
		int i = 0;
		int j = 1;
		candies[0] = 1;

		while (j < ratings.length) {
			if (ratings[j] >= ratings[j-1]) {
				candies[j - 1] = Math.max(1, candies[j - 1]);
				int k = j - 2;
				while (k >= i) {
					candies[k] = Math.max(candies[k], candies[k + 1] + 1);
					k--;
				}

				candies[j] = ratings[j] == ratings[j-1] ? 1
						: candies[j - 1] + 1;
				i = j;
				j++;
			} else {
				j++;
			}
		}

		if (ratings[j - 1] < ratings[j - 2]) {
			candies[j-1] = 1;
			int k = j - 2;
			while (k >= i) {
				candies[k] = Math.max(candies[k], candies[k + 1] + 1);
				k--;
			}
		}

		System.out.println(Arrays.toString(ratings));
		System.out.println(Arrays.toString(candies));
		int total = 0;
		for (int candy : candies) {
			total += candy;
		}
		return total;
	}

	public static void main(String[] args) {
		int[] ratings = {5,1,1,1,10,2,1,1,1,3};
		System.out.println(candy(ratings) == 15);
		int[] rating2 = {1,2,2};
		System.out.println(candy(rating2) ==4);
		int[] rating3 = {2,2,1};
		System.out.println(candy(rating3) == 4);
	}
}
