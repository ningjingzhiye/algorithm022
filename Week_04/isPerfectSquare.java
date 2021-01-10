public class Solution {

    //牛顿迭代法
    public boolean isPerfectSquare(int num) {
        long tmp = num;
        while (tmp * tmp > num) {
            tmp = (tmp + num / tmp) / 2;
        }
        return tmp * tmp == num;
    }

    //二分法
    public boolean isPerfectSquare2(int num) {
        if (num <= 1) {
            return true;
        }
        int left = 0, right = num;
        int res = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ((long) mid * mid <= num) {
                left = mid + 1;
                res = mid;
            } else {
                right = mid - 1;
            }
        }
        return res * res == num;
    }

}
