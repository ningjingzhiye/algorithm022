public class Solution {

    /**
     * dp[i][j]：表示s的前i个字符是否能被p的前j个字符匹配
     * 1、p.charAt(j) == s.charAt(i)，dp[i][j] = dp[i - 1][j - 1];
     * 2、p.charAt(j) == '.'，dp[i][j] = dp[i - 1][j - 1];
     * 3、p.charAt(j) == '*'，
     * （1）如果p.charAt(j - 1) != s.charAt(i)，dp[i][j] = dp[i][j - 2];
     * （2）如果p.charAt(i - 1) == s.charAt(i) || p.charAt(i - 1) == '.',
     *  dp[i][j] = dp[i - 1][j] //a*当做多个a
     *  dp[i][j] = dp[i][j - 1] //a*当做单个a
     *  dp[i][j] = dp[i][j - 2] //a*当做空
     * */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        //奇数位不管什么字符都是false，偶数位为*时: dp[0][i] = dp[0][i - 2]
        for (int i = 2; i <= n; i+= 2) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (j >= 2 && p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || (j >= 2 && dp[i][j - 2]);
                    }
                }
            }
        }
        return dp[m][n];
    }

}
