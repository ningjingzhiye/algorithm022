import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 0 || k > n) {
            return res;
        }
        dfs(n, k, 1, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int n, int k, int begin, List<Integer> path, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i <= n - k + 1; i++) {
            path.add(i);
            dfs(n, k - 1, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }

}
