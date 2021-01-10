public class Solution {

    //牛顿迭代法
    public int mySqrt(int x) {
        long a = x;
        while (a * a > x) {
            a = (a + x / a) / 2;
        }
        return (int) a;
    }

    //二分法
    public int mySqrt2(int x) {
        if (x <= 1) {
            return x;
        }
        int left = 0, right = x;
        int res = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ((long) mid * mid <= x) {
                left = mid + 1;
                res = mid;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

}
