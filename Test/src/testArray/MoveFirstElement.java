package testArray;

// 在java 中不能像C 或者C++ 一样直接在地址上进行相加。这个时候可以将start 和end 都当做参量输进去，这样就可以既得到长度也得到起始点了
public class MoveFirstElement {
	public static void main(String[] args) {
		int[] A = { 1, 2, 3 };
		System.out.println(A[0]);

	}
}
