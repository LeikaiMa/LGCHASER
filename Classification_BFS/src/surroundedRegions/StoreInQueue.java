package surroundedRegions;
// II
//BFS的好处在于不需要递归很深。
//用的数据结构是linkedlist 是一个queue ，存的时候用add 取的时候用的是poll
//开始的时候先看四条最外围的边，如果是O 就加到list 里面。 因为是要存row 和column 所以用两个list 一起进行，也可以用一个list 把两个wrap 起来。
//而且如果访问过的话可以把他标记成另外一个字母，因为原来的数据是可以进行修改的
//最后完全结束之后，将没有访问到的转成X， 访问过的Y 还原成O 这样比较的巧妙。
import java.util.LinkedList;
import java.util.Queue;

// 这里要注意的一个是从四条边开始往内进行变换，而不是一行一行，看周围有没有Y， 因为有可能是从下面演变上来的
// 还有最好不用DFS，因为这个递归比较深，而且这个也不需要输出最后结果，而是在这个上面进行直接改。所以用BFS 进行poll 出来执行。
public class StoreInQueue {
	public void solve(char[][] board) {
		if (board.length == 0) {
			return;
		}
		int row = board.length;
		int column = board[0].length;

		Queue<Integer> r = new LinkedList<Integer>();
		Queue<Integer> c = new LinkedList<Integer>();

		for (int i = 0; i < row; i++) {
			if (board[i][0] == 'O') {
				board[i][0] = 'Y';
				r.add(i);
				c.add(0);
			}

			if (board[i][column - 1] == 'O') {
				board[i][column - 1] = 'Y';
				r.add(i);
				c.add(column - 1);
			}
		}

		for (int j = 0; j < column; j++) {
			if (board[0][j] == 'O') {
				board[0][j] = 'Y';
				r.add(0);
				c.add(j);
			}

			if (board[row - 1][j] == 'O') {
				board[row - 1][j] = 'Y';
				r.add(row - 1);
				c.add(j);
			}
		}

		while (!r.isEmpty()) {
			int i = r.poll();
			int j = c.poll();

			if (i - 1 >= 0 && board[i - 1][j] == 'O') {
				board[i - 1][j] = 'Y';
				r.add(i - 1);
				c.add(j);
			}

			if (i + 1 < row && board[i + 1][j] == 'O') {
				board[i + 1][j] = 'Y';
				r.add(i + 1);
				c.add(j);
			}

			if (j - 1 >= 0 && board[i][j - 1] == 'O') {
				board[i][j - 1] = 'Y';
				r.add(i);
				c.add(j - 1);
			}

			if (j + 1 < column && board[i][j + 1] == 'O') {
				board[i][j + 1] = 'Y';
				r.add(i);
				c.add(j + 1);
			}

		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == 'Y') {
					board[i][j] = 'O';
				}
			}
		}

	}
}
