package testArrayList;

import java.util.ArrayList;
// 无论是clone 还是其他的情况arraylist 赋值还都是要改原来的值
// deep copy 要clone 歘来复制
public class ChangeContent {
//	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ArrayList<Integer> a1 = new ArrayList<>();
		a1.add(1);
		ArrayList<Integer> a2 = new ArrayList<>();
		a2.add(2);
		ArrayList<ArrayList<Integer>> a = new ArrayList<>();
		a.add(a1);
		a.add(a2);
		ArrayList<ArrayList<Integer>> b = new ArrayList<>();
		
//		Collections.copy(a, b);
//		b = (ArrayList<ArrayList<Integer>>) a.clone();
 		for (ArrayList<Integer> i : a) {
 			@SuppressWarnings("unchecked")
			ArrayList<Integer> k = (ArrayList<Integer>)i.clone();
 			k.add(0);
 			b.add(k);
 			
 		}
 		System.out.println(b.get(0));
 		System.out.println(a.get(0));
	}
}
