package ticTacToe;
// 同样是要先判断是否有，然后再分别判断是否横竖斜相同。
// 如果没有一个成功，就返回empty 
// 如果有一个相同，就立刻返回
public class SimpleBoard {
	public Piece hasWon(Piece[][] board) {
		for (int i = 0; i < board.length; i++) {
			if (board[i][0] != Piece.Empty && board[i][0] == board[i][1]
					&& board[i][1] == board[1][2]) {
				return board[i][0];
			}

			if (board[0][i] != Piece.Empty && board[0][i] == board[1][i]
					&& board[0][i] == board[2][i]) {
				return board[0][i];
			}
		}

		if (board[0][0] != Piece.Empty && board[0][0] == board[1][1]
				&& board[0][0] == board[2][2]) {
			return board[0][0];
		}

		if (board[2][0] != Piece.Empty && board[2][0] == board[1][1]
				&& board[2][0] == board[0][2]) {
			return board[2][0];
		}
		
		return Piece.Empty;
	}
}
