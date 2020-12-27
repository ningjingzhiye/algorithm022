public class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int tmp2 = 0, tmp3 = 0, tmp5 = 0;
        for (int i = 1; i < n; i++) {
            int t1 = dp[tmp2] * 2;
            int t2 = dp[tmp3] * 3;
            int t3 = dp[tmp5] * 5;
            dp[i] = Math.min(Math.min(t1, t2), t3);
            if (dp[i] == t1) {
                tmp2++;
            }
            if (dp[i] == t2) {
                tmp3++;
            }
            if (dp[i] == t3) {
                tmp5++;
            }
        }
        return dp[n - 1];
    }

}
