package pascalTriangleII;

import java.util.ArrayList;
// 就是在最后面插上一个1，然后从倒数第二开始，将自己和前面一个相加，然后将自己重置。更加快
public class O1way {
	public  static ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> row = new ArrayList<Integer>();
		for (int i = 0; i <= rowIndex; i++) {
			row.add(1);
			for (int j = i -1; j > 0; j--) {
				row.set(j, row.get(j) + row.get(j -1));
			}
		}
		return row;
	}
	public static void main(String[] args) {
		System.out.println(getRow(0));
	}
}
