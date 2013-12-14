package findElementInMatrix;
// 如果要复制这个，可以用clone 但是需要implement cloneable 然后return 新建本身。
public class Coordinate implements Cloneable {
	public int row;
	public int column;

	public Coordinate(int r, int c) {
		row = r;
		column = c;
	}

	public boolean inbounds(int[][] matrix) {
		return row >= 0 && column >= 0 && row < matrix.length
				&& column < matrix[0].length;
	}

	public boolean isBefore(Coordinate p) {
		return row <= p.row && column <= p.column;
	}

	public Object clone() {
		return new Coordinate(row, column);
	}

	public void setToAverage(Coordinate min, Coordinate max) {
		row = (min.row + max.row) / 2;
		column = (min.column + max.column) / 2;
	}
}
