import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    //动态规划，dp[i]代表nums前i个数字的最长子序列长度
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len + 1];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 动态规划 + 二分查找
     * tails[k]代表长度为k + 1的子序列尾部元素的值，如[1,4,6]，长度为1,2,3的子序列尾部元素分别为tails=[1,4,6]
     * 设res为tails的当前长度，代表直到当前的最长上升子序列长度，设0 <= j < res，考虑每轮遍历nums[k]时，通过二分法遍历[0,res)列表区间，找出nums[k]的大小分界点，会出现2种情况：
     * 1、区间中存在tails[i] > nums[k]：将第一个满足tails[i] > nums[k]执行tails[i] = nums[k]；因为更小的nums[k]后更可能接一个比它大的数字
     * 2、区间中不存在tails[i] > nums[k]： 意味着nums[k]可以接在前面所有长度的子序列之后，因此肯定是接到最长的后面（长度为res），新子序列长度为 res + 1
     */
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] tails = new int[len];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            while (i < j) {
                int mid = (i + j) / 2;
                if (tails[mid] < num) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            tails[i] = num;
            if (res == j) {
                res++;
            }
        }
        return res;
    }

}
