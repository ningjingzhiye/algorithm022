public class Solution {

    //贪心
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int rightBorder = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= rightBorder) {
                rightBorder = Math.max(rightBorder, i + nums[i]);
                if (rightBorder >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
