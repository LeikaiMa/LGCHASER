package surroundedSquare;
// 之前每次判断的时候需要遍历四条边，看有没有白色，这个是很费时间的。
// 可以进行预处理，让每个cell 里面记录右边和下边总共最长有多少个连续的黑色。这样可以在最后确定四个角能不能形成一个黑圈包围的，只需看四个角就可以了。
// 因为是看右下的情况，所以填的时候从右下开始，然后从下至上。如果是白色的就直接标记为0如果是黑色的就要在本身为1的情况下加上右边或者下面的原有的。
// 这里面要排除的是看是不是最右或者最下，因为没有更右或者是更下。这样把加起来的值存到一个cell 里面。 形成cell 的一个二维数组，这样能够变成预处理之后的二维数组。
// 然后还是和之前一样，从最大的开始，一直到1。然后在里面寻找所有的能够是这个size 的square
// 然后进行check 这个square 是不是存在，如果存在直接返回。如果到最后还没有，就返回空。
// 在check 时候check 左上的右和下是不是超过或者等于size 的大小。右上的下是不是超过或等于。左下的右是不是超过或者等于。
// 如果有一个不对就直接返回false 如果都能够通过就返回true

public class PreProcessing {
	Subsquare findSquare(int[][] matrix) {
		SquareCell[][] processed = processSquare(matrix);
		for (int i = matrix.length; i >= 1; i--) {
			Subsquare square = findSquareWithSize(processed, i);
			if (square != null) {
				return square;
			}
		}
		return null;
	}

	private Subsquare findSquareWithSize(SquareCell[][] processed,
			int squareSize) {
		int count = processed.length - squareSize + 1;

		for (int row = 0; row < count; row++) {
			for (int col = 0; col < count; col++) {
				if (isSquare(processed, row, col, squareSize)) {
					return new Subsquare(row, col, squareSize);
				}
			}
		}

		return null;
	}

	private boolean isSquare(SquareCell[][] matrix, int row, int col, int size) {
		SquareCell topLeft = matrix[row][col];
		SquareCell topRight = matrix[row][col + size - 1];
		SquareCell bottomLeft = matrix[row + size - 1][col];
		if (topLeft.zerosRight < size) {
			return false;
		}
		if (topLeft.zerosBelow < size) {
			return false;
		}
		if (topRight.zerosBelow < size) {
			return false;
		}
		if (bottomLeft.zerosRight < size) {
			return false;
		}

		return true;

	}

	SquareCell[][] processSquare(int[][] matrix) {
		SquareCell[][] processed = new SquareCell[matrix.length][matrix.length];

		for (int r = matrix.length - 1; r >= 0; r--) {
			for (int c = matrix.length - 1; c >= 0; c--) {
				int rightZeros = 0;
				int belowZeros = 0;

				if (matrix[r][c] == 0) {
					rightZeros++;
					belowZeros++;

					if (c + 1 < matrix.length) {
						SquareCell previous = processed[r][c + 1];
						rightZeros += previous.zerosRight;
					}

					if (r + 1 < matrix.length) {
						SquareCell previous = processed[r + 1][c];
						belowZeros += previous.zerosBelow;
					}
				}
				processed[r][c] = new SquareCell(rightZeros, belowZeros);
			}
		}
		return processed;
	}
}
