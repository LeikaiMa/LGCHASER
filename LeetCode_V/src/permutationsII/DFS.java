package permutationsII;
// 因为不能有重复，所以要避免有类似的重复操作，虽然很多时候这个是不在意
// 在这里有意为之，使得重复的放在一起，用sort 的形式重新进行排序。
// 在下面就要过滤掉重复的操作，重复的操作就是在第一个出现的时候或者相同个数出现的情况，因为他们不同的排序都还是相同。所以让他们必须按照固定的次序出发，这样就可以避免出现重复
// 在具体操作的时候第一个肯定是要输出的，所以在最开始的时候判断i 是要大于0，这样可以短路掉后面的。
// 然后要比较如果现在这个和前面一个如果相同的话，前面一个如果没有跑过，这个就要跳过。
// 其他的和普通的permutation 同样，将没有遍历过的元素一一塞进list 里面，进行dfs ，进去的时候标记，出来之后解除标记。
import java.util.ArrayList;
import java.util.Arrays;

public class DFS {
	public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return permutations;
		}
		Arrays.sort(num);
		ArrayList<Integer> permutation = new ArrayList<Integer>();
		boolean[] visited = new boolean[num.length];

		permuteUniqueHelper(permutations, permutation, visited, num, 0);
		return permutations;
	}

	private static void permuteUniqueHelper(
			ArrayList<ArrayList<Integer>> permutations,
			ArrayList<Integer> permutation, boolean[] visited, int[] num,
			int step) {
		if (step == num.length) {
			ArrayList<Integer> p = new ArrayList<Integer>(permutation);
			permutations.add(p);
		} else {
			for (int i = 0; i < num.length; i++) {
				if (i > 0 && num[i - 1] == num[i] && !visited[i - 1]) {
					continue;
				}
				if (!visited[i]) {
					visited[i] = true;
					permutation.add(num[i]);
					permuteUniqueHelper(permutations, permutation, visited,
							num, step + 1);
					permutation.remove(step);
					visited[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] num = {1,1,0,0,1,-1,-1,1};
		ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();
		permutations = permuteUnique(num);
		for (ArrayList<Integer> a : permutations) {
			System.out.println(a);
		}
	}
}
