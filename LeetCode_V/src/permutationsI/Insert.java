package permutationsI;

import java.util.ArrayList;
// 这种方法就是不断新建，然后插到从第0个到最后的一个位置，
// 可以学习的地方有加了之后可以用同样的位置进行删除用remove的就可以。
public class Insert {
	public static ArrayList<ArrayList<Integer>> permute(int[] num) {
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
					ArrayList<Integer> arrayList = new ArrayList<Integer>();
					arrayList.addAll(p);
					arrayList.add(j, num[i]);
					tmp.add(arrayList);
					
					//temp.add(j,num[i]);
					//ArrayList<Integer> temp1= new ArrayList<Integer>(temp);
					//cur.add(temp1);
					//temp.remove(j);
				}
			}
			permutations = tmp;
		}
		return permutations;
	}

	public static void main(String[] args) {
		int[] num = {1, 2, 3};
		ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();
		permutations = permute(num);
		for (ArrayList<Integer> a : permutations) {
			System.out.println(a);
		}
	}
}
