public class Solution {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0) {
                    dp[i][j] = j > 0 ? dp[i][j - 1] + grid[i][j] : grid[0][0];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[row - 1][col - 1];
    }

}
