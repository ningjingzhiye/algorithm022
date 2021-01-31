public class Solution {

    private boolean[][] rows = new boolean[9][9];
    private boolean[][] cols = new boolean[9][9];
    private boolean[][][] block = new boolean[3][3][9];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    rows[i][num] = true;
                    cols[j][num] = true;
                    block[i / 3][j / 3][num] = true;
                }
            }
        }
        dfs(board, 0, 0);
    }

    private boolean dfs(char[][] board, int x, int y) {
        if (y == 9) {
            return dfs(board, x + 1, 0);
        }
        if (x == 9) {
            return true;
        }
        if (board[x][y] != '.') {
            return dfs(board, x, y + 1);
        }
        for (int i = 0; i < 9; i++) {
            if (!rows[x][i] && !cols[y][i] && !block[x / 3][y / 3][i]) {
                board[x][y] = (char) (i + '1');
                rows[x][i] = true;
                cols[y][i] = true;
                block[x / 3][y / 3][i] = true;
                if (dfs(board, x, y + 1)) {
                    break;
                } else {
                    board[x][y] = '.';
                    rows[x][i] = false;
                    cols[y][i] = false;
                    block[x / 3][y / 3][i] = false;
                }
            }
        }
        return board[x][y] != '.';
    }

}
