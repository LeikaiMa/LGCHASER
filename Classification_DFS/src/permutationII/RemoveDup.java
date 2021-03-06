package permutationII;
//V
//因为不能有重复，所以要避免有类似的重复操作，虽然很多时候这个是不在意
//在这里有意为之，使得重复的放在一起，用sort 的形式重新进行排序。
//在下面就要过滤掉重复的操作，重复的操作就是在第一个出现的时候或者相同个数出现的情况，因为他们不同的排序都还是相同。所以让他们必须按照固定的次序出发，这样就可以避免出现重复
//在具体操作的时候第一个肯定是要输出的，所以在最开始的时候判断i 是要大于0，这样可以短路掉后面的。
//然后要比较如果现在这个和前面一个如果相同的话，前面一个如果没有跑过，这个就要跳过。
//其他的和普通的permutation 同样，将没有遍历过的元素一一塞进list 里面，进行dfs ，进去的时候标记，出来之后解除标记。
import java.util.ArrayList;
import java.util.Arrays;
//这个和combination 有不同的地方在于只有这个是visited 没有被遍历过，后面才进行过滤，因为如果遍历过说明是从上面一层过来的，则要加，如果没有visit 过，说明是会有重复的情况。应该这个是要过滤掉的。
public class RemoveDup {
	public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return results;
		}

		ArrayList<Integer> result = new ArrayList<Integer>();
		boolean[] visited = new boolean[num.length];
		Arrays.sort(num);
		helper(results, result, num, visited);

		return results;
	}

	public static void helper(ArrayList<ArrayList<Integer>> results,
			ArrayList<Integer> result, int[] num, boolean[] visited) {
		if (result.size() == num.length) {
			results.add(new ArrayList<Integer>(result));
		} else {
			for (int i = 0; i < visited.length; i++) {
				if (!visited[i]) {
					visited[i] = true;
					result.add(num[i]);
					helper(results, result, num, visited);
					result.remove(result.size() - 1);
					visited[i] = false;
				}

				while (i < visited.length - 1 && num[i] == num[i + 1] && !visited[i]) {
					i++;
				}
			}
		}
	}
	
	public static void main(String[] args) {
//		int[] num = {-1, -1};
		int[] num = {1,1,0,0,1,-1,-1,1};
		ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();
		permutations = permuteUnique(num);
		for (ArrayList<Integer> a : permutations) {
			System.out.println(a);
		}
	}

}
