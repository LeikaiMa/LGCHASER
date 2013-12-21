package testArrayList;
// 说明null 加入arraylist 也是可以占一个空间
import java.util.ArrayList;

public class AddNullToArraylist {
	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add(null);
		System.out.println(arrayList.size());
	}
}	
