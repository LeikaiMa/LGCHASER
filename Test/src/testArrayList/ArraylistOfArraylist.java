package testArrayList;

import java.util.ArrayList;
// 不要建arraylist 的array 最好建的是arraylist of arraylsit
// 新建arraylist后也要new 出来
public class ArraylistOfArraylist {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> heights = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < 4; i ++ ) {
			ArrayList<Integer> a = new ArrayList<>();
			heights.add(a);
		}
//		ArrayList<ArrayList<Integer>> heights = new ArrayList<ArrayList<Integer>>(4);
		ArrayList<Integer> a1 = heights.get(0);
		a1.add(1);
		System.out.println(a1);
	}
}
