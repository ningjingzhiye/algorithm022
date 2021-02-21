public class Solution {

    /**
     * dp[i][j]： 表示word1的前i个字母和word2的前j个字母之间的编辑距离
     * 1、若word1和word2的最后一个字母相同，则dp[i][j] = dp[i - 1][j - 1]
     * 2、若word1和word2的最后一个字母不同，则dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
     * */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        int n = word1.length();
        int m = word2.length();
        if (n == 0 || m == 0) {
            return m + n;
        }
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[n][m];
    }

}
