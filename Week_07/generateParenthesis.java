import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(0, 0, n, "", res);
        return res;
    }

    private void dfs(int left, int right, int n, String tmp, List<String> res) {
        if (left == n && right == n) {
            res.add(tmp);
            return;
        }
        if (left < n) {
            dfs(left + 1, right, n, tmp + "(", res);
        }
        if (right < left) {
            dfs(left, right + 1, n, tmp + ")", res);
        }
    }

}
