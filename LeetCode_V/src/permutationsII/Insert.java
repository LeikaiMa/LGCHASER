package permutationsII;
// 这种方法超时，超时的原因是因为实际上重复的步骤还是进行操作了，每次都进行比较之后看能不能插，就少了插的动作，但是比较的时间还是消耗了。
import java.util.ArrayList;

public class Insert {
	public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return permutations;
		}

		ArrayList<Integer> permutation = new ArrayList<Integer>();
		permutation.add(num[0]);
		permutations.add(permutation);

		for (int i = 1; i < num.length; i++) {
			ArrayList<ArrayList<Integer>> tmp = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> p : permutations) {
				for (int j = 0; j <= p.size(); j++) {
					if (j == p.size() || p.get(j) != num[i]) {
						ArrayList<Integer> arrayList = new ArrayList<Integer>();
						arrayList.addAll(p);
						arrayList.add(j, num[i]);
						tmp.add(arrayList);
					}
				}
			}
			permutations = tmp;
		}
		return permutations;
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
