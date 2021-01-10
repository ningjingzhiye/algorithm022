import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {

    /**
     *  使用贪心算法，先将孩子的胃口值以及饼干尺寸数组按从小到大的顺序进行排序，
     *  然后从后往前遍历小孩数组，优先满足大胃口的孩子
     */
    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = s.length - 1;
        int res = 0;
        for (int i = g.length - 1; i >= 0; i--) {
            if (index > 0 && s[index] >= g[i]) {
                res++;
                index--;
            }
        }
        return res;
    }

}
