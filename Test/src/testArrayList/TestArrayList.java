package testArrayList;

import java.util.ArrayList;


public class TestArrayList {
//	public static void main(String[] args) {
//		ArrayList<String[]> al = new ArrayList<>();
//		String[] board = new String[4];
//		board[0] = "\".Q..\"";
//		board[1] = "\"...Q\"";
//		board[2] = "\"Q...\"";
//		board[3] = "\"..Q.\"";
//		al.add(board);
//		
//		System.out.println(Arrays.toString(al.get(0)));
//		
//	}
	//说明arraylist 传值进去赋值后返回值还是保存着
//	public static void main(String[] args) {
//		ArrayList<String[]> arrayList = new ArrayList<>();
//		arrayList = loadData(arrayList);
//		System.out.println(arrayList.size());
//	}
//
//	private static ArrayList<String[]> loadData(ArrayList<String[]> arrayList) {
//		String[] board = new String[4];
//		board[0] = "\".Q..\"";
//		board[1] = "\"...Q\"";
//		board[2] = "\"Q...\"";
//		board[3] = "\"..Q.\"";
//		arrayList.add(board);
//		return arrayList;
//	}
	//说明传入的参数只是一个指针，要进行更改必须对里面实际内容进行更改，同时也说明对里面的值进行更改，不需要回传值就可以直接更改。
//	public static void main(String[] args) {
//		ArrayList<Integer> a = new ArrayList<>();
//		ArrayList<Integer> b = new ArrayList<>();
//		a.add(1);
//		b.add(2);
//		changeArrayList(a, b);
//		System.out.println(a.get(0));
//	}
//
//	private static void changeArrayList(ArrayList<Integer> a,
//			ArrayList<Integer> b) {
//		a.clear();
//		for (Integer i :b ) {
//			a.add(i);
//		}
//		
//	}
 
	//arraylist 是不是存在不看他是不是null 而是看他是不是size 为0
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		System.out.println(arrayList.size());
	}
	
	

}
