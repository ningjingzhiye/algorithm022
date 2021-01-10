public class Solution {

    /**
     * 使用二分查找
     * 1、当nums[mid] == target时，直接返回mid；
     * 2、当nums[mid] < nums[right]时，说明从mid到right之间是有序的，此时如果nums[mid] < target <= nums[right]，
     * 则在右半部分查找，left = mid + 1，否则就在左半部分查找，right = mid - 1
     * 3、当nums[mid] >= nums[right]时，说明从left到mid之间是有序的，此时如果nums[left] <= target < nums[mid]，
     * 则在左半部分查找，right = mid - 1，否则就在右半部分查找，right = mid + 1
     * */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

}
