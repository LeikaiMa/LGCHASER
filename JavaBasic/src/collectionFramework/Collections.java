package collectionFramework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;
// arraylist 是动态的array
// vector是类似arraylist 的东西，但是他是synchronized
public class Collections {
	public static void main(String[] args) {
		ArrayList<String> myArr = new ArrayList<String>();
		myArr.add("One");
		myArr.add("Two");
		System.out.println(myArr.get(0));
		
		Vector<String> myVect = new Vector<String>();
		myVect.add("one");
		myVect.add("two");
		System.out.println(myVect.get(0));
		
		LinkedList<String> myLinkedList = new LinkedList<String>();
		myLinkedList.add("two");
		myLinkedList.addFirst("one");
		Iterator<String> iter = myLinkedList.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("one", "uno");
		map.put("two", "dos");
		System.out.println(map.get("one"));
	}
}
