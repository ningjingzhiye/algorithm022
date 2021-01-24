public class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        int len1 = t1.length;
        int len2 = t2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (t1[i - 1] == t2[j - 1]) {
                    //去找它们前面各退一格的值加1即可
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //要么是text1往前退一格，要么是text2往前退一格，两个的最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }

}
