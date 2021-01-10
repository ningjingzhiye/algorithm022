public class Solution {

    //使用二分查找
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;
        int res = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                res = Math.min(res, nums[mid]);
                right = mid - 1;
            } else {
                res = Math.min(res, nums[left]);
                left = mid + 1;
            }
        }
        return res;
    }

}
