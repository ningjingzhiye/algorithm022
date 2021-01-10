import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {

    /**
     *  使用贪心算法，先将孩子的胃口值以及饼干尺寸数组按从小到大的顺序进行排序，
     *  然后从前往后遍历饼干数组，优先满足小胃口的孩子
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] >= g[index]) {
                index++;
                if (index == g.length) {
                    break;
                }
            }
        }
        return index;
    }

}
