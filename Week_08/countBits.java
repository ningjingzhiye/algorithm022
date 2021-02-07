public class Solution {

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = getCount(i);
        }
        return res;
    }

    private int getCount(int x) {
        int count = 0;
        for (count = 0; x != 0; ++count) {
            x &= x - 1;
        }
        return count;
    }

}
