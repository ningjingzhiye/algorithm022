import java.util.List;

public class Solution {

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int iMax = 1, iMin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = iMax;
                iMax = iMin;
                iMin = tmp;
            }
            iMax = Math.max(iMax * nums[i], nums[i]);
            iMin = Math.min(iMin * nums[i], nums[i]);
            max = Math.max(max, iMax);
        }
        return max;
    }

}
