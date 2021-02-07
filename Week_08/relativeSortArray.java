public class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] tmp = new int[1001];
        for (int num : arr1) {
            tmp[num]++;
        }
        int pos = 0;
        for (int num : arr2) {
            while (tmp[num] > 0) {
                arr1[pos++] = num;
                tmp[num]--;
            }
        }
        for (int i = 0; i < 1001; i++) {
            while (tmp[i] > 0) {
                arr1[pos++] = i;
                tmp[i]--;
            }
        }
        return arr1;
    }
}
