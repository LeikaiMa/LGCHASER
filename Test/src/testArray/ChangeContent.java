package testArray;

public class ChangeContent {
	private static void change(char[][] a) {
//		char[][] b = new char[9][9];
//		b = a.clone();
//		b[0][0] = '1';
		a[0][0] = '1';
	}

	public static void main(String[] args) {
		char[][] a = new char[9][9];
		change(a);
		System.out.println(a[0][0]);
	}

}
