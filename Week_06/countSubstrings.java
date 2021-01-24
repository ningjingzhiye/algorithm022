public class Solution {

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                //下标i和j相同或相差1，如a、aa，属于回文字符串；
                //i与j相差大于1时，如cabac，此时s[i]与s[j]已经相同了，我们看i到j区间是不是回文子串就看aba是不是回文，aba的区间就是i+1到j-1，主要就是看dp[i + 1][j - 1]是否为true
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        res++;
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {
                        res++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        return res;
    }

    public int countSubstrings2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //中心扩展法
        int res = 0;
        int len = s.length();
        for (int i = 0; i < 2 * len - 1; i++) {
            int left = i / 2, right = left + i % 2;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                --left;
                ++right;
                ++res;
            }
        }
        return res;
    }

}
