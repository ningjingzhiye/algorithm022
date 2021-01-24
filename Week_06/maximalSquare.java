public class Solution {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix[0].length == 0) {
            return 0;
        }
        int maxSide = 0;
        int row = matrix.length, col = matrix[0].length;
        //dp[i][j]: 以(i,j)为右下角，且只包含1的正方形的边长最大值
        //matrix[i][j] == 0, dp[i][j] = 0; matrix[i][j] = 1, dp[i][j] = min(dp[i−1][j],dp[i−1][j−1],dp[i][j−1]) + 1
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }

}
