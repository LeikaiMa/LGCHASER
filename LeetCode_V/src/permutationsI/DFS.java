package permutationsI;
// 这个是用DFS 进行排序，从前开始遍历，每个情况进行DFS，因为是DFS，所以是执行完了才做后面的，而且用了visited 进行标记，这样就不会有将之前已经遍历过的元素再重新遍历一遍。
// 通过step 来看有没有遍历完。
// 进去之前标记好，出来之后visited 取消标记，arraylist 也取消塞入。
// 这里用到了remove 和生成的时候直接用constructor 的方法，省掉用addAll 使得代码更加简洁。
import java.util.ArrayList;

public class DFS {
	public static ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return permutations;
		}

		ArrayList<Integer> permutation = new ArrayList<Integer>();
		boolean[] visited = new boolean[num.length];
		
		permuteHelper(permutations, permutation, visited, num, 0);
		return permutations;
	}

	private static void permuteHelper(
			ArrayList<ArrayList<Integer>> permutations,
			ArrayList<Integer> permutation, boolean[] visited, int[] num, int step) {
		if (step == num.length) {
			ArrayList<Integer> p = new ArrayList<Integer>(permutation);
			permutations.add(p);
		} else {
			for (int i = 0; i < num.length; i++) {
				if (!visited[i]) {
					visited[i] = true;
					permutation.add(num[i]);
					permuteHelper(permutations, permutation, visited, num, step + 1);
					permutation.remove(step);
					visited[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] num = {1, 2, 3,4,5};
		ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();
		permutations = permute(num);
		for (ArrayList<Integer> a : permutations) {
			System.out.println(a);
		}
	}
}
