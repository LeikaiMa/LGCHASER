package firstMissingPositive;
// 寻找第一个没有的正数。
// 因为复杂度要求是在O(n) 所以不能用sort 之后顺序找的方法。
// 看到n 应该可以推测出一个一个检查过去。在检查的时候做操作。
// 因为是正数，可以利用index 是从0 开始的正整数，可以将所对应的如果在1-n范围的内的放在对应 的 0 - n-1 上面。
// 最后检查的时候看看i对应的上面有没有i+1的数，如果没有就说明缺的就是这个。
// 在里面要更换的条件是，自己不是排在这个位置上，而且不排在这个上面自己有地方去，也就是意味着他是在1-n-1 的这个区间上。
// 但是要注意的是一个是换完之后要将i--因为是新换的要还没有检查过。要再检查一遍。
// 还有一个要注意的是要看换过来的和自己一不一样，如果是一样的就变成死循环。
// 最后要注意两个边界条件，一个是如果这个数组本身就没有，就应该返回的是第一个正数1
// 如果正好全部都是前n 个，那么就返回n+1
public class UseArrayIndex {
	public static int firstMissingPositive(int[] A) {
		if (A == null || A.length == 0) {
			return 1;
		}
		int n = A.length;
		for (int i = 0; i < n; i++) {
			if (A[i] != i + 1 && A[i] > 0 && A[i] <= n && A[A[i] - 1] != A[i]) {
				int tmp = A[i];
				A[i] = A[tmp - 1];
				A[tmp - 1] = tmp;
				i--;
			}
		}

		for (int i = 0; i < n; i++) {
			if (A[i] != i + 1) {
				return i + 1;
			}
		}
		return n + 1;
	}

	public static void main(String[] args) {
		// int[] A = {1,2,0};
		// int[] A ={3,4,-1,1};
		int[] A = { 1, 1 };
		System.out.println(firstMissingPositive(A));
	}
}
