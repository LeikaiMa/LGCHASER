package testArrayList;

import java.util.ArrayList;

public class NoElementArraylist {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		for(int i: arrayList) {
			System.out.println(i + "reach here");
		}
		
	}
}
