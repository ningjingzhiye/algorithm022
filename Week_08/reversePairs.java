public class Solution {

    public int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] numsSorted = new int[nums.length];
        return mergeSort(nums, numsSorted, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int[] numsSorted, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = (left + right) / 2;
        int res = mergeSort(nums, numsSorted, left, mid) +
                mergeSort(nums, numsSorted, mid + 1, right) +
                findReversedPairs(nums, left, right);
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                numsSorted[k++] = nums[i++];
            } else {
                numsSorted[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            numsSorted[k++] = nums[i++];
        }
        while (j <= right) {
            numsSorted[k++] = nums[j++];
        }
        if (right - left + 1 >= 0) {
            System.arraycopy(numsSorted, left, nums, left, right - left + 1);
        }
        return res;
    }

    private int findReversedPairs(int[] nums, int left, int right) {
        int res = 0, mid = (left + right) / 2;
        int i = left, j = mid + 1;
        for (; i <= mid; i++) {
            while (j <= right && (long) nums[i] > 2 * (long) nums[j]) {
                res += mid - i + 1;
                j++;
            }
        }
        return res;
    }

}
