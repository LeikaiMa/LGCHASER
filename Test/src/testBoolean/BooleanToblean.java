package testBoolean;
// 不能直接用Boolean而不判断是不是null 虽然他给了第三个可以用的比较参量。
// 但是这个也引进了新的要比较null 的条件
public class BooleanToblean {
	public static void main(String[] args) {
		boolean b = getBoolean();
		System.out.println(b);
	}

	private static boolean getBoolean() {
		Boolean[] b = new Boolean[1];
		return b[0];
	}
	
	
}
