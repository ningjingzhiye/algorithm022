public class Solution {

    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] block = new int[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '1';
                int index = i / 3 * 3 + j / 3;
                if (rows[i][num] != 1 && cols[j][num] != 1 && block[index][num] != 1) {
                    rows[i][num] = 1;
                    cols[j][num] = 1;
                    block[index][num] = 1;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
