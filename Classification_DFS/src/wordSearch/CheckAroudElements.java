package wordSearch;
//VIII
//这个是比较简单的DFS的问题，就是按照一个已经走过的点，然后看下一个字母在上下左右存不存在，
//要注意的几点，一个是上下左右有没有超过边界，一个是这个格子有没有被访问过，还有一个就是这个格子的字母和要找的字母相不相同
//base case 是index 到达尾部，也就是到达length 的位置。
//用一个等同的二维数组来储存里面的有没有访问过，然后DFS的时候进去之前标记一下，出来之后取消。
//一点优化就是一旦有了true 之后直接返回。不要看其他的了，如果上下左右都不行就返回false
//开始第一个是在二维数组里面里面进行遍历，遇到一个同样也是先标记，然后进到下一个，如果成功就直接返回，如果不成功取消标记，找下一个。
//最后全部不行就返回false

//不能忘记检查visited 的情况，自己写的时候因为条件太多忘记了。
public class CheckAroudElements {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        
        if (word == null || word.length() == 0) {
            return true;
        }
        
        int row = board.length;
        int column = board[0].length;
        
        boolean[][] visited = new boolean[row][column];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (helper(board, visited, 1, word, i, j)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        
        return false;
    }
    
    
    private boolean helper(char[][] board, boolean[][] visited, int depth, String word, int r, int c) {
        if (depth == word.length()) {
            return true;
        } else {
            int row = board.length;
            int column = board[0].length;
            
            if (r - 1 >= 0 && board[r - 1][c] == word.charAt(depth) && !visited[r - 1][c]) {
                visited[r - 1][c] = true;
                if (helper(board, visited, depth + 1, word, r - 1, c)) {
                    return true;
                }
                visited[r - 1][c] = false;
            }
            
            if (r + 1 < row && board[r + 1][c] == word.charAt(depth) && !visited[r + 1][c]) {
                visited[r + 1][c] = true;
                if (helper(board, visited, depth + 1, word, r + 1, c)) {
                    return true;
                }
                visited[r + 1][c] = false;
            }
            
            if (c - 1 >= 0 && board[r][c - 1] == word.charAt(depth) && !visited[r][c - 1]) {
                visited[r][c - 1] = true;
                if (helper(board, visited, depth + 1, word, r, c - 1)) {
                    return true;
                }
                visited[r][c - 1] = false;
            }
            
            if (c + 1 < column && board[r][c + 1] == word.charAt(depth) && !visited[r][c + 1]) {
                visited[r][c + 1] = true;
                if (helper(board, visited, depth + 1, word, r, c + 1)) {
                    return true;
                }
                visited[r][c + 1] = false;
            }
            
            return false;
        }
    }
}
