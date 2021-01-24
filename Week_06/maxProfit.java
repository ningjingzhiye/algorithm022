import java.util.List;

public class Solution {

    public int rob(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        //如果偷第一个屋子，最多只能偷到倒数第2个屋子；如果不偷第一个屋子，则能偷到最后一个屋子
        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }

    private int robHelper(int[] nums, int begin, int end) {
        int steal = 0, noSteal = 0;
        for (int i = begin; i <= end; i++) {
            int tmp = steal;
            steal = noSteal + nums[i];
            noSteal = Math.max(noSteal, tmp);
        }
        return Math.max(steal, noSteal);
    }

}
