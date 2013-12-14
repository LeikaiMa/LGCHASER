package findElementInMatrix;
// 如果将左上角定义为origin 右下角定义为dest 则，每个右下角都是最大值。
// 可以利用这特性进行二分法，得到比自己第一大的值。
// 然后可以可以找左下角和右上角相应的递归。
// 可以记住是可以调到另外一个函数里，然后在另外一个函数里调用自己。可以使代码更加清晰。可以多次进行调用，但是只返回一个值。
// 对角线上要注意的是因为不一定是正方形，所以所以取对角线需要取min 这样才是真正的对角线。

public class BinarySearch {

	public static Coordinate findElement(int[][] matrix, Coordinate origin,
			Coordinate dest, int x) {
		if (!origin.inbounds(matrix) || !dest.inbounds(matrix)) {
			return null;
		}
		if (matrix[origin.row][origin.column] == x) {
			return origin;
		} else if (!origin.isBefore(dest)) {
			return null;
		}

		Coordinate start = (Coordinate) origin.clone();

		int diagDist = Math.min(dest.row - origin.row, dest.column
				- origin.column);

		Coordinate end = new Coordinate(start.row + diagDist, start.column
				+ diagDist);
		Coordinate p = new Coordinate(0, 0);

		while (start.isBefore(end)) {
			p.setToAverage(start, end);
			if (x > matrix[p.row][p.column]) {
				start.row = p.row + 1;
				start.column = p.column + 1;
			} else {
				end.row = p.row - 1;
				end.column = p.column - 1;
			}
		}

		return partitionAndSearch(matrix, origin, dest, start, x);
	}

	public static Coordinate partitionAndSearch(int[][] matrix,
			Coordinate origin, Coordinate dest, Coordinate pivot, int elem) {
		Coordinate lowerLeftOrigin = new Coordinate(pivot.row, origin.column);
		Coordinate lowerLeftDest = new Coordinate(dest.row, pivot.column - 1);
		Coordinate upperRightOrigin = new Coordinate(origin.row, pivot.column);
		Coordinate upperRightDest = new Coordinate(pivot.row - 1, dest.column);

		Coordinate lowerLeft = findElement(matrix, lowerLeftOrigin,
				lowerLeftDest, elem);
		if (lowerLeft == null) {
			return findElement(matrix, upperRightOrigin, upperRightDest, elem);
		}
		return lowerLeft;
	}

	public static Coordinate findElement(int[][] matrix, int x) {
		Coordinate origin = new Coordinate(0, 0);
		Coordinate dest = new Coordinate(matrix.length - 1,
				matrix[0].length - 1);
		return findElement(matrix, origin, dest, x);
	}
}
