package testArrayList;

import java.util.ArrayList;
import java.util.Collections;
// arraylist sort 是按照顺序来排序
// reverse 是将原来反过来
// sort 加第二个参量才可以倒序
public class CollectionSort {
	public static void main(String[] args) {
		ArrayList<Integer> i = new ArrayList<>();
		i.add(1);
		i.add(3);
		i.add(2);
		System.out.println(i);
		Collections.sort(i, Collections.reverseOrder());
		System.out.println(i);
		Collections.reverse(i);
		System.out.println(i);
		Collections.sort(i);
		System.out.println(i);
		
	}
	
 }
