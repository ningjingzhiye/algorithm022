public class Solution {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //d[i]：以s[i]结尾的前缀子串的解码方法个数
        int[] dp = new int[s.length()];
        char[] charArray = s.toCharArray();
        //如果第一个字母为0，直接返回0
        if (charArray[0] == '0') {
            return 0;
        }
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            //如果s[i] == '0'，字符s[i]就不能单独解码
            if (charArray[i] != '0') {
                dp[i] = dp[i - 1];
            }
            int num = 10 * (charArray[i - 1] - '0') + (charArray[i] - '0');
            //如果当前字符和前一个字符组合能够解码（10 <= num <= 26），dp[i] += dp[i - 2] * 1（需判断i >= 2）
            if (num >= 10 && num <= 26) {
                if (i == 1) {
                    dp[i]++;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[s.length() - 1];
    }

}
