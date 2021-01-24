public class Solution {

    /**
     * dp[i]：以下标为i的字符结尾的最长有效子字符串的长度
     * s[i] == '('，则dp[i] = 0；
     * s[i] == ')'
     *（1）如果s[i-1] == '('，dp[i] = dp[i-2] + 2；
     * (2）s[i-1] = ')'，如果dp[i-1] > 0，可能是((...))的形式，判断s[i-dp[i-1]-1] = '('，dp[i] = dp[i-1] + 2，
     * 如果((...))前面还有独立的有效括号序列，如()((...))，还需要加上i-dp[i-1]-1下标之前的最大有效序列长度，
     * 即dp[i] = dp[i−1] + 2 + dp[i−dp[i−1]−2]
     * */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2;
                    if (i > 2) {
                        dp[i] += dp[i - 2];
                    }
                } else if (dp[i - 1] > 0) {
                    if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + 2;
                        if (i - dp[i - 1] - 2 >= 0) {
                            dp[i] += dp[i - dp[i - 1] - 2];
                        }
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
