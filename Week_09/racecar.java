import java.util.Arrays;

public class Solution {

    /**
     * position的变化规律：0->1->3->7->15
     * speed的变化规律：   1->2->4->8->16
     * position的变化规律就是2^k - 1(k = 0,1,2,3,4)
     * 设dp[i]：target == i时需要的最小步数。
     * 基于这个规律，到达i一共有三种可能的情况：
     * 1、i = 2^k - 1，只需要执行k个A就可以到达，dp[i] = k；
     * 2、连续执行k个A到达2^k - 1，然后R掉头，再后退2^k - 1 - i步，dp[i] = min(dp[i], k + 1 + dp[2^k - 1 - i])；
     * 3、连续执行k-1个A到达2^(k - 1) - 1，然后R掉头，再后退一定的步数back（0,1...,k-2），再前进(需要一个R)
     * dp[i] = min(dp[i], k - 1 + 2 + back + dp[i + (2^back - 2 ^ (k-1))])
     */
    public int racecar(int target) {
        if (target <= 0) {
            return 0;
        }
        int[] dp = new int[target + 2];
        dp[1] = 1;
        dp[2] = 4;
        int k = 2;
        int S = 3; // S记录连续k个A指令，达到的位置
        for (int i = 3; i <= target; i++) {
            if (i == S) {
                dp[i] = k++;
                S = (1 << k) - 1;
            } else {
                dp[i] = k + 1 + dp[S - i];
                for (int back = 0; back <= k - 2; back++) {
                    int distance = i + (1 << back) - (1 << (k - 1));
                    dp[i] = Math.min(dp[i], (k - 1) + 2 + back + dp[distance]);
                }
            }
        }
        return dp[target];
    }

    public int racecar2(int target) {
        if (target <= 0) {
            return 0;
        }
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1; i <= target; i++) {
            for (int forward = 1; (1 << forward) - 1 < 2 * i; forward++) {
                int forwardDistance = (1 << forward) - 1;
                if (forwardDistance == i) {
                    dp[i] = forward;
                } else if (forwardDistance > i) {
                    dp[i] = Math.min(dp[i], forward + 1 + dp[forwardDistance - i]);
                } else {
                    for (int back = 0; back < forward; back++) {
                        int backDistance = (1 << back) - 1;
                        dp[i] = Math.min(dp[i], forward + 2 + back + dp[i + backDistance - forwardDistance]);
                    }
                }
            }
        }
        return dp[target];
    }

}
