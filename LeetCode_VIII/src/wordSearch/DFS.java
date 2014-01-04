package wordSearch;
// 这个是比较简单的DFS的问题，就是按照一个已经走过的点，然后看下一个字母在上下左右存不存在，
// 要注意的几点，一个是上下左右有没有超过边界，一个是这个格子有没有被访问过，还有一个就是这个格子的字母和要找的字母相不相同
// base case 是index 到达尾部，也就是到达length 的位置。
// 用一个等同的二维数组来储存里面的有没有访问过，然后DFS的时候进去之前标记一下，出来之后取消。
// 一点优化就是一旦有了true 之后直接返回。不要看其他的了，如果上下左右都不行就返回false
// 开始第一个是在二维数组里面里面进行遍历，遇到一个同样也是先标记，然后进到下一个，如果成功就直接返回，如果不成功取消标记，找下一个。
// 最后全部不行就返回false
public class DFS {
	public static boolean exist(char[][] board, String word) {
		if (word == null || word.isEmpty()) {
			return true;
		}
		int row = board.length;
		int column = board[0].length;
		boolean[][] visited = new boolean[row][column];
		char c = word.charAt(0);
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (c == board[i][j]) {
					visited[i][j] = true;
					if (existHelper(board, visited, i, j, word, 1)) {
						return true;
					}
					visited[i][j] = false;
				}
			}
		}
		return false;
	}

	private static boolean existHelper(char[][] board, boolean[][] visited, int i,
			int j, String word, int index) {
		if (index == word.length()) {
			return true;
		}
		int row = board.length;
		int column = board[0].length;
		char c = word.charAt(index);
		if (i - 1 >= 0 && !visited[i - 1][j] && c == board[i - 1][j]) {
			visited[i - 1][j] = true;
			if (existHelper(board, visited, i - 1, j, word, index + 1)) {
				return true;
			}
			visited[i - 1][j] = false;
		}

		if (i + 1 < row && !visited[i + 1][j] && c == board[i + 1][j]) {
			visited[i + 1][j] = true;
			if (existHelper(board, visited, i + 1, j, word, index + 1)) {
				return true;
			}
			visited[i + 1][j] = false;
		}

		if (j - 1 >= 0 && !visited[i][j - 1] && c == board[i][j - 1]) {
			visited[i][j - 1] = true;
			if (existHelper(board, visited, i, j - 1, word, index + 1)) {
				return true;
			}
			visited[i][j - 1] = false;
		}

		if (j + 1 < column && !visited[i][j + 1] && c == board[i][j + 1]) {
			visited[i][j + 1] = true;
			if (existHelper(board, visited, i, j + 1, word, index + 1)) {
				return true;
			}
			visited[i][j + 1] = false;
		}

		return false;
	}
	
	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCB";
		System.out.println(exist(board, word));
		
	}
}
