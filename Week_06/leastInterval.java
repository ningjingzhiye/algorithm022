public class Solution {

    /**
     * 桶排序法：
     * 先摆放任务个数多的，从上到下，从左到右，执行顺序按照从左到右、从上到下
     * 最短时间：在填不满桶时，最短时间为(n + 1) * (max - 1) + maxCount， 也就是桶的大小；
     *         在桶放不下时，最短时间就是tasks.length
     */
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char c: tasks) {
            counts[c - 'A']++;
        }
        int max = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, counts[i]);
        }
        int tmp = (max - 1) * (n + 1);
        for (int i = 0; i < 26; i++) {
            if (counts[i] == max) {
                tmp++;
            }
        }
        return Math.max(tmp, tasks.length);
    }

}
