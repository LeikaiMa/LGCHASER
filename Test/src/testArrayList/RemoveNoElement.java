package testArrayList;

import java.util.ArrayList;
// 不能remove 没有的值。
public class RemoveNoElement {

	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.remove(0);
	}

}
