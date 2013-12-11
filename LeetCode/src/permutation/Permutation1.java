package permutation;

//从集合中依次选出每一个元素，作为排列的第一个元素，然后对剩余的元素进行全排列，如此递归处理，
//* 从而得到所有元素的全排列。以对字符串abc进行全排列为例，我们可以这么做：以abc为例：
//* 固定a，求后面bc的排列：abc，acb，求好后，a和b交换，得到bac
//* 固定b，求后面ac的排列：bac，bca，求好后，c放到第一位置，得到cba
//* 固定c，求后面ba的排列：cba，cab。

public class Permutation1 {
	public static void permuation(int[] str, int first, int end) {
		// 输出str[first..end]的所有排列方式
		if (first == end) { // 输出一个排列方式
			for (int j = 0; j <= end; j++) {
				System.out.print(str[j]);
			}
			System.out.println();
		}

		for (int i = first; i <= end; i++) {
			swap(str, i, first);
			permuation(str, first + 1, end); // 固定好当前一位，继续排列后面的
			swap(str, i, first);
		}
	}

	private static void swap(int[] str, int i, int first) {
		int tmp;
		tmp = str[first];
		str[first] = str[i];
		str[i] = tmp;
	}

	public static void main(String args[]) throws Exception {
		// int[] str = {1,2,3};
		int n = 4;
		int[] intArray = new int[n];
		for (int i = 0; i < n; i++) {
			intArray[i] = i;
		}
		// 输出str[0..2]的所有排列方式
		permuation(intArray, 0, n - 1);
	}
}
