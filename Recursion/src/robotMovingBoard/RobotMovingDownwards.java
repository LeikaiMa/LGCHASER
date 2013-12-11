package robotMovingBoard;
// 这个问题实际上进行解决实际上可以直接用数学方法进行解决
// 总共是X+Y步，要在这么多步里面挑 X 步
// 简化来讲是一个组合问题
// (X+Y)! / (X!Y!)
public class RobotMovingDownwards {
	public static int move(int x, int y) {
		if (x == 1 && y == 1) {
			return 1;
		} else if (x > 1 && y == 1) {
			return move(x - 1, y);
		} else if (x == 1 && y > 1) {
			return move(x, y - 1);
		} else {
			return move(x - 1, y) + move(x, y - 1);
		}
	}

	public static void main(String[] args) {
		int x = 2;
		int y = 2;
		System.out.println(move(x, y));
	}
}
