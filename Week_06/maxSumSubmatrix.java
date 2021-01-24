public class Solution {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length, col = matrix[0].length;
        int max = Integer.MIN_VALUE;
        //枚举左边界
        for (int l = 0; l < col; l++) {
            //左边界改变才算区域的重新开始
            int[] rowSum = new int[row];
            //枚举右边界
            for (int r = l; r < col; r++) {
                //按每行累计到dp
                for (int i = 0; i < row; i++) {
                    rowSum[i] += matrix[i][r];
                }
                max = Math.max(max, dpMax(rowSum, k));
            }
        }
        return max;
    }

    //在数组arr中求不超过k的最大值
    private int dpMax(int[] arr, int k) {
        int rollSum = arr[0], rollMax = rollSum;
        for (int i = 1; i < arr.length; i++) {
            if (rollSum > 0) {
                rollSum += arr[i];
            } else {
                rollSum = arr[i];
            }
            if (rollSum > rollMax) {
                rollMax = rollSum;
            }
        }
        if (rollMax <= k) {
            return rollMax;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum > max && sum <= k) {
                    max = sum;
                }
                if (max == k) {
                    return k;
                }
            }
        }
        return max;
    }

}
